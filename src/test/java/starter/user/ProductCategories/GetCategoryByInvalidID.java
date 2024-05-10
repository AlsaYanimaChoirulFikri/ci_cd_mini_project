package starter.user.ProductCategories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetCategoryByInvalidID {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint with an invalid ID to get product category")
    public String setApiGetEndInvalidIdCategory(){
        return url + "categories/1";
    }

    @Step("I send request to get product category using invalid ID")
    public void sendGetRequestCategoryInvalidId(){
        SerenityRest.given().get(setApiGetEndInvalidIdCategory());
    }
}