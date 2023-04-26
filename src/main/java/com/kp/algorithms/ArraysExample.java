package com.kp.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraysExample {

   //Given a binary array nums, return the maximum number of consecutive 1's in the array.
   public int findMaxConsecutiveOnes(int[] nums) {
      int axu = 0;
      List<Integer> max = new ArrayList<>();
      for (int num : nums) {
         if (num == 1) {
            axu++;
         } else {
            max.add(axu);
            axu = 0;
         }
      }
      max.add(axu);
      return Collections.max(max);
   }
}
