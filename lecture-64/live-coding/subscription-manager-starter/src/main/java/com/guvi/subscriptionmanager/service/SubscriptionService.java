package com.guvi.subscriptionmanager.service;

import com.guvi.subscriptionmanager.exception.BusinessConflictException;
import com.guvi.subscriptionmanager.exception.ResourceNotFoundException;
import com.guvi.subscriptionmanager.model.*;
import com.guvi.subscriptionmanager.repo.InvoiceRepository;
import com.guvi.subscriptionmanager.repo.PlanRepository;
import com.guvi.subscriptionmanager.repo.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final PlanRepository planRepository;
    private final InvoiceRepository invoiceRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,
                               PlanRepository planRepository,
                               InvoiceRepository invoiceRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.planRepository = planRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public Subscription subscribe(Long userId, String planCode, boolean autoRenew) {
        if (subscriptionRepository.findActiveByUserId(userId).isPresent()) {
            throw new BusinessConflictException("You already have an active subscription");
        }

        Plan plan = planRepository.findByPlanCode(planCode)
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found: " + planCode));

        if (!plan.isActive()) {
            throw new BusinessConflictException("Plan is not active: " + planCode);
        }

        LocalDate start = LocalDate.now();
        LocalDate end = calculateEndDate(start, plan.getBillingCycle());

        LocalDateTime now = LocalDateTime.now();

        Subscription sub = new Subscription();
        sub.setUserId(userId);
        sub.setPlanCode(plan.getPlanCode());
        sub.setStatus(SubscriptionStatus.ACTIVE);
        sub.setStartDate(start);
        sub.setEndDate(end);
        sub.setAutoRenew(autoRenew);
        sub.setCreatedAt(now);
        sub.setUpdatedAt(now);

        Subscription savedSub = subscriptionRepository.save(sub);

        Invoice invoice = new Invoice();
        invoice.setUserId(userId);
        invoice.setSubscriptionId(savedSub.getId());
        invoice.setPeriodStart(start);
        invoice.setPeriodEnd(end);
        invoice.setAmount(plan.getPrice());
        invoice.setStatus(InvoiceStatus.DUE);
        invoice.setDueDate(start);
        invoice.setCreatedAt(now);

        invoiceRepository.save(invoice);

        return savedSub;
    }

    public Subscription cancel(Long userId, Long subscriptionId) {
        Subscription sub = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found: " + subscriptionId));

        if (!userId.equals(sub.getUserId())) {
            throw new BusinessConflictException("You cannot cancel someone else's subscription");
        }

        if (sub.getStatus() != SubscriptionStatus.ACTIVE) {
            throw new BusinessConflictException("Only ACTIVE subscriptions can be cancelled");
        }

        sub.setStatus(SubscriptionStatus.CANCELLED);
        sub.setAutoRenew(false);
        sub.setUpdatedAt(LocalDateTime.now());

        return subscriptionRepository.save(sub);
    }

    public List<Subscription> listByUser(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    private LocalDate calculateEndDate(LocalDate start, BillingCycle billingCycle) {
        if (billingCycle == BillingCycle.YEARLY) {
            return start.plusYears(1);
        }
        return start.plusMonths(1);
    }
}
