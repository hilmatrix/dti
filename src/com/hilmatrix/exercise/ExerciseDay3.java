package com.hilmatrix.exercise;

import java.util.Scanner;

public class ExerciseDay3 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 3. Select 0 to exit");
            System.out.println("1) calculate sum digit. 2) check number is prime");

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
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1(Scanner scanner) {
        System.out.print("Input number : ");
        String strNumber = scanner.nextLine();
        int count = 0;
        for (int loop = 0; loop < strNumber.length(); loop++) {
            count += (int) strNumber.charAt(loop) - (int) '0';
        }
        System.out.println("Digit count : " + count);
    }
}
