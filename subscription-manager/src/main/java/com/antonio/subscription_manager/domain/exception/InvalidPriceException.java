package com.antonio.subscription_manager.domain.exception;

public class InvalidPriceException extends RuntimeException {

    public InvalidPriceException() {
        super("Subscription price must be greater than zero");
    }
}