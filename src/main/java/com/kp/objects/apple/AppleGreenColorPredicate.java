package com.kp.objects.apple;

import static java.awt.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {

   public boolean test(Apple apple) {
      return GREEN.equals(apple.getColor());
   }
}
