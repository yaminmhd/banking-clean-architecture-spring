package com.yamin.bankingcleanarchitectureexample.account.domain;

import java.math.BigInteger;

public record Money(BigInteger amount) {
    public static final Money ZERO = Money.of(0L);

    public static Money of(long value) {
        return new Money(BigInteger.valueOf(value));
    }

    public Money plus (Money valueOne){
        return new Money(this.amount.add(valueOne.amount));
    }

    public Money subtract(Money valueOne){
        return new Money(this.amount.subtract(valueOne.amount));
    }
}
