package com.guvi.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.guvi.model.Subscription;
import com.guvi.model.SubscriptionStatus;

/**
 * Thread-safe in-memory repository.
 */
public class InMemorySubscriptionRepository implements SubscriptionRepository {

    private final ConcurrentHashMap<String, Subscription> store = new ConcurrentHashMap<>();

    @Override
    public Subscription save(Subscription subscription) {
        store.put(subscription.getId(), subscription);
        return subscription;
    }

    @Override
    public Optional<Subscription> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Subscription> findByUserId(String userId) {
        List<Subscription> result = new ArrayList<>();
        for (Subscription s : store.values()) {
            if (s.getUserId() != null && s.getUserId().equals(userId)) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public Optional<Subscription> findFirstByUserIdAndStatus(String userId, SubscriptionStatus status) {
        for (Subscription s : store.values()) {
            if (s.getUserId() != null && s.getUserId().equals(userId) && s.getStatus() == status) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
}
