package com.kp.objects;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

   private String name;

   public DefaultSubscriber(String name) {
      this.name = name;
   }

   public DefaultSubscriber() {
   }

   @Override
   public void onSubscribe(Subscription s) {
      s.request(Long.MAX_VALUE);
   }

   @Override
   public void onNext(Object o) {
      System.out.println(name + " : " + o);
   }

   @Override
   public void onError(Throwable t) {
      t.printStackTrace();

   }

   @Override
   public void onComplete() {
      System.out.println(name + " : Done");
   }
}
