package com.hilmatrix.exercise;

import java.util.Scanner;

public class Exercise2 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;


        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise 2 task available. Select 0 to return");
            System.out.println("Task 1 Fahrenheit to Celcius conversion");
            System.out.println();

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1:
                    System.out.print("Input fahrenheit : ");
                    double fahrenheit = scanner.nextDouble();
                    System.out.println("Output fahrenheit : " + (fahrenheit - 32) * 5 / 9);
                    break;
            }

            if (taskSelection == 0)
                break;
        }
    }
}
