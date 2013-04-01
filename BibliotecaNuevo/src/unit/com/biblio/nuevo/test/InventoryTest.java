package unit.com.biblio.nuevo.test;

import com.biblio.nuevo.Book;
import com.biblio.nuevo.Inventory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() throws Exception {
        inventory = new Inventory();
    }

    @Test
    public void shouldAddBookToCollection(){
        Book book1 = new Book(null);

        assertThat(inventory.getNumberOfBooks(), is(equalTo(0)));
        inventory.add(book1);
        assertThat(inventory.getNumberOfBooks(), is(equalTo(1)));
    }

    @Test
    public void shouldReturnListOfAllBooks(){
        Book book2 = new Book("Effective Java");
        Book book1 = new Book("War and Peace");
        inventory.add(book1);
        inventory.add(book2);

        String list = inventory.getBookTitles();

        assertThat(list, containsString("Effective Java\n"));
        assertThat(list, containsString("War and Peace\n"));
    }
    
    @Test
    public void shouldBeAbleToReserveABook() {
        Book book2 = new Book("Effective Java");
        Book book1 = new Book("War and Peace");
        inventory.add(book1);
        inventory.add(book2);
        
        assertThat(inventory.getReservedBookTitles().length(), is(equalTo(0)));
        inventory.reserve(book2.getTitle());
        
        assertThat(inventory.getReservedBookTitles(), containsString(book2.getTitle()));
    }
}
