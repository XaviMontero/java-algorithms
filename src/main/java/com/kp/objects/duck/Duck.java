package com.kp.objects.duck;

import com.kp.objects.duck.fly.FlyBehavior;
import com.kp.objects.duck.fly.FlyNoWay;
import com.kp.objects.duck.quack.QuackBehavior;
import com.kp.objects.duck.quack.Squeak;

import lombok.Data;

@Data
public class Duck {

   private FlyBehavior flyBehavior;

   private QuackBehavior quackBehavior;

   public Duck() {
   this.flyBehavior = new FlyNoWay();
   this.quackBehavior = new Squeak();

   }

   public void swim() {
      System.out.println("Swim");
   }

   public void display() {
      System.out.println("Display");
   }

   public void fly() {
      System.out.println("Fly");
   }

   public void quack() {
      System.out.println("Quack");
   }

   public void performFly() {
      flyBehavior.fly();
   }
}
