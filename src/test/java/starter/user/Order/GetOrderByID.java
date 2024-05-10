package starter.user.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class GetOrderByID {

    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint to get my order depends on id")
    public String setApiMyOrderById(){
        return url + "orders/13739";
    }

    @Step("I send request to get my order depends on id ")
    public void sendRequestMyOrderById(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setApiMyOrderById());
    }

    @Step("I receive my order depends on id")
    public void receiveValidOrderById(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ORDER_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));

        restAssuredThat(response -> response.body("'data'.'User'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'.'Fullname'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'.'Password'", notNullValue()));

        restAssuredThat(response -> response.body("'data'.'Product'", nullValue()));
        restAssuredThat(response -> response.body("'data'.'Quantity'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

}