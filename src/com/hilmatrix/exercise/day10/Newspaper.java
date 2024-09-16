package com.hilmatrix.exercise.day10;

public class Newspaper extends LibraryMaterial {
    private String content;
    private int currentPage;
    private boolean firstTime;

    public Newspaper(String libraryID, String materialID, String title, String author, String date, String content) {
        super(libraryID, materialID, title, author, date);
        this.content = content;
        currentPage = 0;
        firstTime = true;
    }

    @Override
    public void use() {
        if (firstTime) {
            printDetails();
            firstTime = false;
            return;
        }

        System.out.println(content);
        firstTime = true;
    }
}
