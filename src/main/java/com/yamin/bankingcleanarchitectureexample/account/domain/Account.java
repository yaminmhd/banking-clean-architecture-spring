package com.yamin.bankingcleanarchitectureexample.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Account {
   private final AccountId id;
   private final Money baselineBalance;
   private final ActivityWindow activityWindow;

   public Money calculateBalance(){
      return this.baselineBalance.plus(activityWindow.calculateBalance(this.id));
   }
}
