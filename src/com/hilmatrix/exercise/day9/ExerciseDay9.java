package com.hilmatrix.exercise.day9;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class ExerciseDay9 {
    public static boolean login = false;
    public static String accountID = null;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Database.initialize();

        boolean quit = false;
        int input;


        while (!quit) {
            if (!login) {
                System.out.println("-".repeat(30));
                System.out.println("1. List accounts");
                System.out.println("2. Create an account");
                System.out.println("3. Login");
                System.out.println("0. Exit");

                input = readInputRange(scanner, 0, 3);

                switch (input) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        printAccounts();
                        break;
                    case 2:
                        createAcount(scanner);
                        break;
                    case 3:
                        login(scanner);
                        break;
                }
            } else {
                System.out.println("-".repeat(30));
                System.out.println("1. List Task");
                System.out.println("2. New Task");
                System.out.println("3. Delete Task");
                System.out.println("4. Logout");
                System.out.println("0. Exit");

                input = readInputRange(scanner, 0, 4);

                switch (input) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        printTask();
                        break;
                    case 2 :
                        newTask(scanner);
                        break;
                    case 3 :
                        removeTask(scanner);
                        break;
                    case 4:
                        login = false;
                        break;

                }
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

    public static void printTask() {
        Account account = Database.getAccount(accountID);
        List<String> taskList = account.getTaskList();
        System.out.println("-".repeat(30));

        for (int loop = 0; loop < taskList.size(); loop++) {
            Task task = Database.getTask(taskList.get(loop));
            System.out.printf("%d. %s\n",
                    (loop + 1),
                    task.getDetails());
        }
    }

    public static void newTask(Scanner scanner) {
        System.out.println("-".repeat(30));
        System.out.println("Please input task details");
        String newTaskDetails = scanner.nextLine();
        Database.addTask(accountID, newTaskDetails);
    }

    public static void removeTask(Scanner scanner) {
        Account account = Database.getAccount(accountID);
        List<String> taskList = account.getTaskList();

        if (taskList.isEmpty())
            return;

        System.out.println("-".repeat(30));
        System.out.println("Please select which task you want to delete");
        System.out.println("Input 0 to cancel");

        int taskSelect = readInputRange(scanner, 0, taskList.size());
        taskSelect--;

        if (taskSelect == -1)
            return;

        String selectedTaskID = taskList.get(taskSelect);
        Database.deleteTask(selectedTaskID);
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

    public static void login(Scanner scanner) {
        System.out.println("-".repeat(30));
        System.out.println("Login. Please input details");

        System.out.print("username = ");
        String username = scanner.nextLine();
        System.out.print("password = ");
        String password = scanner.nextLine();


        String loginID = Database.login(username, password);
        if (loginID != null) {
            System.out.println("Login successfull");
            accountID = loginID;
            login = true;
        } else {
            System.out.println("Login failed");
        }
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


