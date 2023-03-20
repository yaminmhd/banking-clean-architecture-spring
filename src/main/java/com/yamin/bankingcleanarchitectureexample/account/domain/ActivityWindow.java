package com.yamin.bankingcleanarchitectureexample.account.domain;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ActivityWindow {
    private List<Activity> activities;

    public Money calculateBalance(AccountId accountId) {
        Money depositBalance = activities.stream()
                .filter(activity -> activity.targetAccountId().equals(accountId))
                .map(Activity::money)
                .reduce(Money.ZERO, Money::plus);

        Money withdrawalBalance = activities.stream()
                .filter(activity -> activity.sourceAccountId().equals(accountId))
                .map(Activity::money)
                .reduce(Money.ZERO, Money::plus);

        return depositBalance.plus(withdrawalBalance);
    }
}
