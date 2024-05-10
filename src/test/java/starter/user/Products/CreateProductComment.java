package starter.user.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class CreateProductComment {

    private static String url = "https://altashop-api.fly.dev/api/";

    @Step(" I set API endpoint for create comment for product")
    public String setApiNewComment() {
        return url + "products/2/comments";
    }

    @Step("I send request to fill comment for product")
    public void sendCreateComment() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiNewComment());
    }

    @Step("I receive valid data for create comment for product")
    public void receiveValidDataForCreateNewComment() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_COMMENT_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Content'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'", nullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'", nullValue()));
        restAssuredThat(response -> response.body("'data'.'Comment'", nullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}