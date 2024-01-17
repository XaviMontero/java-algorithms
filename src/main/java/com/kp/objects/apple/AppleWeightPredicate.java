package com.kp.objects.apple;

public class AppleWeightPredicate implements Predicate {

   public boolean test(Object t) {
      Apple apple = (Apple) t;
      return apple.getWeight() > 150;
   }

 }
