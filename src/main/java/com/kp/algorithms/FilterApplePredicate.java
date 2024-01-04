package com.kp.algorithms;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;

import java.util.ArrayList;
import java.util.List;

import com.kp.objects.apple.Apple;
import com.kp.objects.apple.ApplePredicate;
import com.kp.objects.apple.AppleWeightPredicate;
import com.kp.objects.apple.print.ApplePrettyPrintPredicate;
import com.kp.objects.apple.print.ApplePrintPredicate;

public class FilterApplePredicate {

   public void main(String[] args) {
      List<Apple> inventory = new ArrayList<>();
      inventory.add(new Apple(GREEN, 100));
      inventory.add(new Apple(RED, 200));
      inventory.add(new Apple(GREEN, 100));
      inventory.add(new Apple(GREEN, 200));
      inventory.add(new Apple(RED, 200));

      FilterApplePredicate filterApplePredicate = new FilterApplePredicate();
      ApplePredicate applePredicate = new AppleWeightPredicate();
      List<Apple> heavyApples = filterApplePredicate.filterApples(inventory, applePredicate);
      System.out.println(printApples(heavyApples, new ApplePrettyPrintPredicate()));

      //anonymous class
      List<Apple> redApples = filterApplePredicate.filterApples(inventory, new ApplePredicate() {
         public boolean test(Apple apple) {
            return RED.equals(apple.getColor());
         }
      });

      //anonymous class using lambda
      List<Apple> redApples2 = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));
   }


   public static List<String> printApples(List<Apple> inventory, ApplePrintPredicate p) {
      List<String> apples = new ArrayList<>();
      inventory.forEach(apple -> apples.add(p.print(apple)));
      return apples;
   }

   public List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
      List<Apple> apples = new ArrayList<>();
      inventory.forEach(apple -> {
         if (p.test(apple)) {
            apples.add(apple);
         }
      });
      return apples;
   }

}
