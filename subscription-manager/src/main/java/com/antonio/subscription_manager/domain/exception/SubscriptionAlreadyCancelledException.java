package com.antonio.subscription_manager.domain.exception;

public class SubscriptionAlreadyCancelledException extends RuntimeException {

    public SubscriptionAlreadyCancelledException() {
        super("Subscription is already cancelled");
    }
}
