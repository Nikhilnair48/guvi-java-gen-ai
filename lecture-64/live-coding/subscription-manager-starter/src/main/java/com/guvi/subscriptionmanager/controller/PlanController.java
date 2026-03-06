package com.guvi.subscriptionmanager.controller;

import com.guvi.subscriptionmanager.model.Plan;
import com.guvi.subscriptionmanager.service.PlanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public List<Plan> listActivePlans() {
        return planService.listActivePlans();
    }

    @GetMapping("/{planCode}")
    public Plan getPlan(@PathVariable String planCode) {
        return planService.getActivePlanByCode(planCode);
    }
}
