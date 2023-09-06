package com.kp.algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.UF;

public class DynamicConnectivity {

   public static void main(String[] args) {
      int N = StdIn.readInt();
      UF uf = new UF(N);
      uf.connected(1, 0);
   }

   private void validate(int p) {
      int n = 10;
      if (p < 0 || p >= n) {
         throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
      }
   }
}
