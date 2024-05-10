package starter.user.ProductCategories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetCategoryByID {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint with an valid ID to get product by ID")
    public String setApiGetEndValidIdCategory(){
        return url + "categories/31972";
    }

    @Step("I send request to get product using valid ID")
    public void sendGetRequestValidIdCategory(){
        SerenityRest.given().get(setApiGetEndValidIdCategory());
    }

    @Step("I receive a product category")
    public void receiveProductCategory(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_CATEGORY_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'",notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}