package com.antonio.subscription_manager.domain.model;

import com.antonio.subscription_manager.domain.exception.InvalidPriceException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Money {

    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPriceException();
        }

        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }

        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return amount.equals(money.amount)
                && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency.getCurrencyCode();
    }
}