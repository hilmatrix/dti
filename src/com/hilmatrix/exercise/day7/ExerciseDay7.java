package com.hilmatrix.exercise.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseDay7 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 7. Select 0 to exit");
            System.out.println("Task 1 calculate average");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1 : runTask1calculateAverage(scanner); break;
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1calculateAverage(Scanner scanner) {
        System.out.println("Input number, enter q to finish");
        boolean quit = false;
        List<Integer> integerArray = new ArrayList<>();

        while (!quit) {
            String strInput = scanner.nextLine();

            try {
                int newInteger = Integer.parseInt(strInput);
                integerArray.add(newInteger);
            } catch (NumberFormatException e) {
                if (strInput.isBlank() || (strInput.charAt(0) != 'q') ){
                    System.out.println("Invalid input. Please input q to finish");
                } else {
                    quit = true;
                }
            }
        }

        if (integerArray.size() <= 0)
            return;

        double average = 0;
        for (int number : integerArray) {
            average += number;
        }
        System.out.println("Average = " + average);
    }
}
