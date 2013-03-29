package com.biblio.nuevo;

import java.util.ArrayList;

public class Inventory {


    private ArrayList<Book> bookList;

    public Inventory() {
        bookList = new ArrayList<Book>();
    }

    public int getNumberOfBooks() {
        return bookList.size();
    }

    public void add(Book book) {
        bookList.add(book);
    }

    public String getBookTitles() {
        String titles = "";
        for(Book book : bookList)
            titles += book.getTitle() + '\n';

        return titles;
    }
}
