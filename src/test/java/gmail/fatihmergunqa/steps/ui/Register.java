package gmail.fatihmergunqa.steps.ui;

import gmail.fatihmergunqa.utils.Commons;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register extends Commons {
    @Given("Navigated to Signup Page")
    public void navigateToSignupPage() {
        click(indexPage.signupPage);
    }

    @When("Enter Name")
    public void enterUsername() {
        sendText(loginPage.signupName, "fatih");
    }

    @And("Enter Email")
    public void enterEmail() {
        sendText(loginPage.signupEmail, "fatih@mail.com");
    }

    @And("Click Signup")
    public void clickSignup() {
        click(loginPage.signupButton);
    }

    @Then("Observe Results")
    public void validateSignedUp() {
        System.out.println("Validate Signed up");
    }

}
