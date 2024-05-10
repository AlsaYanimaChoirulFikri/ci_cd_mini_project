package starter.stepdefinitions.Products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Products.GetProductByInvalidID;


public class GetProductByInvalidIDSteps {

    @Steps
    GetProductByInvalidID getProfileInvalidID;

    @Given("I set API endpoint with an invalid ID to get product")
    public void setApiGetEndInvalidIdProfile(){

        getProfileInvalidID.setApiGetEndInvalidIdProduct();
    }

    @When("I send request to get product using invalid ID")
    public void sendGetRequestInvalidIdProfile(){
        getProfileInvalidID.sendGetRequestInvalidId();
    }

}