package com.guvi.config;

import com.guvi.repo.*;
import com.guvi.service.CurrentUserProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring beans for the baseline (in-memory storage).
 *
 * TODO (session): Replace these beans with JPA repositories when MySQL is introduced.
 */
@Configuration
public class InMemoryConfig {

    @Bean
    public PlanRepository planRepository() {
        return new InMemoryPlanRepository();
    }

    @Bean
    public SubscriptionRepository subscriptionRepository() {
        return new InMemorySubscriptionRepository();
    }

    @Bean
    public InvoiceRepository invoiceRepository() {
        return new InMemoryInvoiceRepository();
    }

    @Bean
    public CurrentUserProvider currentUserProvider() {
        return new CurrentUserProvider();
    }
}
