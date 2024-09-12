package com.hilmatrix.exercise.day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Database {
    private static HashMap<String, Account> accountMap;
    private static HashMap<String, Task> taskMap;
    private static List<String> accountList;
    private static List<String> taskList;

    public static void initialize() {
        accountMap = new HashMap<>();
        accountList = new ArrayList<>();
        taskMap = new HashMap<>();
        taskList = new ArrayList<>();
    }

    public static void addAccount(String username, String password) {
        if (Account.isInputValid(username, password)) {
            String accountID = UUID.randomUUID().toString();
            Account newAccount = new Account(accountID, username, password);
            accountMap.put(accountID, newAccount);
            accountList.add(accountID);
        } else {
            System.out.println("Input is not valid");
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
}
