package com.hilmatrix.exercise.day2;

import java.util.Scanner;

public class ExerciseDay2 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 2. Select 0 to exit");
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
        System.out.println("Output celsius : " + (fahrenheit - 32) * 5 / 9);
    }

    public static void runTask2(Scanner scanner) {
        System.out.print("Input cm : ");
        double cm = scanner.nextDouble();
        System.out.println("Output km : " + cm/100000 + " km");
    }

    public static void runTask3(Scanner scanner) {
        System.out.print("Input number : ");
        int number = scanner.nextInt();
        if ((number % 2) == 0)
            System.out.println("Output : " + number + " is Even");
        else
            System.out.println("Output : " + number + " is Odd");
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
        String inputStr = scanner.nextLine().toLowerCase();
        boolean equal = true;
        int lastIndex = inputStr.length()-1;

        for (int loop = 0; loop < inputStr.length()/2; loop++) {
            if (!(inputStr.charAt(loop) == inputStr.charAt(lastIndex-loop))) {
                equal = false;
                break;
            }
        }

        if (equal)
            System.out.println("Output : is palindrome");
        else
            System.out.println("Output : not a palindrome");
    }
}
