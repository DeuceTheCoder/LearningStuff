package com.biblio.nuevo;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        LibraryConsole console = new LibraryConsole(null, System.out);
        Menu menu = new Menu();
        menu.showOptions();
    }
}
