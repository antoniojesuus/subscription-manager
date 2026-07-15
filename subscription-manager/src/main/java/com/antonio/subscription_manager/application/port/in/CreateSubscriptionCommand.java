package com.antonio.subscription_manager.application.port.in;

import com.antonio.subscription_manager.domain.model.BillingCycle;
import com.antonio.subscription_manager.domain.model.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

public record CreateSubscriptionCommand(

        String name,
        BigDecimal amount,
        Currency currency,
        BillingCycle billingCycle,
        LocalDate nextBillingDate,
        Category category

) {
}