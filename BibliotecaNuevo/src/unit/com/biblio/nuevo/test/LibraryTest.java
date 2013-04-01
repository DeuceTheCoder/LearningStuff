package unit.com.biblio.nuevo.test;

import com.biblio.nuevo.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private LibraryConsole mockConsole;
    private Library library;

    @Before
    public void setUp() throws Exception {
        mockConsole = mock(LibraryConsole.class);
        library = new Library(mockConsole);

    }

    @Test
    public void shouldDisplayWelcomeMessageWhenRun() throws IOException {
        when(mockConsole.read()).thenReturn("-1");

        library.run();

        verify(mockConsole).print("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
    	when(mockConsole.read()).thenReturn("0")
    			.thenReturn("0")
				.thenReturn("-1");
    	library.run();
    	verify(mockConsole, times(3)).print("Please enter a command number: ");
    }
    
    @Test
    public void shouldReadInputFromLibraryConsole() throws IOException {
        when(mockConsole.read()).thenReturn("-1");

        library.run();

        verify(mockConsole).read();
    }

    @Test
    public void shouldExitWhenMinusOneIsRead() throws IOException {
        when(mockConsole.read()).thenReturn("-1");

        library.run();
        verify(mockConsole, atMost(3)).print(anyString());
        verify(mockConsole).print("Goodbye");
    }

    @Test
    public void shouldPrintListOfAllBooksWhenOptionIsSelected() throws IOException {
        when(mockConsole.read()).thenReturn("0")
                .thenReturn("-1");
        Book book1 = new Book("Effective Java");
        Book book2 = new Book("War");
        library.addToCollection(book1);
        library.addToCollection(book2);

        library.run();

        verify(mockConsole).print(book1.getTitle() + "\n" + book2.getTitle() + "\n");
    }
    
    @Test
	public void shouldPrintErrorMessageWhenNonNumberIsRead() throws IOException {
		when(mockConsole.read()).thenReturn("lol")
				.thenReturn("five")
				.thenReturn("-1");
		
		library.run();
		
		verify(mockConsole, times(2)).print("This is not a valid selection. Please input a number");
	}

	@Test
    public void shouldPrintErrorMessageWhenInvalidNumberIsInput() throws IOException {
    	when(mockConsole.read()).thenReturn("15")
				.thenReturn("-1");
    	
    	library.run();
    	
    	verify(mockConsole).print("Invalid option selected.  Please select a valid option.");
    }
}
