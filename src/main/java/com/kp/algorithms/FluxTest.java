package com.kp.algorithms;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.kp.util.Util;

import reactor.core.publisher.Flux;

public class FluxTest {

   public static void main(String[] args) {
      Flux<Integer> flux = Flux.range(13,17).map(FluxTest::randomInt);
      CountDownLatch countDownLatch = new CountDownLatch(1);
      flux.subscribeWith(new Subscriber<Integer>() {

         Subscription sus;
         @Override
         public void onSubscribe(Subscription s) {
            this.sus = s;
            s.request(Long.MAX_VALUE);
         }

         @Override
         public void onNext(Integer integer) {

            if (integer > 110 || integer < 90) {
               System.out.println("Price is abnormal  :" + integer);
              this.sus.cancel();
            }else {
               System.out.println("Price is normal :" + integer);
               countDownLatch.countDown();


            }

         }

         @Override
         public void onError(Throwable t) {
         countDownLatch.countDown();
         }

         @Override
         public void onComplete() {
            countDownLatch.countDown();
         }
      });
   }

   private static Integer randomInt(Integer i) {
      // I need the ranger to be 90 to 110
      Util.sleepSeconds(1);
      return new Random().nextInt(30) + 90;
   }

}
