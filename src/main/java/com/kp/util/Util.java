package com.kp.util;

import java.util.Objects;
import java.util.function.Consumer;

public class Util {

   public static Consumer<Object> onNext() {
      return item -> System.out.println(item);
   }

   public static Consumer<Throwable> onError() {
      return error -> System.out.println(error);
   }

   public static Runnable onComplete() {
      return () -> System.out.println("Done");
   }
}
