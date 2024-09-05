package com.hilmatrix;
import java.util.Scanner;

import com.hilmatrix.exercise.part1.ExerciseDay1;
import com.hilmatrix.exercise.part2.ExerciseDay2;
import com.hilmatrix.exercise.part3.ExerciseDay3;


public class Main {
    public static void main(String[] args) {
        runExercises();
    }

    public static void runExercises() {
        Scanner scanner = new Scanner(System.in);
        int exerciseSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Hilmatrix Exercise Selector");
            System.out.println("Exercise available : 1-3. Select  0 to exit");
            System.out.println();
            try {
                System.out.print("Select exercise number : ");
                exerciseSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            try {
                switch (exerciseSelection) {
                    case 1:
                        ExerciseDay1.run();
                        break;
                    case 2:
                        ExerciseDay2.run();
                        break;
                    case 3:
                        ExerciseDay3.run();
                        break;
                }
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                e.printStackTrace();
                System.out.println("Error at exercise " + exerciseSelection);
            }

            if (exerciseSelection == 0)
                break;
        }
    }
}
