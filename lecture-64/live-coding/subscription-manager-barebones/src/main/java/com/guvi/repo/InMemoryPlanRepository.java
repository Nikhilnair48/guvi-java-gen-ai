package com.guvi.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.guvi.model.Plan;

/**
 * Thread-safe in-memory repository.
 *
 * This is intentionally simple so learners can understand the pattern.
 */
public class InMemoryPlanRepository implements PlanRepository {

    private final ConcurrentHashMap<String, Plan> store = new ConcurrentHashMap<>();

    @Override
    public Plan save(Plan plan) {
        store.put(plan.getId(), plan);
        return plan;
    }

    @Override
    public Optional<Plan> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Plan> findByPlanCode(String planCode) {
        for (Plan plan : store.values()) {
            if (plan.getPlanCode() != null && plan.getPlanCode().equalsIgnoreCase(planCode)) {
                return Optional.of(plan);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Plan> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Plan> findAllActive() {
        List<Plan> result = new ArrayList<>();
        for (Plan plan : store.values()) {
            if (plan.isActive()) {
                result.add(plan);
            }
        }
        return result;
    }
}
