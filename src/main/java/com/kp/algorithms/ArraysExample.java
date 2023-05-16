package com.kp.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

   public Integer sumInterges(List<Integer> integers){
      if (Objects.isNull(integers)){
         throw new IllegalArgumentException("List can't be null");
      }
      return integers.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).sum();
   }

   public boolean isListContaintNulls(List<Integer> integers){
      if (Objects.isNull(integers)){
         return true;
      }
      return integers.stream().anyMatch(Objects::isNull);
   }
}
