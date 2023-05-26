package com.kp.objects;

import java.util.Objects;

public class Range {

   private static final int N_UPPER_BOUND = 101;

   private final int n;

   public Range(int n) {
      this.n = Objects.checkIndex(n, N_UPPER_BOUND);
   }

   public int yMinusX(int x, int y) {

      Objects.checkFromIndexSize(x, y, n);
      return y - x;
   }
}
