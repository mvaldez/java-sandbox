package com.sandbox.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(byYear);

        // unique cities
        List<String> uniqueCities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCities);

        // Find all traders from Cambridge and sort them by name
        List<Trader> camTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(camTraders);

        //  Return a string of all traders’ names sorted alphabetically
        String names = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b + ", ");
        System.out.println(names);

        // Are any traders based in Milan?
        Boolean hasMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("There is a trader in Milan: " + hasMilan);

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
        Optional<Transaction> minTrans = transactions.stream()
                .min(comparing(Transaction::getValue));
        System.out.println(minTrans.get());
    }

}
