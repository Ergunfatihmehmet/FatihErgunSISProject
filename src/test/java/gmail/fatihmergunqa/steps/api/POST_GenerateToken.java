package gmail.fatihmergunqa.steps.api;

import gmail.fatihmergunqa.utils.API;
import gmail.fatihmergunqa.utils.Configs;
import gmail.fatihmergunqa.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class POST_GenerateToken extends API {
    RequestSpecification request;
    Response response;

    @Given("I created post a request")
    public void iCreatedPostARequest() {
        RestAssured.baseURI = API.BASE_URI;
        request = RestAssured.given();
    }

    @And("I provided the body information")
    public void iProvidedTheBodyInformation() {
        Configs.readProperties(Constants.CONFIGURATION_FILEPATH);
        String username = Configs.getProperty("api_username");
        String password = Configs.getProperty("api_password");

        String payload = "{\n" +
                "    \"userNameOrEmailAddress\": \"" + username + "\",\n" +
                "    \"password\": \"" + password + "\",\n" +
                "    \"rememberClient\": true\n" +
                "}";

        request.body(payload);
    }

    @And("I provided the header information")
    public void iProvidedTheHeaderInformation() {
        request.header("content-type", "application/json");
    }


    @When("I make a POST Request to GenerateToken endpoint")
    public void iMakeAPOSTRequestToGenerateTokenEndpoint() {
        response = request.when().post(API.GENERATE_TOKEN).prettyPeek();
    }

    @And("I validate that the body contains {string}")
    public void iValidateThatTheBodyContains(String accessToken) {
        response.then().assertThat().body(Matchers.containsString(accessToken));

    }

    @And("I validate that the success is true")
    public void iValidateThatTheSuccessIsTrue() {
        response.then().assertThat().body("success", Matchers.is(true));
    }

    @Then("I update token")
    public void iUpdateToken() {
        Configs.setProperty(
                Constants.CONFIGURATION_FILEPATH,
                "api_token",
                response.then().extract().path("result.accessToken"));
    }
}
