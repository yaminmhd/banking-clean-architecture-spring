package com.yamin.bankingcleanarchitectureexample.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder
public record Activity(ActivityId id, AccountId ownerAccountId, AccountId sourceAccountId, AccountId targetAccountId,
                       LocalDateTime timeStamp, BigInteger money) {
}