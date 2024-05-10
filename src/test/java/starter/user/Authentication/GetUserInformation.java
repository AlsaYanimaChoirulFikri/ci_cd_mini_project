package starter.user.Authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetUserInformation {

    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint to get user information")
    public String setApiUserInformation(){
        return url + "auth/info";
    }

    @Step("I send request to get user information")
    public void sendRequestUserInformation(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setApiUserInformation());
    }

    @Step("I receive all of user information")
    public void receiveValidInfo(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_USER_INFO_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Fullname'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Email'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Password'",notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}