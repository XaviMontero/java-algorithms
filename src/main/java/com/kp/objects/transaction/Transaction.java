package com.kp.objects.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

   private Double amount;

   private Currency currency;
}
