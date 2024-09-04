package com.hilmatrix.exercise;

import java.lang.Math;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Exercise1 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise 1. Select 0 to return");
            System.out.println("Task 1 Find Rectangle Area");
            System.out.println("Task 2 Find Circle Area");
            System.out.println("Task 3 Find Third Angle");
            System.out.println("Task 4 Find days difference");
            System.out.println("Task 5 Find initial");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1: rectangleArea(scanner); break;
                case 2: circleArea(scanner); break;
                case 3: findingThirdAngle(scanner); break;
                case 4: findingDaysDifference(scanner); break;
                case 5: findingInitial(scanner); break;
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void rectangleArea(Scanner scanner) {
        System.out.println("Task 1. Finding rectangle area");

        System.out.print("Input length = ");
        int length = scanner.nextInt();
        System.out.print("Input width = ");
        int width = scanner.nextInt();

        System.out.println("Rectangle area = " + length * width);
        System.out.println();
    }

    public static void circleArea(Scanner scanner) {
        System.out.println("Task 2. Finding circle area");

        System.out.print("Input radius = ");
        int radius = scanner.nextInt();

        System.out.println("Circle diameter = " + radius * 2);
        System.out.println("Circle circumference = " + 2 * Math.PI * radius);
        System.out.println("Circle area = " + Math.PI * radius * radius);
        System.out.println();
    }

    public static void findingThirdAngle(Scanner scanner) {
        System.out.println("Task 3. Finding angle from known 2 angle");

        System.out.print("Input angle A = ");
        int angleA = scanner.nextInt();
        System.out.print("Input angle B = ");
        int angleB = scanner.nextInt();

        System.out.println("The angle between 2 angle = " + (180 - angleA - angleB));
        System.out.println();
    }

    public static void findingDaysDifference(Scanner scanner) {
        System.out.println("Task 4. Get days difference between 2 dates");

        System.out.print("Input date A = ");
        String strDateA = scanner.nextLine();
        System.out.print("Input date B = ");
        String strDateB = scanner.nextLine();

        LocalDate dateA = LocalDate.parse(strDateA);
        LocalDate dateB = LocalDate.parse(strDateB);
        System.out.println("Days difference = " + ChronoUnit.DAYS.between(dateA, dateB));
        System.out.println();
    }

    public static void findingInitial(Scanner scanner) {
        System.out.println("Task 5. Printing initial from name");

        System.out.print("Input name = ");
        String name = scanner.nextLine();

        String nameSplit[] = name.split(" ");
        String initial = "";
        for (int loop = 0; loop < nameSplit.length; loop ++) {
            if (nameSplit[loop].length() > 0)
                initial += nameSplit[loop].charAt(0);
        }
        initial = initial.toUpperCase();

        System.out.println("Initial = " + initial);
        System.out.println();
    }
}
