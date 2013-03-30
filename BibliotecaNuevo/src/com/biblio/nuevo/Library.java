package com.biblio.nuevo;

import java.io.IOException;

public class Library {
    private LibraryConsole console;
    private Inventory inventory;
    private Menu menu;

    public Library(LibraryConsole console) {
        this.console = console;
        inventory = new Inventory();
        menu = new Menu();
        menu.addOption("Show All Books");
    }

    public void run() throws IOException {
        console.print("Welcome to the Biblioteca!");
        int selectedMenuOption = -2;
while(true) {
        try {
            selectedMenuOption = Integer.parseInt(console.read());
        }
        catch (NumberFormatException e) {
            System.err.println("This is not a valid selection. Please input a number");
        }

        if (selectedMenuOption == -1) {
            console.print("Goodbye");
            return;
        }
        if (selectedMenuOption != -2) {
            String chosenOption = menu.selectOption(selectedMenuOption);
            evaluateOption(chosenOption);
        }
    }
    }
    private void evaluateOption(String chosenOption) {
        if(chosenOption.equals("quit")){
            console.print("Goodbye");
        }
        else
            console.print(inventory.getBookTitles());
    }

    public void addToCollection(Book book) {
        inventory.add(book);
    }
}
