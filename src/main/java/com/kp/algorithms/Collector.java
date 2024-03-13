package com.kp.algorithms;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kp.objects.transaction.Currency;
import com.kp.objects.transaction.Transaction;

public class Collector {

   public static void main(String[] args) {
      Map<Currency, List<Transaction>> listMap;

      List<Transaction> listData = new ArrayList<>();
      listData.add(new Transaction(100.0, new com.kp.objects.transaction.Currency("USD", "US Dollar")));
      listData.add(new Transaction(200.0, new com.kp.objects.transaction.Currency("EUR", "Euro")));
      listData.add(new Transaction(150.0, new com.kp.objects.transaction.Currency("GBP", "British Pound")));
      listData.add(new Transaction(10330.0, new com.kp.objects.transaction.Currency("JPY", "Japanese Yen")));
      listData.add(new Transaction(10440.0, new com.kp.objects.transaction.Currency("CNY", "Chinese Yuan")));
      listData.add(new Transaction(1320.0, new com.kp.objects.transaction.Currency("USD", "US Dollar")));
      listData.add(new Transaction(1230.0, new com.kp.objects.transaction.Currency("USD", "US Dollar")));
      listData.add(new Transaction(10340.0, new com.kp.objects.transaction.Currency("USD", "US Dollar")));

      listMap = listData.stream().collect(Collectors.groupingBy(Transaction::getCurrency));

      listMap.get(new Currency("USD", "US Dollar")).forEach(System.out::println);

   }

}
