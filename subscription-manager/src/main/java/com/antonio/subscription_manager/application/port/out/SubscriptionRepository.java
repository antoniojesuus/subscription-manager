package com.antonio.subscription_manager.application.port.out;

import com.antonio.subscription_manager.domain.model.Subscription;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionRepository {

    Subscription save(Subscription subscription);

    Optional<Subscription> findById(UUID id);

    List<Subscription> findAll();

}