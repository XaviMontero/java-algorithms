package com.kp.objects.apple.print;

import static java.awt.Color.GREEN;

import com.kp.objects.apple.Apple;

public class ApplePrettyPrintPredicate implements ApplePrintPredicate {

   @Override
   public String print(Apple apple) {
      String result = GREEN.equals(apple.getColor()) ? "GREEN" : "RED";
      return "Apple{" + "color=" + result + ", weight=" + apple.getWeight() + '}';
   }
}