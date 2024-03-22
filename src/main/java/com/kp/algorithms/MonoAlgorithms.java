package com.kp.algorithms;

import com.kp.util.Util;

import reactor.core.publisher.Mono;

public class MonoAlgorithms {

   public static void main(String[] args) {
/*
      //data error
      Integer fin = "data".length() / 0;
      System.out.println(fin);
      //data error
*/


      Mono<Integer> mono = Mono.just("data").map(String::length).map(l -> l / 0);

      mono.subscribe(System.out::println, System.out::println, () -> System.out.println("Done"));
      mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
      System.out.println("End of main");
    testMono(2).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    testMono();
      testMono().subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    testMono();

    System.out.println("============================");

   Mono.fromRunnable(sendEmail()).subscribe(Util.onNext(), Util.onError(),

         () -> System.out.println("Email sent"));
   }


   public static Mono<String> testMono() {
      System.out.println("Start generating name");
      return Mono.fromSupplier(() -> {
         Util.sleepSeconds(3);
         System.out.println("Generating name");
        return Util.getFaker().name().fullName();
      });
   }
   public static Mono<String> testMono(int i) {

      Mono<String> userRepository = Mono.just(Util.getFaker().name().fullName());

      if (i == 1){
         userRepository = userRepository.map(String::toUpperCase);
      }else if (i == 2){
         return Mono.error(new RuntimeException("Error"));
      }
      return userRepository;


   }

   public  static Runnable sendEmail(){
      return () -> {
         Util.sleepSeconds(3);
         System.out.println("Sending email to ");
      };
   }
}
