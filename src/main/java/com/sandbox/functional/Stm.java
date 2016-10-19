package com.sandbox.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stm {


   public static void main(String[] args) {
      final List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                                                    new Dish("beef", false, 700, Dish.Type.MEAT),
                                                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                                                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                                                    new Dish("rice", true, 350, Dish.Type.OTHER),
                                                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                                                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                                                    new Dish("prawns", false, 300, Dish.Type.FISH),
                                                    new Dish("salmon", false, 450, Dish.Type.FISH));

      final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

      Integer count = menu.stream()
         .map(d -> 1)
         .reduce(0, Integer::sum);
      System.out.println("count=" + count);


      List<String> hiCalDishes = menu.stream()
         .filter((dish -> dish.getCalories() > 300))
         .distinct()
         .map(Dish::getName)
         .collect(Collectors.toList());

      System.out.println(hiCalDishes);

      List<Integer> squares = numbers.stream()
         .map(i -> i * i)
         .collect(Collectors.toList());

      System.out.println(squares);

      final List<Integer> list1 = Arrays.asList(1, 2, 3);
      final List<Integer> list2 = Arrays.asList(3, 4);

      List<List<Integer>> pairs = list1.stream()
         .flatMap(i1 -> list2.stream()
            .filter(i2 -> (i1 + i2) % 3 == 0)
            .map(i2 -> Arrays.asList(i1, i2)))
         .collect(Collectors.toList());

      System.out.println(pairs);

   }
}
