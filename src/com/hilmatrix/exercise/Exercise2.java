package com.hilmatrix.exercise;

import java.util.Scanner;

public class Exercise2 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise 2. Select 0 to return");
            System.out.println("Task 1 Fahrenheit to Celcius conversion");
            System.out.println("Task 2 cm to km conversion");
            System.out.println("Task 3 check a number even or odd");
            System.out.println("Task 4 remove first occurence a string");
            System.out.println("Task 5 check palindrome");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1: runTask1(scanner); break;
                case 2: runTask2(scanner); break;
                case 3: runTask3(scanner); break;
                case 4: runTask4(scanner); break;
                case 5: runTask5(scanner); break;
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1(Scanner scanner) {
        System.out.print("Input fahrenheit : ");
        double fahrenheit = scanner.nextDouble();
        System.out.println("Output fahrenheit : " + (fahrenheit - 32) * 5 / 9);
    }

    public static void runTask2(Scanner scanner) {
        System.out.print("Input cm : ");
        double cm = scanner.nextDouble();
        System.out.println("Output km : " + cm/10000 + " km");
    }

    public static void runTask3(Scanner scanner) {
        System.out.print("Input number : ");
        int number = scanner.nextInt();
        if ((number % 2) == 0)
            System.out.println(number + " is Even");
        else
            System.out.println(number + " is Odd");
    }

    public static void runTask4(Scanner scanner) {
        System.out.print("Input base string : ");
        String baseStr = scanner.nextLine();
        System.out.print("Input string to delete : ");
        String removeStr = scanner.nextLine();
        String resultStr = baseStr.replaceFirst(removeStr, "");
        System.out.println("Output string : " + resultStr);
    }

    public static void runTask5(Scanner scanner) {
        System.out.print("Input string : ");
        String inputStr = scanner.nextLine();
        String reversedStr = new StringBuilder(inputStr).reverse().toString();
        if (inputStr.equalsIgnoreCase(reversedStr))
            System.out.println("Output : is palindrome");
        else
            System.out.println("Output : not a palindrome");
    }
}
