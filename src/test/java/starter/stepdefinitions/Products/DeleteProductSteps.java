package starter.stepdefinitions.Products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Products.DeleteProduct;

public class DeleteProductSteps {
    @Steps
    DeleteProduct deleteProductSteps;

    @Given("I set API endpoint to delete product with valid ID")
    public void setDeleteValidUserSteps(){
        deleteProductSteps.setApiDeleteProductEndpoint();
    }

    @When("I send request to delete product with valid ID")
    public void sendDeleteUserRequest(){
        deleteProductSteps.sendDeleteProductRequest();
    }

}