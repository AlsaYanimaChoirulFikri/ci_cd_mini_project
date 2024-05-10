package starter.stepdefinitions.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Order.CreateNewOrder;

public class CreateNewOrderSteps {
    @Steps
    CreateNewOrder createNewOrder;

    @Given("I set API endpoint for create new order")
    public void setApiOrder(){
        createNewOrder.setApiNewOrder();
    }

    @When("I send request to fill new order with valid credentials\\(product id, quantity)")
    public void sendRequestOrder(){
        createNewOrder.sendCreateCategoryRequest();
    }

    @And("I receive valid data for my order")
    public void receiveOrderData(){
        createNewOrder.receiveValidDataForCreateNewCategory();
    }

}