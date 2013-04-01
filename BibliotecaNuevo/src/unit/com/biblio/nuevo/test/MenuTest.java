package unit.com.biblio.nuevo.test;

import com.biblio.nuevo.Menu;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class MenuTest {

    private Menu menu;
    private String option;

    @Before
    public void setUp() throws Exception {
        menu = new Menu();
        option = "Show all Books";
        menu.addOption(option);
    }

    @Test
    public void shouldShowAllAvailableMenuOptions() throws Exception {
        assertThat(menu.showOptions(), is(containsString("<0> Show all Books")));
    }

    @Test
    public void shouldBeAbleToSelectAMenuOption(){
        assertThat(menu.selectOption(0), is(option));
    }

    @Test
    public void shouldReturnQuitIfMinusOneIsSelected(){
        assertThat(menu.selectOption(-1), is("quit"));
    }

    @Test
    public void shouldReturnInvalidIfInvalidOptionIsSelected(){
        assertThat(menu.selectOption(1), is("invalid"));
        assertThat(menu.selectOption(-2), is("invalid"));
    }
}
