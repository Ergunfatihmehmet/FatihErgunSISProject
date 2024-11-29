package gmail.fatihmergunqa.testbase;

import gmail.fatihmergunqa.pages.IndexPage;
import gmail.fatihmergunqa.pages.LoginPage;

/**
 * PageInitializer class responsible for initializing page element objects.
 * It extends the Base class to inherit WebDriver setup and teardown functionality.
 */
public class PageInitializer extends Base {
    // Page element instances
    public static IndexPage indexPage;
    public static LoginPage loginPage;

    /**
     * Initializes the page elements by creating new instances of the corresponding page element classes.
     */
    public static void initialize() {
        indexPage = new IndexPage(); // Initialize IndexPage instance
        loginPage = new LoginPage(); // Initialize LoginPage instance
    }
}