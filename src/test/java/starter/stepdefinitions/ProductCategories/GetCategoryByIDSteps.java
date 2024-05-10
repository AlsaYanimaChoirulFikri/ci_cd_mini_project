package starter.stepdefinitions.ProductCategories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.ProductCategories.GetCategoryByID;
import starter.user.Products.GetProductByID;


public class GetCategoryByIDSteps {

    @Steps
    GetCategoryByID getProductCategoryByID;

    @Given("I set API endpoint with an valid ID to get product category by ID")
    public void setApiGetEndInvalidIdProfile(){
        getProductCategoryByID.setApiGetEndValidIdCategory();
    }

    @When("I send request to get product category using valid ID")
    public void sendGetRequestInvalidIdProfile(){
        getProductCategoryByID.sendGetRequestValidIdCategory();
    }

    @And("I receive a product category")
    public void receiveAProductCategory(){
        getProductCategoryByID.receiveProductCategory();
    }



}