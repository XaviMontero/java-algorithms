package com.kp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kp.objects.example.Trader;
import com.kp.objects.example.Transaction;
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

      List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j })).collect(Collectors.toList());

      List<int[]> pairsDiv = numbers1
            .stream()
            .flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
            .collect(Collectors.toList());

      Boolean dishesIsHealting = dishes.stream().allMatch(dish -> dish.getCalories() < 1000);
      System.out.println(dishesIsHealting);
      Dish getDish = dishes.stream().filter(Dish::isVegetarian).findAny().orElse(null);

      List<Integer> listNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
      Integer sum = listNumbers.stream().reduce(0, Integer::sum);
      System.out.println(sum);
      Integer max = listNumbers.stream().reduce(0, Integer::max);
      System.out.println(max);
      Integer min = listNumbers.stream().reduce(0, Integer::min);
      System.out.println(min);
      Integer count = listNumbers.stream().map(n -> 1).reduce(0, Integer::sum);
      System.out.println(count);
      Integer mul = listNumbers.stream().reduce(1, (a, b) -> a * b);
      System.out.println(mul);
      result();

      int getCalories = dishes.stream().mapToInt(Dish::getCalories).sum();
      System.out.println(getCalories);

      int maxCalories = dishes.stream().mapToInt(Dish::getCalories).max().orElse(1);
      System.out.println(maxCalories);
   }

   private static void result() {
      List<Transaction> transactions = getExam();
      List<Transaction> getTransaction2011 = transactions
            .stream()
            .filter(x -> x.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue).reversed())
            .collect(Collectors.toList());
      getTransaction2011.forEach(System.out::println);
      List<String> getAllCyti = transactions.stream().map(x -> x.getTrader().getCity()).distinct().collect(Collectors.toList());
      getAllCyti.forEach(System.out::println);
      List<String> getAllCambridge = transactions
            .stream()
            .filter(x -> x.getTrader().getCity().equals("Cambridge"))
            .sorted(Comparator.comparing(x -> x.getTrader().getName()))
            .map(x -> x.getTrader().getName())
            .distinct()
            .collect(Collectors.toList());
      getAllCambridge.forEach(System.out::println);
      System.out.println("------");
      List<String> getAllNames = transactions
            .stream()
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.toList());
      getAllNames.forEach(System.out::println);

      Boolean isMilan = transactions.stream().anyMatch(x -> x.getTrader().getCity().equals("Milan"));
      System.out.println("------");
      System.out.println(isMilan);
      System.out.println("------");
      List<Integer> listOfValues = transactions
            .stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .collect(Collectors.toList());

      listOfValues.forEach(System.out::println);

      Integer max = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);

      System.out.println(max);
      Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));

      System.out.println(min);


   }

   private static List<Transaction> getExam() {
      Trader raoul = new Trader("Raoul", "Cambridge");
      Trader mario = new Trader("Mario", "Milan");
      Trader alan = new Trader("Alan", "Cambridge");
      Trader brian = new Trader("Brian", "Cambridge");
      List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));
      return transactions;

   }
}
