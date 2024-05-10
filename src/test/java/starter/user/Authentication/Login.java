package starter.user.Authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class Login {

    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint to Login")
    public String setApiLogin(){
        return url + "auth/login";
    }

    /*
    Login Valid Credentials
     */
    @Step("I send request to login and fill valid credential(email, password)")
    public void sendLoginValid(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "icana@mail.com");
        requestBody.put("password", "12345678");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiLogin());
    }

    @Step("I receive my logged in account data")
    public void receiveValidLogin(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_SCHEMA);

        restAssuredThat(response -> response.body("data",notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    /*
    Login invalid email
     */
    @Step("I send request to login and fill invalid email")
    public void sendLoginInvalidEmail(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "icanahaha");
        requestBody.put("password", "12345678");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .header("User-Agent", "PostmanRuntime/7.34.0")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .body(requestBody.toString())
                .post(setApiLogin());
    }

    /*
    Login Blank Email
     */
    @Step("I send request to login and fill blank email")
    public void sendLoginBlank(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "");
        requestBody.put("password", "12345678");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .header("User-Agent", "PostmanRuntime/7.34.0")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .body(requestBody.toString())
                .post(setApiLogin());
    }

    /*
    Login Wrong Password
    */
    @Step("I send request to login and fill wrong password")
    public void sendLoginWrongPassword(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "icana@mail.com");
        requestBody.put("password", "salahdulu");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkljYW5hIExhc3RuYW1lIiwiRW1haWwiOiJpY2FuYUBtYWlsLmNvbSJ9.IIp2XJ6Ut0qZpIBKCrIWLE1plQAUWe5a_ke5YloHlzA";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .header("User-Agent", "PostmanRuntime/7.34.0")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .body(requestBody.toString())
                .post(setApiLogin());
    }
}