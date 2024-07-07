package StepDefs;

import PageObject.ProductListPage;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class ProductListPageStepDefs {

    private final ProductListPage productListPage;

    public ProductListPageStepDefs() {
        productListPage = new ProductListPage();
    }


    @And("User verifies PLP is displayed")
    public void userVerifiesPLPIsDisplayed() {
        boolean isVisible = productListPage.isCategoryDescriptionVisible();
        Assert.assertTrue(isVisible, "PLP description content is not displayed.");
    }

    @And("User selects a product from PLP Category")
    public void userSelectsAProductFromPLPCategory() throws InterruptedException {
        productListPage.clickFirstProductCard();
    }
}
