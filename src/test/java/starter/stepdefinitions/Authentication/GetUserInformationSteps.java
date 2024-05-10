package starter.stepdefinitions.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Authentication.GetUserInformation;

public class GetUserInformationSteps {
    @Steps
    GetUserInformation getUserInformation;

    @Given("I set API endpoint to get user information")
    public void setApiEndUser(){
        getUserInformation.setApiUserInformation();
    }

    @When("I send request to get user information")
    public void sendUserRequest(){
        getUserInformation.sendRequestUserInformation();
    }

    @And("I receive all of user information")
    public void receiveValidProfile(){
        getUserInformation.receiveValidInfo();
    }
}