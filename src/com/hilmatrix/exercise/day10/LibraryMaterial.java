package com.hilmatrix.exercise.day10;

public class LibraryMaterial {
    private final String libraryID;
    private final String materialID;
    private final String title;
    private final String author;
    private final String date;
    private boolean borrowed;

    public String getLibraryID() {
        return libraryID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getMaterialID() {
        return materialID;
    }

    public LibraryMaterial(String libraryID, String materialID, String title, String author, String date) {
        this.libraryID = libraryID;
        this.materialID = materialID;
        this.title = title;
        this.author = author;
        this.date = date;
        borrowed = false;
    }

    public boolean isAvailable() {
        return !borrowed;
    }

    public boolean borrow() {
        if (!borrowed) {
            borrowed = true;
            return true;
        }
        return false;
    }

    public void returnMaterial() {
        borrowed = false;
    }

    public LibraryMaterial copy(String uniqueID) {
        return new LibraryMaterial(uniqueID, this.materialID, this.title, this.author, this.date);
    }

    public void use() {
        printDetails();
    }

    protected void printDetails() {
        System.out.println("Title = " + title);
        System.out.println("Author = " + author);
        System.out.println("Date = " + date);
    }
}
