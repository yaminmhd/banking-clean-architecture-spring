package com.yamin.bankingcleanarchitectureexample.account.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Activity(ActivityId id, AccountId ownerAccountId, AccountId sourceAccountId, AccountId targetAccountId,
                       LocalDateTime timeStamp, Money money) {
}