package com.antonio.subscription_manager.application.usecase;

import com.antonio.subscription_manager.application.port.in.CreateSubscriptionCommand;
import com.antonio.subscription_manager.application.port.in.CreateSubscriptionUseCase;
import com.antonio.subscription_manager.application.port.out.SubscriptionRepository;
import com.antonio.subscription_manager.domain.model.Money;
import com.antonio.subscription_manager.domain.model.Subscription;
import org.springframework.stereotype.Service;

@Service
public class CreateSubscriptionService implements CreateSubscriptionUseCase {

    private final SubscriptionRepository subscriptionRepository;

    public CreateSubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription create(CreateSubscriptionCommand command) {

        Subscription subscription = new Subscription(
                command.name(),
                new Money(command.amount(), command.currency()),
                command.billingCycle(),
                command.nextBillingDate(),
                command.category()
        );

        return subscriptionRepository.save(subscription);
    }
}