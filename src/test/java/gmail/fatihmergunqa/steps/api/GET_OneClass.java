package gmail.fatihmergunqa.steps.api;

import gmail.fatihmergunqa.utils.API;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class GET_OneClass extends API {
    RequestSpecification request;
    Response response;

    @Given("I created a request")
    public void iCreatedARequest() {
        RestAssured.baseURI = API.BASE_URI;
        request = RestAssured.given();
    }

    @And("I provided the ClassID {int} as the path parameter")
    public void iProvidedTheClassIDAsThePathParameter(int classID) {
        request.pathParam("Id", classID);

    }

    @When("I make a GET request to the GetOneClass endpoint")
    public void iMakeAGETRequestToTheGetOneClassEndpoint() {
        response = request.when().get(API.GET_ONE_CLASS);
        response.prettyPeek();
    }

    @Then("I validate that the status code is {int}")
    public void iValidateThatTheStatusCodeIs(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @And("I validate that the Id is {int}")
    public void iValidateThatTheIdIs(int classID) {
        response.then().assertThat().body("result.id", Matchers.is(classID));

    }

    @And("I validate that the class term is {string}")
    public void iValidateThatTheClassTermIs(String term) {
        response.then().assertThat().body("result.term", Matchers.is(term));
    }
}
