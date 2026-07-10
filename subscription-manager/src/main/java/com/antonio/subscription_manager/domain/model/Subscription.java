package com.antonio.subscription_manager.domain.model;

import com.antonio.subscription_manager.domain.exception.SubscriptionAlreadyCancelledException;

import java.time.LocalDate;
import java.util.UUID;

public class Subscription {
    private final UUID id;
    private final String name;
    private final Money price;
    private final BillingCycle billingCycle;
    private LocalDate nextBillingDate;
    private final Category category;
    private SubscriptionStatus status;

    public Subscription(String name, Money price, BillingCycle billingCycle, LocalDate nextBillingDate, Category category) {
        this.name = name;
        this.price = price;
        this.billingCycle = billingCycle;
        this.nextBillingDate = nextBillingDate;
        this.category = category;
        this.id = UUID.randomUUID();
        this.status = SubscriptionStatus.ACTIVE;
    }

    public void cancel() {
        if(status == SubscriptionStatus.CANCELLED){
            throw new SubscriptionAlreadyCancelledException();
        }

        status = SubscriptionStatus.CANCELLED;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public LocalDate getNextBillingDate() {
        return nextBillingDate;
    }

    public Category getCategory() {
        return category;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }
}
