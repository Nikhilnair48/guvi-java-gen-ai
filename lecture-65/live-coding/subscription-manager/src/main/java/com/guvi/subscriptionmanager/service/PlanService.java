package com.guvi.subscriptionmanager.service;

import com.guvi.subscriptionmanager.exception.ResourceNotFoundException;
import com.guvi.subscriptionmanager.model.Plan;
import com.guvi.subscriptionmanager.repo.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> listActivePlans() {
        return planRepository.findAllActive();
    }

    public Plan getActivePlanByCode(String planCode) {
        Plan plan = planRepository.findByPlanCode(planCode)
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found: " + planCode));

        if (!plan.isActive()) {
            // For baseline, treat inactive plan as not found for public access.
            throw new ResourceNotFoundException("Plan not found: " + planCode);
        }

        return plan;
    }

    public Plan getPlanByCode(String planCode) {
        return planRepository.findByPlanCode(planCode)
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found: " + planCode));
    }
}
