package com.kp.objects;

import java.awt.*;
import java.util.Objects;

public class Cpu {

   private String name;

   private Car car;

   public Cpu(String name, Car car) {
      this.name = Objects.requireNonNullElse(name, "Intel");
      this.car = Objects.requireNonNullElseGet(car, () -> new Car("Example", Color.black));
   }
}
