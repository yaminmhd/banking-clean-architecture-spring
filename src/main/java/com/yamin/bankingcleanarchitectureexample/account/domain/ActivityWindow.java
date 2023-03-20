package com.yamin.bankingcleanarchitectureexample.account.domain;

import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
public class ActivityWindow {
    private List<Activity> activities;

    public BigInteger calculateBalance(AccountId accountId) {
        BigInteger depositBalance = activities.stream()
                .filter(activity -> activity.targetAccountId().equals(accountId))
                .map(Activity::money)
                .reduce(BigInteger.valueOf(0L), BigInteger::add);

        BigInteger withdrawalBalance = activities.stream()
                .filter(activity -> activity.sourceAccountId().equals(accountId))
                .map(Activity::money)
                .reduce(BigInteger.valueOf(0L), BigInteger::add);

        return depositBalance.add(withdrawalBalance);
    }
}
