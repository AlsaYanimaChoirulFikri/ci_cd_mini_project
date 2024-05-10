package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.user.StatusCode;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class StatusCodeSteps {
    @Steps
    StatusCode statusCode;

    @Then("I receive status code 200")
    public void receiveStatusCode200(){
        statusCode.receiveStatusCode200();
    }

    @Then("I receive status code 201")
    public void receiveStatusCode201(){
        statusCode.receiveStatusCode201();
    }

    @Then("I receive error message and \"404 Not Found\" response")
    public void receiveStatusCode404(){
        statusCode.receiveStatusCode404();
    }

    @Then("I receive status code 400")
    public void receiveStatusCode400(){
        statusCode.receiveStatusCode400();
    }


}