package starter.stepdefinitions.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Authentication.Register;

public class RegisterSteps {

    @Steps
    Register register;

    /*
    Register Valid Credentials
     */

    @Given("I set API endpoint to register")
    public void setApiEndUser(){
        register.setApiRegister();
    }

    @When("I send request to register and fill valid credential\\(email, password, fullname)")
    public void sendRegisterRequest() {
        register.sendRegisterValid();
    }

    @And("I receive my registered account data")
    public void receiveValidProfile(){
        register.receiveValidRegistered();
    }

    /*
    Register Invalid Email
     */
    @When("I send request to register and fill invalid email \\(password and fullname stay valid)")
    public void sendRegisterInvalidEmail() {
        register.sendRegisterInvalidEmail();
    }
    /*
    Register Blank Credential
     */
    @When("I send request to register and fill blank one credential")
    public void sendRegisterBlankCredential() {
        register.sendRegisterBlank();
    }

}