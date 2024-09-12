package com.hilmatrix.exercise.day9;

public class Account {
    private final String id;
    private final String username;
    private final String password;

    public Account(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
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
}
