package com.hilmatrix.exercise.day9;

import java.util.List;
import java.util.Scanner;

public class ExerciseDay9 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Database.initialize();

        boolean quit = false;
        int input;

        while (!quit) {
            System.out.println("-".repeat(30));
            System.out.println("1. List accounts");
            System.out.println("2. Create an account");
            System.out.println("0. Exit");

            input = readInputRange(scanner, 0, 4);

            switch (input) {
                case 0 : quit = true; break;
                case 1 : printAccounts(); break;
                case 2 : createAcount(scanner); break;
            }
        }
    }

    public static void printAccounts() {
        List<String> accountList = Database.getAccountList();
        System.out.println("-".repeat(30));

        for (int loop = 0; loop < accountList.size(); loop++) {
            Account account = Database.getAccount(loop);
            System.out.printf("%d. %s\n",
                    (loop + 1),
                    account.getUsername());
        }
    }

    public static void createAcount(Scanner scanner) {
        System.out.println("-".repeat(30));
        System.out.println("Creating new account. Please input details");

        System.out.print("username = ");
        String username = scanner.nextLine();
        System.out.print("password = ");
        String password = scanner.nextLine();

        Database.addAccount(username, password);
    }

    public static int readInputRange(Scanner scanner, int min, int max) {
        boolean correctInput = false;
        int result = min;

        while (!correctInput) {
            System.out.printf("Enter input between %d and %d : ", min, max);

            try {
                result = Integer.parseInt(scanner.nextLine());

                if ((result >= min) && (result <= max)) {
                    correctInput = true;
                } else {
                    System.out.println("Input outside of range");
                }
            } catch (Exception e) {
                System.out.println("Input parsing error");
            }
        }

        return result;
    }
}
