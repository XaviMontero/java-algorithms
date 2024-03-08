package com.kp.algorithms;

import com.kp.objects.duck.Duck;
import com.kp.objects.duck.Rocket;

public class DuckPrincipal {

   public static void main(String[] args) {
      Duck duck = new Duck();
      duck.setFlyBehavior(new Rocket());
      //now this duck can fly with a rocket
   }

}
