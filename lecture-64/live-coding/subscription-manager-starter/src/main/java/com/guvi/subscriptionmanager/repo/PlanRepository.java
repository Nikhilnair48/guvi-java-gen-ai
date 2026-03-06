package com.guvi.subscriptionmanager.repo;

import com.guvi.subscriptionmanager.model.Plan;

import java.util.List;
import java.util.Optional;

public interface PlanRepository {

    Plan save(Plan plan);

    Optional<Plan> findByPlanCode(String planCode);

    List<Plan> findAll();

    List<Plan> findAllActive();
}
