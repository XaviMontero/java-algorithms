package com.kp.algorithms;

import com.github.javafaker.Faker;
import com.kp.util.Util;

import reactor.core.publisher.Flux;

public class FluxMain {

   public static void main(String[] args) {

      Flux<Object> flux = Flux.just(1, "Hola", 3, 4, Util.getFaker().name().fullName(), 6, 8, 9, 10);

      flux.subscribe(Util.onNext());
      System.out.println("Filtering only integers");
      Flux<Integer> flux1 = flux.filter(Integer.class::isInstance).cast(Integer.class);
      flux1.subscribe(Util.onNext());

   }

}
