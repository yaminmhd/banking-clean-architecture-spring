package com.yamin.bankingcleanarchitectureexample.account.domain;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Account {
   private final AccountId id;
   private final BigInteger baselineBalance;
   private final ActivityWindow activityWindow;

   public BigInteger calculateBalance(){
      return this.baselineBalance.add(activityWindow.calculateBalance(this.id));
   }
}
