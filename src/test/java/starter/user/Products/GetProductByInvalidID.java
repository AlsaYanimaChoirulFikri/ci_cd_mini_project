package starter.user.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetProductByInvalidID {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint with an invalid ID to get product")
    public String setApiGetEndInvalidIdProduct(){
        return url + "products/999";
    }

    @Step("I send request to get product using invalid ID")
    public void sendGetRequestInvalidId(){
        SerenityRest.given().get(setApiGetEndInvalidIdProduct());
    }
}