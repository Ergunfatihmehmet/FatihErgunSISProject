package gmail.fatihmergunqa.pages;

import gmail.fatihmergunqa.testbase.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signupPage;

    public IndexPage() {
        PageFactory.initElements(Base.driver, this);
    }
}
