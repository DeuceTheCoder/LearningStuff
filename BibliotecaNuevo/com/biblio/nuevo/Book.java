package com.biblio.nuevo;

public class Book {
    private String title;

    public Book(String s) {
        setTitle(s);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
