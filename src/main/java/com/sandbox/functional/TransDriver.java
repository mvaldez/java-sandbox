package com.sandbox.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransDriver {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        // sorted by value small to large; only transactions in 2011
        List<Transaction> byYear = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((a, b) -> Integer.compare(a.getValue(), b.getValue()))
                .collect(Collectors.toList());
        System.out.println(byYear);

        // unique cities
        List<String> uniqueCities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCities);

        // Find all traders from Cambridge and sort them by name
        List<String> camTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .map(Trader::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(camTraders);

        //  Return a string of all traders’ names sorted alphabetically
        String names = transactions.stream()
                .map(Transaction::getTrader)
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .map(Trader::getName)
                .distinct()
                .reduce("", (a, b) -> a + b + ", ");
        System.out.println(names);

        // Are any traders based in Milan?
        Optional<Trader> milanTrader = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Milan"))
                .findAny();
        System.out.println(milanTrader.isPresent());

        // Print all transactions’ values from the traders living in Cambridge.
        System.out.println("Transaction values from traders in Cambridge");
        transactions.stream()
                .filter(trader -> trader.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // What’s the highest value of all the transactions?
        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("max value = " + maxValue.get());

        // Find the transaction with the smallest value
        transactions.stream()
                .filter(t -> transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::min).orElseGet(() -> 0)
                        .equals(t.getValue()))
                .forEach(System.out::println);
    }

}
