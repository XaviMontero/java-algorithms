package com.kp.algorithms;

import java.awt.*;
import java.util.Objects;

import com.kp.objects.Car;
import com.kp.objects.Range;

public class Solution {

   public static void main(String[] args) throws CloneNotSupportedException {
      ArraysExample arraysExample = new ArraysExample();
      int[] nums = new int[0];
      arraysExample.findMaxConsecutiveOnes(nums);
      Range range = new Range(100);
      System.out.println(range.yMinusX(40, 30));

      Car card1 = new Car("Jetour", Color.blue);
      Car card2 = new Car("Jetour", Color.blue);

      if (Objects.equals(card1, card2)) {
         System.out.println("The same objects");
      }
      Car clone = card1.clone();
      if (Objects.equals(clone, card1)) {
         System.out.println("The same objects");
      }
   }
}