package com.antonio.subscription_manager.infrastructure.adapter.out.persistence;

import com.antonio.subscription_manager.application.port.out.SubscriptionRepository;
import com.antonio.subscription_manager.domain.model.Subscription;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemorySubscriptionRepository implements SubscriptionRepository {

    private final Map<UUID, Subscription> subscriptions = new HashMap<>();

    @Override
    public Subscription save(Subscription subscription) {
        subscriptions.put(subscription.getId(), subscription);
        return subscription;
    }

    @Override
    public Optional<Subscription> findById(UUID id) {
        return Optional.ofNullable(subscriptions.get(id));
    }

    @Override
    public List<Subscription> findAll() {
        return new ArrayList<>(subscriptions.values());
    }
}