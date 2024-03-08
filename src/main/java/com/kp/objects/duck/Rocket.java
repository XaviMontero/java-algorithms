package com.kp.objects.duck;

import com.kp.objects.duck.fly.FlyBehavior;

public class Rocket implements FlyBehavior {

   @Override
   public void fly() {
      System.out.println("I'm flying with a rocket");
   }

}


