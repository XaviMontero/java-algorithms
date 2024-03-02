package com.kp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
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
      dishes.add(new Dish("pizza", 550, true));
      dishes.add(new Dish("prawns", 300, false));
      dishes.add(new Dish("salmon", 450, false));
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

      List<String> dishesVegetarian = dishes.stream().filter(Dish::isVegetarian).map(Dish::getName).collect(Collectors.toList());
      System.out.println(dishesVegetarian);

      List<Dish> filterDishesForCalories = dishes.stream().takeWhile(dish -> dish.getCalories() > 300).limit(3).collect(Collectors.toList());
      filterDishesForCalories.forEach(System.out::println);

      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

      List<Integer> square = numbers.stream().map(n -> n * n).collect(Collectors.toList());
      System.out.println(square);

      List<Integer> numbers1 = Arrays.asList(1, 2, 3);
      List<Integer> numbers2 = Arrays.asList(3, 4);

      List<Integer> squares = numbers1.stream().map(i -> i * i).collect(Collectors.toList());

      List<int[]> pairs = numbers1
            .stream()
            .flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
            .collect(Collectors.toList());

      List<int[]> pairsDiv = numbers1
            .stream()
            .flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
            .collect(Collectors.toList());



   }

}
