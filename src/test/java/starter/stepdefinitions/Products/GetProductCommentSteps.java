package starter.stepdefinitions.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Products.GetProductComment;
import starter.user.Products.GetProductRatings;


public class GetProductCommentSteps {

    @Steps
    GetProductComment getProductCommentByValidID;

    @Given("I set API endpoint with an valid ID to get product comment by ID")
    public void setApiGetEndInvalidIdProfile(){
        getProductCommentByValidID.setApiGetEndComment();
    }

    @When("I send request to get product comment using valid ID")
    public void sendGetRequestInvalidIdProfile(){
        getProductCommentByValidID.sendGetRequestCommentInvalidID();
    }

    @And("I receive all of product comment using valid ID")
    public void receiveValidProfile(){
        getProductCommentByValidID.receiveValidComment();
    }

}