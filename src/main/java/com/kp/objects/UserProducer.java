package com.kp.objects;

import java.util.function.Consumer;

import com.kp.util.Util;

import reactor.core.publisher.FluxSink;

public class UserProducer implements Consumer<FluxSink<String>> {

   private FluxSink<String> stringFluxSink;
   @Override
   public void accept(FluxSink<String> stringFluxSink) {
     this.stringFluxSink = stringFluxSink;
   }

   public void produce() {
      String name = Util.getFaker().gameOfThrones().dragon();
      String thread = Thread.currentThread().getName();
      System.out.println("Producing " + name + " on thread " + thread);
   }
}
