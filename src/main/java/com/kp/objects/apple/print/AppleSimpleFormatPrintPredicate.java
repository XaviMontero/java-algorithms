package com.kp.objects.apple.print;

import com.kp.objects.apple.Apple;

public class AppleSimpleFormatPrintPredicate implements ApplePrintPredicate {

   @Override
   public String print(Apple apple) {
      return "Apple";
   }
}
