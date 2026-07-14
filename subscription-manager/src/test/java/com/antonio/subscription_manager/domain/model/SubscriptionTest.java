package com.antonio.subscription_manager.domain.model;

import com.antonio.subscription_manager.domain.exception.SubscriptionAlreadyCancelledException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {

    @Test
    void shouldCreateSubscriptionWithActiveStatus() {
        Subscription subscription = new Subscription(
                "Netflix",
                new Money(BigDecimal.valueOf(15.99), Currency.getInstance("EUR")),
                BillingCycle.MONTHLY,
                LocalDate.now().plusDays(10),
                Category.ENTERTAINMENT
        );

        assertNotNull(subscription.getId());
        assertEquals(SubscriptionStatus.ACTIVE, subscription.getStatus());
    }

    @Test
    void shouldCancelActiveSubscription() {
        Subscription subscription = new Subscription(
                "Spotify",
                new Money(BigDecimal.valueOf(10.99), Currency.getInstance("EUR")),
                BillingCycle.MONTHLY,
                LocalDate.now().plusDays(5),
                Category.MUSIC
        );

        subscription.cancel();

        assertEquals(SubscriptionStatus.CANCELLED, subscription.getStatus());
    }

    @Test
    void shouldNotCancelAlreadyCancelledSubscription() {
        Subscription subscription = new Subscription(
                "Gym",
                new Money(BigDecimal.valueOf(30), Currency.getInstance("EUR")),
                BillingCycle.MONTHLY,
                LocalDate.now().plusDays(15),
                Category.FITNESS
        );

        subscription.cancel();

        assertThrows(
                SubscriptionAlreadyCancelledException.class,
                subscription::cancel
        );
    }
}