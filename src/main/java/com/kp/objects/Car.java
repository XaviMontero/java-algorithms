package com.kp.objects;

import java.awt.*;
import java.util.Objects;

public class Car {

   private String name;

   private Color color;

   public Car(String name, Color color) {

      //AFTER
      if (name == null) {
         throw new NullPointerException("Car name cannot be null");
      }

      if (color == null) {
         throw new NullPointerException("Car color cannot be null");
      }

      //NOW
      this.name = Objects.requireNonNull(name, "the name cannot be null");

      // this.color = Objects.requireNonNull(color, "the color cannot be null");

   }

   public Car(String name) {
      this.name = Car.requireNonNullElseThrow(name, new IllegalArgumentException("Name cannot be null"));
   }

   public static <T, X extends Throwable> T requireNonNullElseThrow(T obj, X exception) throws X {

      if (obj == null) {
         throw exception;
      }

      return obj;
   }

}
