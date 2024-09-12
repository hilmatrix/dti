package com.hilmatrix.exercise.day9;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String id;
    private final String username;
    private final String password;
    public List<String> taskList;

    public void addTask(String taskID) {
        taskList.add(taskID);
    }

    public void removeTask(String taskID) {
        taskList.remove(taskID);
    }

    public List<String> getTaskList() {
        return taskList;
    }

    public Account(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

        taskList = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }
    public String getId() {
        return id;
    }

    public static boolean isInputValid(String username, String password) {
        if (username.isEmpty())
            return false;
        if (password.isEmpty())
            return false;
        if (username.length() < 4)
            return false;
        if (username.contains(" "))
            return false;
        if (password.length() < 4)
            return false;
        return true;
    }

    public boolean isLoginValid(String username, String password) {
        return (this.username.equals(username)) && (this.password.equals(password));
    }
}
