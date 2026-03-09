package com.guvi.repo;

import java.util.List;
import java.util.Optional;

import com.guvi.model.Plan;

public interface PlanRepository {
    Plan save(Plan plan);

    Optional<Plan> findById(String id);

    Optional<Plan> findByPlanCode(String planCode);

    List<Plan> findAll();

    List<Plan> findAllActive();
}
