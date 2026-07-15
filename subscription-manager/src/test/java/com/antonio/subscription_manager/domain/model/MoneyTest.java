package com.antonio.subscription_manager.domain.model;

import com.antonio.subscription_manager.domain.exception.InvalidPriceException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void shouldCreateMoneyWithValidAmountAndCurrency() {
        Money money = new Money(
                BigDecimal.valueOf(15.99),
                Currency.getInstance("EUR")
        );

        assertEquals(BigDecimal.valueOf(15.99), money.getAmount());
        assertEquals(Currency.getInstance("EUR"), money.getCurrency());
    }

    @Test
    void shouldNotCreateMoneyWithZeroAmount() {
        assertThrows(
                InvalidPriceException.class,
                () -> new Money(BigDecimal.ZERO, Currency.getInstance("EUR"))
        );
    }

    @Test
    void shouldNotCreateMoneyWithNegativeAmount() {
        assertThrows(
                InvalidPriceException.class,
                () -> new Money(BigDecimal.valueOf(-10), Currency.getInstance("EUR"))
        );
    }

    @Test
    void shouldNotCreateMoneyWithoutCurrency() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Money(BigDecimal.valueOf(10), null)
        );
    }
}