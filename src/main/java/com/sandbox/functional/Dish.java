package com.sandbox.functional;

import com.google.common.base.Objects;

public class Dish {
   private final String name;
   private final boolean vegetarian;
   private final int calories;
   private final Type type;

   public Dish(String name, boolean vegetarian, int calories, Type type) {
      this.name = name;
      this.vegetarian = vegetarian;
      this.calories = calories;
      this.type = type;
   }

   public String getName() {
      return name;
   }

   public boolean isVegetarian() {
      return vegetarian;
   }

   public int getCalories() {
      return calories;
   }

   public Type getType() {
      return type;
   }

   @Override
   public String toString() {
      return Objects.toStringHelper(this)
         .add("name", name)
         .add("vegetarian", vegetarian)
         .add("calories", calories)
         .add("type", type)
         .toString();
   }

   public enum Type {MEAT, FISH, OTHER}
}