package com.antonio.subscription_manager.application.port.in;

import com.antonio.subscription_manager.domain.model.Subscription;

public interface CreateSubscriptionUseCase {

    Subscription create(CreateSubscriptionCommand command);

}