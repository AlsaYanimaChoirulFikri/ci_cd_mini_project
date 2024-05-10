package starter.stepdefinitions.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Order.GetOrderByID;

public class GetOrderByIDSteps {
    @Steps
    GetOrderByID getOrderByID;

    @Given("I set API endpoint to get my order depends on id")
    public void setApiMyOrder(){
        getOrderByID.setApiMyOrderById();
    }

    @When("I send request to get my order depends on id")
    public void sendOrderRequest(){
        getOrderByID.sendRequestMyOrderById();
    }

    @And("I receive my order depends on id")
    public void receiveMyOrder(){
        getOrderByID.receiveValidOrderById();
    }
}