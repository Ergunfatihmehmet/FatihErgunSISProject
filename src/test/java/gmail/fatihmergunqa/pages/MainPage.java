package gmail.fatihmergunqa.pages;

import gmail.fatihmergunqa.testbase.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(id = "Header1_imgSchoolLogo")
    public WebElement mainPageLogo;

    public MainPage() {
        PageFactory.initElements(Base.driver, this);
    }
}
