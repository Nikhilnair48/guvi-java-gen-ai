package com.guvi.subscriptionmanager.bootstrap;

import com.guvi.subscriptionmanager.model.BillingCycle;
import com.guvi.subscriptionmanager.model.Plan;
import com.guvi.subscriptionmanager.repo.PlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlanSeeder implements CommandLineRunner {

    private final PlanRepository planRepository;

    public PlanSeeder(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public void run(String... args) {
        if (!planRepository.findAll().isEmpty()) {
            return;
        }

        LocalDateTime now = LocalDateTime.now();

        planRepository.save(new Plan(null, "BASIC_199", "Basic", BillingCycle.MONTHLY, 199.0, true, now));
        planRepository.save(new Plan(null, "PREMIUM_499", "Premium", BillingCycle.MONTHLY, 499.0, true, now));
        planRepository.save(new Plan(null, "YEARLY_1999", "Yearly", BillingCycle.YEARLY, 1999.0, false, now));
    }
}
