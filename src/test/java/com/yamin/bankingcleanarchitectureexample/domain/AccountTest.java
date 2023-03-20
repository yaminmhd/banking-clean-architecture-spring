package com.yamin.bankingcleanarchitectureexample.domain;

import com.yamin.bankingcleanarchitectureexample.account.domain.*;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
                .money(BigInteger.valueOf(999L))
                .build();
        Activity activityTwo = Activity.builder()
                .id(new ActivityId(24L))
                .ownerAccountId(sourceAccount)
                .sourceAccountId(sourceAccount)
                .targetAccountId(targetAccount)
                .timeStamp(LocalDateTime.now())
                .money(BigInteger.valueOf(1L))
                .build();
        List<Activity> activities = List.of(activityOne, activityTwo);
        Account account = Account.builder()
                .id(targetAccount)
                .baselineBalance(BigInteger.valueOf(555L))
                .activityWindow(new ActivityWindow(activities)).build();

        BigInteger balance = account.calculateBalance();

        assertThat(balance).isEqualTo(1555L);
    }


}