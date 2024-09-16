package com.hilmatrix.exercise.day10;

public class Book extends LibraryMaterial {
    private String[] contents;
    private int currentPage;
    private boolean firstTime;

    public Book(String libraryID, String materialID, String title, String author, String date, String[] contents) {
        super(libraryID, materialID, title, author, date);
        this.contents = contents;
        currentPage = 0;
        firstTime = true;
    }

    public void setContents(String[] contents) {
        this.contents = contents;
    }

    @Override
    public void use() {
        if (firstTime) {
            printDetails();
            firstTime = false;
            return;
        }

        System.out.println("Page " + (currentPage+1) + " " + contents[currentPage++]);
        if (currentPage >= contents.length) {
            currentPage = 0;
            firstTime = true;
        }
    }
}
