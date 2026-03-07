package com.guvi.subscriptionmanager.service;

import org.springframework.stereotype.Component;

/**
 * Baseline helper.
 *
 * For now we assume a hard-coded current user.
 * In Session 1, this will be replaced by JWT-based identity.
 */
@Component
public class CurrentUserProvider {

    public Long getCurrentUserId() {
        return 101L;
    }

    public String getCurrentUserEmail() {
        return "user101@example.com";
    }
}
