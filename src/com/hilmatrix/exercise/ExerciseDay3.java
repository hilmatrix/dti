package com.hilmatrix.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseDay3 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 3. Select 0 to exit");
            System.out.println("1) calculate sum digit. 2) check number is prime");
            System.out.println("3) find largest number. 4) simple calculator");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1: runTask1countDigit(scanner); break;
                case 2: runTask2checkIsPrime(scanner); break;
                case 3: runTask3findLargest(scanner); break;
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1countDigit(Scanner scanner) {
        System.out.print("Input number : ");
        int number = scanner.nextInt();
        int count = 0;
        while (number > 0) {
            count += number % 10;
            number = number / 10;
        }
        System.out.println("Output : Digit count is " + count);
    }

    public static void runTask2checkIsPrime(Scanner scanner) {
        System.out.print("Input number : ");
        int number = scanner.nextInt();
        boolean isPrime = true;

        if (number < 2)
            isPrime = false;
        else {
            for (int loop = 2; loop < number; loop++) {
                if (number % loop == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        String resultStr = " not a prime";
        if (isPrime)
            resultStr = " is a prime";

        System.out.println("Output : " + number + resultStr);
    }

    public static void runTask3findLargest(Scanner scanner) {
        System.out.print("Input number separated by comma : ");

        String strNumber = scanner.nextLine();
        String[] strNumberArray = strNumber.replaceAll(" ", "").split(",");
        int currentValue = Integer.valueOf(strNumberArray[0]);

        if (strNumberArray.length > 1) {
            for (int loop = 1; loop < strNumberArray.length; loop++) {
                int nextValue = Integer.valueOf(strNumberArray[loop]);
                if (currentValue < nextValue)
                    currentValue = nextValue;
            }
        }

        System.out.println("Output : The highest number is " + currentValue);
    }
}
