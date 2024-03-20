package com.kp.algorithms;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kp.objects.restaurant.Dish;
import com.kp.objects.restaurant.EType;
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

      String join = getListDishe().stream().map(Dish::getName).collect(joining(","));
      System.out.println(join);

      Optional<Dish> getDish = getListDishe().stream().reduce((b1, b2) -> b1.getCalories() > b2.getCalories() ? b1 : b2);
      int sumCalories = getListDishe().stream().map(Dish::getCalories).reduce(0, Integer::sum);

      Map<EType, List<Dish>> filter = getListDishe().stream().collect(Collectors.groupingBy(Dish::getType));
      filter.forEach((k, v) -> {
         System.out.println(k);
         v.forEach(System.out::println);
      });

      Map<EType, Optional<Dish>> mostCaloricByType = getListDishe()
            .stream()
            .collect(Collectors.groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));

      mostCaloricByType.forEach((k, v) -> {
         System.out.println(k);
      });

      Map<EType, Dish> getMax = getListDishe()
            .stream()
            .collect(Collectors.groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

      goesToTest();

   }

   private static void goesToTest() {

      System.out.println("======= goesToTest =======");

      Map<Boolean , List<String>> isVegetarian =
            getListDishe().stream().collect(Collectors.groupingBy(Dish::isVegetarian, Collectors.mapping(Dish::getName, Collectors.toList()) ) );

      isVegetarian.forEach((k, v) -> {
         System.out.println(k);
         v.forEach(System.out::println);
      });

      System.out.println("======= goesToTest 1=======");
      Map<Boolean, Map<EType, List<Dish>>>
            par = getListDishe().stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));

      par.forEach((k, v) -> {
         System.out.println(k);
         v.forEach((k1, v1) -> {
            System.out.println(k1);
            v1.forEach(System.out::println);
         });
      });


   }

   public enum EType2 {
      FAT,
      GREAT,
      HEALTY,
      MEAT,
      FISH,
      OTHER
   }

   private static List<Dish> getListDishe() {
      List<Dish> dishes = new ArrayList<>();
      dishes.add(new Dish("pork", 800, false, EType.MEAT));
      dishes.add(new Dish("beef", 700, false, EType.MEAT));
      dishes.add(new Dish("chicken", 400, false, EType.MEAT));
      dishes.add(new Dish("french fries", 530, true, EType.OTHER));
      dishes.add(new Dish("rice", 350, true, EType.OTHER));
      dishes.add(new Dish("season fruit", 120, true, EType.OTHER));
      dishes.add(new Dish("rice", 350, true, EType.OTHER));
      dishes.add(new Dish("season fruit", 120, true, EType.OTHER));
      dishes.add(new Dish("salad", 220, true, EType.OTHER));
      dishes.add(new Dish("pizza", 550, true, EType.OTHER));
      dishes.add(new Dish("prawns", 300, false, EType.FISH));
      dishes.add(new Dish("salmon", 450, false, EType.FISH));
      return dishes;
   }
}
