package starter.user.ProductCategories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeleteProductCategory {

    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint for delete product category with valid id")
    public String setApiDeleteCategoryEndpoint() {
        return url + "categories/1";
    }

    @Step("I send request to delete category with valid ID")
    public void sendDeleteCategoryRequest() {
        SerenityRest.given().delete(setApiDeleteCategoryEndpoint());
    }
}
