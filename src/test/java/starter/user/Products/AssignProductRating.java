package starter.user.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class AssignProductRating {
    private static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set API endpoint for assign a product rating")
    public String setApiRating() {
        return url + "products/88700/ratings";
    }

    @Step("I send request to fill product rating")
    public void sendAssignProductRating() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 4);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiRating());
    }

    @Step("I receive valid data for assign a product rating")
    public void receiveValidDataForAssignRating() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ASSIGN_RATING_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Price'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Ratings'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Categories'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}