package gmail.fatihmergunqa.steps.ui;

import gmail.fatihmergunqa.utils.Commons;
import gmail.fatihmergunqa.utils.Configs;
import gmail.fatihmergunqa.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginFunctionality extends Commons {
    @Given("Login Page is present")
    public void loginPageIsPresent() {
        Assert.assertTrue(loginPage.loginPageLogo.isDisplayed());
        Assert.assertTrue(loginPage.username.isDisplayed());
        Assert.assertTrue(loginPage.password.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @When("I enter username and password")
    public void iEnterUsernameAndPassword() {
        Configs.readProperties(Constants.CONFIGURATION_FILEPATH);
        sendText(loginPage.username, Configs.getProperty("username"));
        sendText(loginPage.password, Configs.getProperty("password"));
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        click(loginPage.loginButton);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        Assert.assertTrue("Logo is not displayed!", mainPage.mainPageLogo.isDisplayed());
        Assert.assertTrue("Announcement section is not visible!", mainPage.announcementsSection.isDisplayed());
        Assert.assertTrue("URL does not end with 'MainPage.aspx'", driver.getCurrentUrl().endsWith("MainPage.aspx"));
    }

    @When("I enter invalid {string} and {string}")
    public void iEnterInvalidAnd(String username, String password) {
        sendText(loginPage.username, username);
        sendText(loginPage.password, password);
    }

    @Then("I shouldn't be able to login")
    public void iShouldnTBeAbleToLogin() {
        acceptAlert();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
