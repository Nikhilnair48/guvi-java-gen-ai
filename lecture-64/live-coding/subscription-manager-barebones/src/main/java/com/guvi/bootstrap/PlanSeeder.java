package com.guvi.bootstrap;

import java.util.UUID;

import com.guvi.model.BillingCycle;
import com.guvi.model.Plan;
import com.guvi.repo.PlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Seeds a few plans into the in-memory repository.
 */
@Configuration
public class PlanSeeder {

    @Bean
    public CommandLineRunner seedPlans(PlanRepository planRepository) {
        return args -> {
            planRepository.save(new Plan(UUID.randomUUID().toString(), "BASIC_199", "Basic", BillingCycle.MONTHLY, 199.0, true));
            planRepository.save(new Plan(UUID.randomUUID().toString(), "PREMIUM_499", "Premium", BillingCycle.MONTHLY, 499.0, true));
            planRepository.save(new Plan(UUID.randomUUID().toString(), "YEARLY_1999", "Yearly Basic", BillingCycle.YEARLY, 1999.0, false));
        };
    }
}
