package com.kp.algorithms;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kp.objects.restaurant.Dish;
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

      Long count = listData.stream().collect(Collectors.counting());
      Long reduce = listData.stream().count();
      System.out.println(count);
      System.out.println(reduce);
      IntSummaryStatistics summaryStatistics = getListDishe().stream().collect(Collectors.summarizingInt(Dish::getCalories));

      System.out.println(summaryStatistics.getMax());
      System.out.println(summaryStatistics.getMin());
      System.out.println(summaryStatistics.getAverage());
      System.out.println(summaryStatistics.getCount());
      System.out.println(summaryStatistics.getSum());


   }

   private static List<Dish> getListDishe() {
      List<Dish> dishes = new ArrayList<>();
      dishes.add(new Dish("pork", 800, false));
      dishes.add(new Dish("beef", 700, false));
      dishes.add(new Dish("chicken", 400, false));
      dishes.add(new Dish("french fries", 530, true));
      dishes.add(new Dish("rice", 350, true));
      dishes.add(new Dish("season fruit", 120, true));
      dishes.add(new Dish("rice", 350, true));
      dishes.add(new Dish("season fruit", 120, true));
      dishes.add(new Dish("salad", 220, true));
      dishes.add(new Dish("pizza", 550, true));
      dishes.add(new Dish("prawns", 300, false));
      dishes.add(new Dish("salmon", 450, false));
      return dishes;
   }
}
