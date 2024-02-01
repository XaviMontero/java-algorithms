package com.kp.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.kp.objects.restaurant.Dish;

public class Stream {

   public static void main(String[] args) {
      List<Dish> dishes = new ArrayList<>();
      dishes.add(new Dish("pork", 800, false));
      dishes.add(new Dish("beef", 700, false));
      dishes.add(new Dish("chicken", 400, false));
      dishes.add(new Dish("french fries", 530, true));
      dishes.add(new Dish("rice", 350, true));
      dishes.add(new Dish("season fruit", 120, true));
      List<String> dishesLowCalories = dishes
            .stream()
            .filter(dish -> dish.getCalories() < 400)
            .sorted(Comparator.comparing(Dish::getCalories))
            .map(Dish::getName)
            .collect(Collectors.toList());

      System.out.println(dishesLowCalories);
      List<String> dishesNameHighCalories = dishes
            .parallelStream()
            .filter(dish -> dish.getCalories() > 700)
            .filter(dish -> !dish.getVegetarian())
            .sorted(Comparator.comparing(Dish::getCalories).reversed())
            .map(Dish::getName)
            .collect(Collectors.toList());
      System.out.println(dishesNameHighCalories);
   }

}
