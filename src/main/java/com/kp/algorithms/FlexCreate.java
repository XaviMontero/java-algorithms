package com.kp.algorithms;

import com.kp.objects.UserProducer;
import com.kp.util.Util;

import reactor.core.publisher.Flux;

public class FlexCreate {

   public static void main(String[] args) {
      Flux.create( sink -> {
         sink.next("Hola");
         sink.next("Mundo");
         sink.complete();
      }).subscribe(Util.defaultOnSubscribe("Recived:"));

      UserProducer userProducer = new UserProducer();

      Flux.create(userProducer).subscribe(Util.defaultOnSubscribe());

      Runnable runnable = userProducer::produce;

      for (int i = 0; i < 10; i++) {
         new Thread(runnable).start();
      }
   }

}
