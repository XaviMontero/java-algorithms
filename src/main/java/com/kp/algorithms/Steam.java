package com.kp.algorithms;

import static java.lang.Thread.sleep;

import java.util.stream.Stream;
import reactor.core.publisher.Mono;
public class Steam {

   public static void main(String[] args) {
      Stream<Integer> stream = Stream.of(1).map(i -> {
         try {
            sleep(1000);
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
         return i + 10;
      });

   stream.forEach(System.out::println);
   }

}
