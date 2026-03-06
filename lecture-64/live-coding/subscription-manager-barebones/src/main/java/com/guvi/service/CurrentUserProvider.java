package com.guvi.service;

/**
 * Baseline helper: a hard-coded current user.
 *
 * TODO (session): Replace this with JWT-based user identity.
 */
public class CurrentUserProvider {

    public String getCurrentUserId() {
        return "user-1";
    }

    public String getCurrentUserEmail() {
        return "user1@example.com";
    }
}
