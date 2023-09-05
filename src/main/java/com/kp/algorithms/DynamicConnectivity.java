package com.kp.algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.UF;

public class DynamicConnectivity {

   public static void main(String[] args) {
      int N = StdIn.readInt();
      UF uf = new UF(N);
      uf.connected(1, 0);
   }
}
