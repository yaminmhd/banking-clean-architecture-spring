package com.yamin.bankingcleanarchitectureexample.domain;

import com.yamin.bankingcleanarchitectureexample.account.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
    @Test
    void shouldReturnAccountBalanceWhenThereAreExistingActivities() {
        AccountId sourceAccount = new AccountId(5L);
        AccountId targetAccount = new AccountId(1L);
        Activity activityOne = Activity.builder()
                .id(new ActivityId(23L))
                .ownerAccountId(sourceAccount)
                .sourceAccountId(sourceAccount)
                .targetAccountId(targetAccount)
                .timeStamp(LocalDateTime.now())
                .money(Money.of(999L))
                .build();
        Activity activityTwo = Activity.builder()
                .id(new ActivityId(24L))
                .ownerAccountId(sourceAccount)
                .sourceAccountId(sourceAccount)
                .targetAccountId(targetAccount)
                .timeStamp(LocalDateTime.now())
                .money(Money.of(1L))
                .build();
        List<Activity> activities = List.of(activityOne, activityTwo);
        Account account = Account.builder()
                .id(targetAccount)
                .baselineBalance(Money.of(555L))
                .activityWindow(new ActivityWindow(activities)).build();

        Money balance = account.calculateBalance();

        assertThat(balance.amount()).isEqualTo(1555L);
    }

}