package starter.user.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetProductRatings {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint with an valid ID to get product ratings by ID")
    public String setApiGetEndRatings(){
        return url + "products/1/ratings";
    }

    @Step("I send request to get product ratings using valid ID")
    public void sendGetRequestRatingInvalidId(){
        SerenityRest.given().get(setApiGetEndRatings());
    }

    @Step("I receive all of product ratings using valid ID")
    public void receiveValidRatings(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_RATINGS_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}