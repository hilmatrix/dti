package com.hilmatrix.exercise.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseDay5 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
        System.out.println("---------------------------");
        System.out.println("Exercise Day 5. Select 0 to exit");
        System.out.println("1) create word guess game");
        System.out.println("2) currency conversion");
        System.out.println("3) remove odd number");
        System.out.println("4) fizz buzz");
        System.out.println("5) find pair");

        try {
            System.out.print("Select task number : ");
            taskSelection = scanner.nextInt();
        } catch (Exception e) {
            scanner = new Scanner(System.in);
            continue;
        }

        scanner = new Scanner(System.in);

        switch (taskSelection) {
            case 1 : runTask1wordGuess(scanner); break;
            case 2 : runTask2currencyConversion(scanner); break;
            case 3 : runTask3removeOdd(scanner); break;
            case 4 : runTask4fizzBuzz(scanner); break;
            case 5 : runTask5findPair(scanner); break;
        }

        if (taskSelection == 0)
            break;
        }
    }

    public static void runTask1wordGuess(Scanner scanner) {
        String[] WORDS = {"kucing", "cendol", "nuklir", "pohon", "sarden"};
        WordGuess wordGuess = new WordGuess(WORDS, 6, scanner);
        wordGuess.startGame();
    }

    public enum Currency {NONE, USD, EUR, GBP, JPY}

    public static void runTask2currencyConversion(Scanner scanner) {
        final double USD_TO_EUR = 0.92;
        final double EUR_TO_USD = 0.64;
        final double USD_TO_GBP = 0.79;
        final double USD_TO_JPY = 147.65;

        System.out.print("Enter amount to convert : ");
        double amount = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the source currency (USD, EUR, GBP, JPY) : ");
        Currency inputCurrency = checkCurrency(scanner.nextLine());
        if (inputCurrency.equals(Currency.NONE)) {
            System.out.println("Error, currency not found");
            return;
        }

        System.out.print("Enter the target currency (USD, EUR, GBP, JPY) : ");
        Currency outputCurrency = checkCurrency(scanner.nextLine());
        if (outputCurrency.equals(Currency.NONE)) {
            System.out.println("Error, currency not found");
            return;
        }

        System.out.print("Output  : ");
        if (inputCurrency == outputCurrency) {
            System.out.println(amount);
        } else {
            double convertedToUsd = switch (inputCurrency) {
                case EUR -> amount * EUR_TO_USD;
                case GBP -> amount / USD_TO_GBP;
                case JPY -> amount / USD_TO_JPY;
                default -> amount;
            };
            double outputAmount = switch (outputCurrency) {
                case EUR -> convertedToUsd * USD_TO_EUR;
                case GBP -> convertedToUsd * USD_TO_GBP;
                case JPY -> convertedToUsd * USD_TO_JPY;
                default -> convertedToUsd;
            };
            System.out.println(outputAmount);
        }
    }

    public static Currency checkCurrency(String strCurrency) {
        Currency result = Currency.NONE;
        if (strCurrency.toLowerCase().contains("USD".toLowerCase()))
            result = Currency.USD;
        else if (strCurrency.toLowerCase().contains("EUR".toLowerCase()))
            result = Currency.EUR;
        else if (strCurrency.toLowerCase().contains("GBP".toLowerCase()))
            result = Currency.GBP;
        else if (strCurrency.toLowerCase().contains("JPY".toLowerCase()))
            result = Currency.JPY;
        return result;
    }

    public static void runTask3removeOdd(Scanner scanner) {
        System.out.print("Input number separated by space : ");

        String strNumber = scanner.nextLine();
        String[] strNumberArray = strNumber.split(" ");

        List<Integer> numberArray = new ArrayList<>();

        for (String value : strNumberArray) {
            numberArray.add(Integer.valueOf(value));
        }

        removeOddNumber(numberArray);

        System.out.println("Output : ");
        for (int value : numberArray) {
            System.out.print(" " + value);
        }
        System.out.println();
    }

    public static void removeOddNumber(List<Integer> array) {
        for (int loop = 0; loop < array.size(); loop++) {
            if (array.get(loop) % 2 == 1) {
                array.remove(loop);
            }
        }
    }

    public static void runTask4fizzBuzz(Scanner scanner) {
        System.out.print("Input : ");
        int n = scanner.nextInt();

        if (n < 1)
            return;

        for (int loop = 1; loop < n; loop++) {
            System.out.print(fizzBuzz(loop) + ", ");
        }
        System.out.println(fizzBuzz(n));
    }

    public static String fizzBuzz(int n) {
        if ((n % 3 == 0) && (n % 5 == 0)) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }

    public static void runTask5findPair(Scanner scanner) {
        System.out.print("Input number separated by space : ");

        String strNumber = scanner.nextLine();
        String[] strNumberArray = strNumber.split(" ");

        List<Integer> numberArray = new ArrayList<>();

        for (String value : strNumberArray) {
            numberArray.add(Integer.valueOf(value));
        }

        System.out.print("Input target : ");

        int target = scanner.nextInt();
        int pairOne = -1;
        int pairTwo = -1;

        for (int loopFirst = 0; loopFirst < numberArray.size() - 1; loopFirst++) {
            for (int loopSecond = loopFirst + 1; loopSecond < numberArray.size(); loopSecond++) {
                if ((numberArray.get(loopFirst) + numberArray.get(loopSecond)) == target) {
                    pairOne = loopFirst;
                    pairTwo = loopSecond;
                    loopFirst = numberArray.size();
                    loopSecond = numberArray.size();
                    break;
                }
            }
        }

        if (pairOne == -1) {
            System.out.println("Pair not exist");
        } else {
            System.out.printf("[%d,%d]\n",pairOne,pairTwo);
        }
    }
}
