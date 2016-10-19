package com.sandbox.functional;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Baz {

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Foo> inventory = new ArrayList<>();
        inventory.add(new Foo("red", 1));
        inventory.add(new Foo("blue", 4));
        inventory.add(new Foo("red", 3));
        inventory.add(new Foo("blue", 2));

        Predicate<Foo> redOnly = (foo) -> "red".equals(foo.getValue());

        List<Foo> fooz = filter(inventory, (foo) -> "red".equals(foo.getValue()));
        System.out.println(fooz);

        List<Foo> reds = filter(inventory, redOnly);

        List<Foo> evenFooz = filter(inventory, (foo) -> foo.getInteger() % 2 == 0);
        System.out.println(evenFooz);

        inventory.sort((Foo f1, Foo f2) -> f1.getInteger().compareTo(f2.getInteger()));
        System.out.println(inventory);

        inventory.sort(Comparator.comparing(Foo::getInteger)
                .reversed());

        System.out.println(inventory);
    }

}
