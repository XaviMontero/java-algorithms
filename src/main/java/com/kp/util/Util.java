package com.kp.util;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

import org.reactivestreams.Subscription;

import com.github.javafaker.Faker;

import jdk.jshell.JShell;

public class Util {


   public static Faker FAKER = new Faker();

   public static Consumer<Object> onNext() {
      return item -> System.out.println(item);
   }

   public static Consumer<Throwable> onError() {
      return error -> System.out.println(error);
   }

   public static Runnable onComplete() {
      return () -> System.out.println("Done");
   }

   public static Faker getFaker() {
      return FAKER;
   }

   public static void sleepSeconds(int seconds) {
      try {
         Thread.sleep(seconds * 1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

}
