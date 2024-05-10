package starter.user.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreateNewOrder {

    private static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set API endpoint for create new order")
    public String setApiNewOrder() {
        return url + "orders";
    }

    @Step("I send request to fill new order with valid credentials(product id, quantity)")
    public void sendCreateCategoryRequest() {
        JSONObject requestBody = new JSONObject();
        JSONArray orderRequestBody = new JSONArray();

        requestBody.put("product_id", 88783);
        requestBody.put("quantity", 3);
        orderRequestBody.put(0, requestBody);

        System.out.println(orderRequestBody);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(orderRequestBody.toString())
                .post(setApiNewOrder());
    }

    @Step("I receive valid data for my order")
    public void receiveValidDataForCreateNewCategory() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_ORDER_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'.'Fullname'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'.'Password'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'.'Description'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'.'Price'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'.'Ratings'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'.'Categories'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Quantity'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}