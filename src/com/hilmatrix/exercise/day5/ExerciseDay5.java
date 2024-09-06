package com.hilmatrix.exercise.day5;

import java.util.Scanner;

public class ExerciseDay5 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
        System.out.println("---------------------------");
        System.out.println("Exercise Day 5. Select 0 to exit");
        System.out.println("1) create word guess game");

        try {
            System.out.print("Select task number : ");
            taskSelection = scanner.nextInt();
        } catch (Exception e) {
            scanner = new Scanner(System.in);
            continue;
        }

        scanner = new Scanner(System.in);

        switch (taskSelection) {
            case 1 : runTask1wordGuess();
        }

        if (taskSelection == 0)
            break;
        }
    }

    public static void runTask1wordGuess() {
        String[] WORDS = {"kucing", "kepiting", "rawon", "pohon", "sarden"};
        WordGuess wordGuess = new WordGuess(WORDS);
        wordGuess.startGame();
    }
}
