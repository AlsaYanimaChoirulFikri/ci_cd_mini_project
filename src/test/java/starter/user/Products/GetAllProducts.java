package starter.user.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;


public class GetAllProducts {

    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint to get all products")
    public String setApiEndGetAllProduct(){
        return url + "products";
    }

    @Step("I send request to get user products")
    public void sendRequestProduct(){
        SerenityRest.given().get(setApiEndGetAllProduct());
    }

    @Step("I receive all products details")
    public void receiveValidProfile(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Price'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Ratings'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Categories'",notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }


}