package starter.user.ProductCategories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreateNewCategory {
    private static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set API endpoint for create new product category")
    public String setApiNewCategory() {
        return url + "categories";
    }

    @Step("I send request to fill product category with valid credentials")
    public void sendCreateCategoryRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "gaming");
        requestBody.put("description", "for gaming purposes");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiNewCategory());
    }

    @Step("I receive valid data for create new product category")
    public void receiveValidDataForCreateNewCategory() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_CATEGORY_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}