package starter.user.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProduct {

    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint to delete product with valid ID")
    public String setApiDeleteProductEndpoint() {
        return url + "products/1";
    }

    @Step("I send request to delete product with valid ID")
    public void sendDeleteProductRequest() {
        SerenityRest.given().delete(setApiDeleteProductEndpoint());
    }


}