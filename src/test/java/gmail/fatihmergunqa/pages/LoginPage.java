package gmail.fatihmergunqa.pages;

import gmail.fatihmergunqa.testbase.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "tUsername")
    public WebElement username;

    @FindBy(id = "tPassword")
    public WebElement password;

    @FindBy(id = "bLogin")
    public WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(Base.driver, this);
    }
}
