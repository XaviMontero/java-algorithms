package com.kp.algorithms;



public class DynamicConnectivity {

   public static void main(String[] args) {

   }

   private void validate(int p) {
      int n = 10;
      if (p < 0 || p >= n) {
         throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
      }
   }
}
