package com.guvi.subscriptionmanager.repo;

import com.guvi.subscriptionmanager.model.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository {

    Subscription save(Subscription subscription);

    Optional<Subscription> findById(Long id);

    Optional<Subscription> findActiveByUserId(Long userId);

    List<Subscription> findByUserId(Long userId);
}
