package com.guvi.subscriptionmanager.repo.inmemory;

import com.guvi.subscriptionmanager.model.Plan;
import com.guvi.subscriptionmanager.repo.PlanRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryPlanRepository implements PlanRepository {

    // ConcurrentHashMap is safe when multiple HTTP requests hit the app at the same time.
    private final ConcurrentHashMap<Long, Plan> plansById = new ConcurrentHashMap<>();
    private final AtomicLong idSeq = new AtomicLong(1);

    @Override
    public Plan save(Plan plan) {
        if (plan.getId() == null) {
            plan.setId(idSeq.getAndIncrement());
        }
        plansById.put(plan.getId(), plan);
        return plan;
    }

    @Override
    public Optional<Plan> findByPlanCode(String planCode) {
        if (planCode == null) {
            return Optional.empty();
        }

        for (Plan p : plansById.values()) {
            if (p.getPlanCode() != null && p.getPlanCode().equalsIgnoreCase(planCode.trim())) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Plan> findAll() {
        return new ArrayList<>(plansById.values());
    }

    @Override
    public List<Plan> findAllActive() {
        List<Plan> active = new ArrayList<>();
        for (Plan p : plansById.values()) {
            if (p.isActive()) {
                active.add(p);
            }
        }
        return active;
    }
}
