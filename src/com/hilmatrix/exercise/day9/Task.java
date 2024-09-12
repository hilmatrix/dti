package com.hilmatrix.exercise.day9;

import java.util.ArrayList;
import java.util.List;

public class Task {
    public String id;
    public String userID;
    public String details;


    public Task(String id, String userID, String details) {
        this.id = id;
        this.userID = userID;
        this.details = details;
    }

    public String getUserID() {
        return userID;
    }

    public String getDetails() {
        return details;
    }
}
