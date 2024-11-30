package gmail.fatihmergunqa.pages;

import gmail.fatihmergunqa.testbase.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(id = "Header1_imgSchoolLogo")
    public WebElement mainPageLogo;

    @FindBy(xpath = "//span[@class='titleSmall' and contains(text(),'Announcements')]")
    public WebElement announcementsSection;

    public MainPage() {
        PageFactory.initElements(Base.driver, this);
    }
}
