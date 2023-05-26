package com.kp.algorithms;

import com.kp.objects.Range;

public class Solution {

   public static void main(String[] args) {
      ArraysExample arraysExample = new ArraysExample();
      int[] nums = new int[0];
      arraysExample.findMaxConsecutiveOnes(nums);
      Range range = new Range(100);
      System.out.println(range.yMinusX(40,30));
   }
}