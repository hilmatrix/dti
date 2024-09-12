package com.hilmatrix.exercise.day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Database {
    private static HashMap<String, Account> accountMap;
    private static HashMap<String, Task> taskMap;
    private static HashMap<String, String> usernameMap;

    private static List<String> accountList;
    private static List<String> taskList;

    public static void initialize() {
        accountMap = new HashMap<>();
        accountList = new ArrayList<>();
        taskMap = new HashMap<>();
        taskList = new ArrayList<>();
        usernameMap = new HashMap<>();
    }

    public static void addAccount(String username, String password) {
        if (usernameMap.containsKey(username)) {
            System.out.println("Username already exist");
            return;
        }
        if (Account.isInputValid(username, password)) {
            String accountID = UUID.randomUUID().toString();
            Account newAccount = new Account(accountID, username, password);
            usernameMap.put(newAccount.getUsername(), accountID);
            accountMap.put(accountID, newAccount);
            accountList.add(accountID);
        } else {
            System.out.println("Input is not valid");
        }
    }

    public static void addTask(String accountID, String details) {
        String taskID = UUID.randomUUID().toString();
        Task task = new Task(taskID, accountID, details);
        taskMap.put(taskID, task);
        taskList.add(taskID);

        Account account = accountMap.get(accountID);
        account.addTask(taskID);
    }

    public static String login(String username, String password) {
        String accountID = usernameMap.get(username);
        if (accountID == null)
            return null;

        Account account = accountMap.get(accountID);
        if (account.isLoginValid(username, password)) {
            return account.getId();
        } else {
            return null;
        }
    }

    public static List<String> getAccountList() {
        return accountList;
    }

    public static List<String> getTaskList() {
        return taskList;
    }

    public static Account getAccount(String index) {
        return accountMap.get(index);
    }

    public static Account getAccount(int index) {
        return getAccount(accountList.get(index));
    }

    public static Task getTask(String index) {
        return taskMap.get(index);
    }

    public static Task getTask(int index) {
        return getTask(taskList.get(index));
    }

    public static void deleteTask(String taskID) {
        Task task = taskMap.get(taskID);
        Account account = accountMap.get(task.getUserID());

        account.removeTask(taskID);
        taskMap.remove(taskID);
        taskList.remove(taskID);
    }
}
