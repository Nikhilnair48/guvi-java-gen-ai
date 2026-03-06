package com.guvi.subscriptionmanager.repo.inmemory;

import com.guvi.subscriptionmanager.model.Subscription;
import com.guvi.subscriptionmanager.model.SubscriptionStatus;
import com.guvi.subscriptionmanager.repo.SubscriptionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemorySubscriptionRepository implements SubscriptionRepository {

    // ConcurrentHashMap is safe when multiple HTTP requests hit the app at the same time.
    private final ConcurrentHashMap<Long, Subscription> subsById = new ConcurrentHashMap<>();
    private final AtomicLong idSeq = new AtomicLong(1);

    @Override
    public Subscription save(Subscription subscription) {
        if (subscription.getId() == null) {
            subscription.setId(idSeq.getAndIncrement());
        }
        subsById.put(subscription.getId(), subscription);
        return subscription;
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(subsById.get(id));
    }

    @Override
    public Optional<Subscription> findActiveByUserId(Long userId) {
        if (userId == null) {
            return Optional.empty();
        }

        for (Subscription s : subsById.values()) {
            if (userId.equals(s.getUserId()) && s.getStatus() == SubscriptionStatus.ACTIVE) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Subscription> findByUserId(Long userId) {
        List<Subscription> out = new ArrayList<>();
        if (userId == null) {
            return out;
        }

        for (Subscription s : subsById.values()) {
            if (userId.equals(s.getUserId())) {
                out.add(s);
            }
        }
        return out;
    }
}
