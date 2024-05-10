package starter.stepdefinitions.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Products.AssignProductRating;

public class AssignProductRatingSteps {

    @Steps
    AssignProductRating assignProductRating;

    @Given("I set API endpoint for assign a product rating")
    public void setApiNewRate() {
        assignProductRating.setApiRating();
    }

    @And("I send request to fill product rating")
    public void sendRating() {
        assignProductRating.sendAssignProductRating();
    }

    @When("I receive valid data for assign a product rating")
    public void receiveRating() {
        assignProductRating.receiveValidDataForAssignRating();
    }
}