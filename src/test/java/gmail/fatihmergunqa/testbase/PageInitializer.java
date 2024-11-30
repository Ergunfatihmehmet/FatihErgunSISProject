package gmail.fatihmergunqa.testbase;

import gmail.fatihmergunqa.pages.LoginPage;
import gmail.fatihmergunqa.pages.MainPage;

/**
 * PageInitializer class responsible for initializing page element objects.
 * It extends the Base class to inherit WebDriver setup and teardown functionality.
 */
public class PageInitializer extends Base {
    // Page element instances
    public static LoginPage loginPage;
    public static MainPage mainPage;

    /**
     * Initializes the page elements by creating new instances of the corresponding page element classes.
     */
    public static void initialize() {
        loginPage = new LoginPage(); // Initialize LoginPage instance
        mainPage = new MainPage();
    }
}