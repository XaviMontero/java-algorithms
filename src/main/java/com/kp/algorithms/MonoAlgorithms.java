package com.kp.algorithms;

import com.kp.util.Util;

import reactor.core.publisher.Mono;

public class MonoAlgorithms {

   public static void main(String[] args) {

      //data error
      Integer fin = "data".length() / 0;
      System.out.println(fin);
      //data error


      Mono<Integer> mono = Mono.just("data").map(String::length).map(l -> l / 0);

      mono.subscribe(item -> System.out.println(item), error -> System.out.println(error), () -> System.out.println("Done"));
      mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

      System.out.println("End of main");
   }
}
