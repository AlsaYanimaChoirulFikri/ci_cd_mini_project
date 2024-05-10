package starter.stepdefinitions.ProductCategories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.ProductCategories.GetAllCategories;
import starter.user.StatusCode;
import starter.user.Products.GetAllProducts;

public class GetAllCategoriesSteps {
    @Steps
    GetAllCategories getAllProductCategory;

    @Steps
    StatusCode statusCode;

    @Given("I set API endpoint to get all product categories")
    public void setApiEndProfile(){
        getAllProductCategory.setApiEndGetAllProductCategory();
    }

    @When("I send request to get all product categories")
    public void sendUserRequest(){
        getAllProductCategory.sendRequestProductCategory();
    }

    @And("I receive all of product categories")
    public void receiveValidProfile(){
        getAllProductCategory.receiveValidProductCategory();
    }
}