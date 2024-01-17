package com.kp.objects.apple;

import static java.awt.Color.GREEN;

public class AppleGreenColorPredicate implements Predicate {

   public boolean test(Object t) {
      Apple apple = (Apple) t;
      return GREEN.equals(apple.getColor());
   }


}
