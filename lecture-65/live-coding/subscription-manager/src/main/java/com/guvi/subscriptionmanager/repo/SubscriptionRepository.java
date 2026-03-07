package com.guvi.subscriptionmanager.repo;

import com.guvi.subscriptionmanager.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findActiveByUserId(Long userId);

    List<Subscription> findByUserId(Long userId);
}
