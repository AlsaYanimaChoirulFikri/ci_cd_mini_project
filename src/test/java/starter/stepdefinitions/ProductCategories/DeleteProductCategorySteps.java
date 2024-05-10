package starter.stepdefinitions.ProductCategories;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.ProductCategories.DeleteProductCategory;

public class DeleteProductCategorySteps {
    @Steps
    DeleteProductCategory deleteProductCategoryByID;

    @Given("I set API endpoint for delete product category with valid id")
    public void setDeleteValidCategorySteps(){
        deleteProductCategoryByID.setApiDeleteCategoryEndpoint();
    }

    @When("I send request to delete product category with valid ID")
    public void sendDeleteProductCategoryRequest(){
        deleteProductCategoryByID.sendDeleteCategoryRequest();
    }

}