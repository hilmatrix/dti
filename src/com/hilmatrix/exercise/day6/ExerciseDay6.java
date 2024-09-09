package com.hilmatrix.exercise.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseDay6 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 6. Select 0 to exit");
            System.out.println("1) rotate array");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1 : runTask1arrayRotation(scanner);
            }

            if (taskSelection == 0)
                break;
        }
    }


    public static void runTask1arrayRotation(Scanner scanner) {
        System.out.print("Input number separated by space : ");

        String strNumber = scanner.nextLine();
        String[] strNumberArray = strNumber.split(" ");

        List<Integer> numberArray = new ArrayList<>();

        for (String value : strNumberArray) {
            numberArray.add(Integer.valueOf(value));
        }

        List<Integer> shiftedArray = new ArrayList<>();

        System.out.print("Input d number to rotate : ");
        int d = scanner.nextInt();
        d = d % numberArray.size();

        for (int loop = 0; loop < numberArray.size(); loop++) {
            int nextIndex = (loop + d) % numberArray.size();
            shiftedArray.add(numberArray.get(nextIndex));
        }

        for (int value : shiftedArray) {
            System.out.println(value);
        }
    }
}
