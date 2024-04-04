package com.kp.util;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.github.javafaker.Faker;
import com.kp.objects.DefaultSubscriber;

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

   public static Subscriber<Object> defaultOnSubscribe(String name) {
      return new DefaultSubscriber(name);
   }

   public static Subscriber<Object> defaultOnSubscribe() {
      return new DefaultSubscriber();
   }
}
