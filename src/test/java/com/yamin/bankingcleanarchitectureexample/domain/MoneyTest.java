package com.yamin.bankingcleanarchitectureexample.domain;

import com.yamin.bankingcleanarchitectureexample.account.domain.Money;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    void shouldBeAbleToAddTwoMoneyValueObjectTogether(){
        Money tenDollars = new Money(BigInteger.valueOf(10L));
        Money fiveDollars = new Money(BigInteger.valueOf(5L));

        Money balance = tenDollars.plus(fiveDollars);
        assertThat(balance.amount()).isEqualTo(BigInteger.valueOf(15L));
    }

    @Test
    void shouldBeAbleToSubtractOneMoneyObjectFromAnother(){
        Money tenDollars = new Money(BigInteger.valueOf(10L));
        Money fiveDollars = new Money(BigInteger.valueOf(5L));

        Money balance = tenDollars.subtract(fiveDollars);
        assertThat(balance.amount()).isEqualTo(BigInteger.valueOf(5L));
    }

    @Test
    void shouldBeAbleToDeriveMoneyObjectFromLong(){
        Money moneyObject = Money.of(5L);
        assertThat(moneyObject.amount()).isEqualTo(BigInteger.valueOf(5L));
    }
}
