package unit.com.biblio.nuevo.test;

import com.biblio.nuevo.LibraryConsole;
import org.junit.Test;
import java.io.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryConsoleTest {

    private LibraryConsole libraryConsole;

    @Test
    public void shouldPrintToOutputStream(){
        PrintStream mockStream = mock(PrintStream.class);
        libraryConsole = new LibraryConsole(null, mockStream);

        libraryConsole.print("Test String");

        verify(mockStream).println("Test String");
    }

    @Test
    public void shouldReadFromInputStream() throws IOException {
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("Test Read");

        libraryConsole = new LibraryConsole(reader, null);

        assertThat(libraryConsole.read(), is(equalTo("Test Read")));
    }
}
