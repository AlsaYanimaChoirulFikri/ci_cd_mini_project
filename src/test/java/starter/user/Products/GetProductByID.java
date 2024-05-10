package starter.user.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetProductByID {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint with an valid ID to get product by ID")
    public String setApiGetEndValidIdProduct(){
        return url + "products/88700";
    }

    @Step("I send request to get product using valid ID")
    public void sendGetRequestValidIdProduct(){
        SerenityRest.given().get(setApiGetEndValidIdProduct());
    }

    @Step("I receive a product details")
    public void receiveProductDetail(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'ID'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Price'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Ratings'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Categories'",notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}