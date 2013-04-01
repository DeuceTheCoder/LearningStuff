package com.biblio.nuevo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        LibraryConsole console = new LibraryConsole(null, System.out);
        Menu menu = new Menu();
        menu.showOptions();
    }
}
