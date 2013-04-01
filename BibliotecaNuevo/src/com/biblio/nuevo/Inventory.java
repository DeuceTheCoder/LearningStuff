package com.biblio.nuevo;

import java.util.ArrayList;

public class Inventory {


    private ArrayList<Book> bookList;
    private ArrayList<Book> reservedBookList;

    public Inventory() {
        bookList = new ArrayList<Book>();
        reservedBookList = new ArrayList<Book>();
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

	public String getReservedBookTitles() {
		String titles = "";
        for(Book book : reservedBookList)
            titles += book.getTitle() + '\n';

        return titles;
	}

	public void reserve(String title) {
		for(Book book : bookList) {
			if(book.getTitle().equals(title))
				reservedBookList.add(book);
		}
		return;
	}
}
