package com.hilmatrix;
import java.util.Scanner;

import com.hilmatrix.exercise.day1.ExerciseDay1;
import com.hilmatrix.exercise.day2.ExerciseDay2;
import com.hilmatrix.exercise.day3.ExerciseDay3;
import com.hilmatrix.exercise.day4.ExerciseDay4;
import com.hilmatrix.exercise.day5.ExerciseDay5;
import com.hilmatrix.exercise.day6.ExerciseDay6;
import com.hilmatrix.exercise.day7.ExerciseDay7;


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
            System.out.println("Exercise available : 1-7. Select  0 to exit");
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
                        ExerciseDay1.start();
                        break;
                    case 2:
                        ExerciseDay2.start();
                        break;
                    case 3:
                        ExerciseDay3.start();
                        break;
                    case 4:
                        ExerciseDay4.start();
                        break;
                    case 5:
                        ExerciseDay5.start();
                        break;
                    case 6:
                        ExerciseDay6.start();
                        break;
                    case 7:
                        ExerciseDay7.start();
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
