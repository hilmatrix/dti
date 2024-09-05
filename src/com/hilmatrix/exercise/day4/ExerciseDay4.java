package com.hilmatrix.exercise.day4;

import java.util.Scanner;

public class ExerciseDay4 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 4. Select 0 to exit");
            System.out.println("1) create multiplication table");
            System.out.println("2) create row pattern");
            System.out.println("3) read n number of input from scanner");
            System.out.println("4) create a guessing game");
            System.out.println("5) swap case each charactor from string");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1: runTask1createMultiplicationTable(scanner);
                case 2: runTask2createPattern(scanner);
                case 3: runTask3countReadInput(scanner);
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1createMultiplicationTable(Scanner scanner) {
        System.out.print("Input number : ");

        int number = scanner.nextInt();
        if (number < 1)
            return;

        System.out.println("Output : ");

        for (int rowLoop = 1; rowLoop <= number; rowLoop++) {
            System.out.print(rowLoop);
            for (int columnLoop = 2; columnLoop <= number; columnLoop++) {
                System.out.printf("\t%d", rowLoop * columnLoop);
            }
            System.out.println();
        }
    }

    public static void runTask2createPattern(Scanner scanner) {
        System.out.print("Input number : ");

        int number = scanner.nextInt();
        if (number < 1)
            return;

        System.out.println("Output : ");

        for (int rowLoop = 1; rowLoop <= number; rowLoop++) {
            for (int columnLoop = 1; columnLoop <= number; columnLoop++) {
                System.out.printf("*");
            }
        }
    }

    public static void runTask3countReadInput(Scanner scanner) {
        int inputCount = 0;
        boolean stop = false;

        System.out.println("Input anything, type stop to exit");

        do {
            System.out.print("Input : ");
            String strInput = scanner.nextLine();
            if (strInput.contains("stop")) {
                stop = true;
            } else {
                inputCount++;
            }
        } while (!stop);

        System.out.println("Output : You gave " + inputCount + " inputs");
    }
}
