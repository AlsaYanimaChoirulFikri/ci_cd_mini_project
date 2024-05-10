package starter.stepdefinitions.ProductCategories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.ProductCategories.CreateNewCategory;
import starter.user.Products.CreateNewProduct;

public class CreateNewCategorySteps {

    @Steps
    CreateNewCategory createNewCategory;

    @Given("I set API endpoint for create new product category")
    public void setApiNewProductCategory() {
        createNewCategory.setApiNewCategory();
    }


    @When("I send request to fill product category with valid credentials")
    public void sendRequestNewProductCategory() {
        createNewCategory.sendCreateCategoryRequest();
    }

    @And("I receive valid data for create new product category")
    public void receiveValidProductCategory() {
        createNewCategory.receiveValidDataForCreateNewCategory();
    }
}