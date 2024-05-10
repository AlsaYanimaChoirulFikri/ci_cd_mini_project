package starter.stepdefinitions.ProductCategories;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.ProductCategories.GetCategoryByInvalidID;
import starter.user.Products.GetProductByInvalidID;


public class GetCategoryByInvalidIDSteps {

    @Steps
    GetCategoryByInvalidID getProductCategoryByInvalidID;

    @Given("I set API endpoint with an invalid ID to get product category")
    public void setApiGetEndInvalidIdProfile(){
        getProductCategoryByInvalidID.setApiGetEndInvalidIdCategory();
    }

    @When("I send request to get product category using invalid ID")
    public void sendGetRequestInvalidIdProfile(){
        getProductCategoryByInvalidID.sendGetRequestCategoryInvalidId();
    }

}