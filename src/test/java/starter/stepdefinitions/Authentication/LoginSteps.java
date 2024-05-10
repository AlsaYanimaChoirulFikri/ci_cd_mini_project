package starter.stepdefinitions.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Authentication.Login;

public class LoginSteps {
    @Steps
    Login login;

    /*
    Login Valid Credentials
     */

    @Given("I set API endpoint to Login")
    public void setApiEndLogin(){
        login.setApiLogin();
    }

    @When("I send request to login and fill valid credential\\(email, password)")
    public void sendLoginRequest() {
        login.sendLoginValid();
    }

    @And("I receive my logged in account data")
    public void receiveValidToken(){
        login.receiveValidLogin();
    }

    /*
    Login Invalid Email
     */
    @When("I send request to login and fill invalid email")
    public void sendLoginInvalidEmail() {
        login.sendLoginInvalidEmail();
    }

    /*
    Login blank Email
     */
    @When("I send request to login and fill blank email")
    public void sendLoginBlankCredential() {
        login.sendLoginBlank();
    }

    /*
    Login Wrong Password
     */
    @When("I send request to login and fill wrong password")
    public void sendLoginWrongPass(){ login.sendLoginWrongPassword();}

}