package com.guvi.repo;

import java.util.List;
import java.util.Optional;

import com.guvi.model.Subscription;
import com.guvi.model.SubscriptionStatus;

public interface SubscriptionRepository {
    Subscription save(Subscription subscription);

    Optional<Subscription> findById(String id);

    List<Subscription> findByUserId(String userId);

    Optional<Subscription> findFirstByUserIdAndStatus(String userId, SubscriptionStatus status);
}
