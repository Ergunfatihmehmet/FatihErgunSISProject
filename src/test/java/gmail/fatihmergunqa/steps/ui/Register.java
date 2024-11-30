package gmail.fatihmergunqa.steps.ui;

import gmail.fatihmergunqa.utils.Commons;
import gmail.fatihmergunqa.utils.Configs;
import gmail.fatihmergunqa.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Register extends Commons {
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
        Assert.assertTrue(mainPage.mainPageLogo.isDisplayed());
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
