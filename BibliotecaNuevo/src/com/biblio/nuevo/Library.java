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

    public void run() {
        console.print("Welcome to the Biblioteca!");
        int selectedMenuOption = -2;
		
        while(true) {
			
				console.print("Please enter a command number: ");
		        try {
		            selectedMenuOption = Integer.parseInt(console.read());
		        }
		        catch (NumberFormatException e) {
		            console.print("This is not a valid selection. Please input a number");
		        }
		        catch (IOException e) {
		        	System.err.println("Error: " + e.getMessage());
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
        if(chosenOption.equals("invalid")) {
        	console.print("Invalid option selected.  Please select a valid option.");
        }
        else
            console.print(inventory.getBookTitles());
    }

    public void addToCollection(Book book) {
        inventory.add(book);
    }
}
