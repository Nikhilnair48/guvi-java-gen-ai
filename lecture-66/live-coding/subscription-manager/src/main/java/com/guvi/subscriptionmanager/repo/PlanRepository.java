package com.guvi.subscriptionmanager.repo;

import com.guvi.subscriptionmanager.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    Optional<Plan> findByPlanCode(String planCode);

    // List<Plan> findAllActive();
    List<Plan> findByActiveTrue();
}
