package starter.stepdefinitions.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Order.GetAllOrders;

public class GetAllOrdersSteps {

    @Steps
    GetAllOrders getAllOrders;

    @Given("I set API endpoint to get all my order")
    public void setApiMyOrder(){
        getAllOrders.setApiAllMyOrder();
    }

    @When("I send request to get all my order")
    public void sendOrderRequest(){
        getAllOrders.sendRequestAllMyOrder();
    }

    @And("I receive all of my order")
    public void receiveMyOrder(){
        getAllOrders.receiveValidOrder();
    }
}