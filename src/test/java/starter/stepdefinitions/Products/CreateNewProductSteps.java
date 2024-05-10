package starter.stepdefinitions.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Products.CreateNewProduct;

public class CreateNewProductSteps {

    @Steps
    CreateNewProduct createNewProduct;

    @Given("I set API endpoint to create a new product")
    public void setApiNewUser() {
        createNewProduct.setApiNewProduct();
    }


    @And("I send request to fill product data with valid credentials")
    public void receiveValidDataForCreateNewUser() {
        createNewProduct.sendCreateProductRequest();
    }

    @When("I receive valid data to create a new product")
    public void sendCreateUserRequest() {
        createNewProduct.receiveValidDataForCreateNewProduct();
    }
}