package starter.stepdefinitions.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Products.GetProductByID;


public class GetProductByIDSteps {

    @Steps
    GetProductByID getProductByID;

    @Given("I set API endpoint to get product by ID")
    public void setApiGetEndInvalidIdProduct(){

        getProductByID.setApiGetEndValidIdProduct();
    }

    @When("I send request to get product using valid ID")
    public void sendGetRequestInvalidIdProduct(){
        getProductByID.sendGetRequestValidIdProduct();
    }

    @And("I receive a product details")
    public void getAProduct(){
        getProductByID.receiveProductDetail();
    }

}