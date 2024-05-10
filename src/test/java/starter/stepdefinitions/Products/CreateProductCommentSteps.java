package starter.stepdefinitions.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Products.CreateProductComment;

public class CreateProductCommentSteps {

    @Steps
    CreateProductComment createProductComment;

    @Given("I set API endpoint for create comment for product")
    public void setApiNewUser() {
        createProductComment.setApiNewComment();
    }


    @When("I send request to fill comment for product")
    public void receiveValidDataForCreateNewUser() {
        createProductComment.sendCreateComment();
    }

    @And("I receive valid data for create comment for product")
    public void sendCreateUserRequest() {
        createProductComment.receiveValidDataForCreateNewComment();
    }
}