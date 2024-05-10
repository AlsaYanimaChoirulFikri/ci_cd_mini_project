package starter.stepdefinitions.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Products.GetAllProducts;
import starter.user.StatusCode;

public class GetAllProductsSteps {
    @Steps
    GetAllProducts getAllProduct;

    @Steps
    StatusCode statusCode;

    @Given("I set API endpoint to get all products")
    public void setApiEndProfile(){
        getAllProduct.setApiEndGetAllProduct();
    }

    @When("I send request to get all products")
    public void sendUserRequest(){
        getAllProduct.sendRequestProduct();
    }

    @And("I receive all products details")
    public void receiveValidProfile(){
        getAllProduct.receiveValidProfile();
    }
}