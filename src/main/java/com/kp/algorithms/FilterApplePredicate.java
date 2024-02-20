package com.kp.algorithms;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kp.objects.apple.Apple;
import com.kp.objects.apple.AppleWeightPredicate;
import com.kp.objects.apple.Predicate;
import com.kp.objects.apple.print.ApplePrettyPrintPredicate;
import com.kp.objects.apple.print.ApplePrintPredicate;

public class FilterApplePredicate {

   public static void main(String[] args) {
      List<Apple> inventory = new ArrayList<>();
      inventory.add(new Apple(GREEN, 100));
      inventory.add(new Apple(RED, 200));
      inventory.add(new Apple(GREEN, 100));
      inventory.add(new Apple(GREEN, 200));
      inventory.add(new Apple(RED, 200));

      FilterApplePredicate filterApplePredicate = new FilterApplePredicate();
      Predicate applePredicate = new AppleWeightPredicate();
      List<Apple> heavyApples = filterApples(inventory, applePredicate);
      System.out.println(printApples(heavyApples, new ApplePrettyPrintPredicate()));

      //Steam Using in java
      List<Apple> applesWithLamdan = inventory.stream().filter(apple -> apple.getWeight() > 150).collect(Collectors.toList());
      List<Apple> applesWithParalelStream = inventory.parallelStream().filter(apple -> apple.getWeight() > 150).collect(Collectors.toList());

      //anonymous class
      List<Apple> redApples = filterApplePredicate.filterApples(inventory, new Predicate() {

         public boolean test(Object t) {
            Apple apple = (Apple) t;
            return RED.equals(apple.getColor());
         }
      });

      //anonymous class using lambda
      List<Apple> redApples2 = filterApples(inventory, (Object t) -> {
         Apple apple = (Apple) t;
         return RED.equals((apple).getColor());
      });

   }

   public static List<String> printApples(List<Apple> inventory, ApplePrintPredicate p) {
      List<String> apples = new ArrayList<>();
      inventory.forEach(apple -> apples.add(p.print(apple)));
      return apples;
   }

   //static <T> Collection<T> filter(Collection<T> c, Predicate<T> p);
   public static List<Apple> filterApples(List<Apple> inventory, Predicate p) {
      List<Apple> apples = new ArrayList<>();
      inventory.forEach(apple -> {
         if (p.test(apple)) {
            apples.add(apple);
         }
      });
      return apples;
   }

   // stream with filter distin
   public void  filertDistin(){

      List<Integer> list = new ArrayList<>();

      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      List<Integer> filter = list.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
      filter.forEach(System.out::println);
   }

}
