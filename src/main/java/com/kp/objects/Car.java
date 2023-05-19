package com.kp.objects;

import java.util.Objects;

public class Car {

   private final String name;

   private final String color;

   public Car(String name, String color) {

      //AFTER
      if (name == null) {
         throw new NullPointerException("Car name cannot be null");
      }

      if (color == null) {
         throw new NullPointerException("Car color cannot be null");
      }

      //NOW
      this.name = Objects.requireNonNull(name, "the name cannot be null");

      this.color = Objects.requireNonNull(color, "the color cannot be null");
   }
}
