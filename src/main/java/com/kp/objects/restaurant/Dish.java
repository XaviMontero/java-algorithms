package com.kp.objects.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

   private String name;

   private Integer calories;

   private Boolean vegetarian;

   private EType type;


   public static boolean isVegetarian(Dish dish) {
      return dish.getVegetarian();
   }
}
