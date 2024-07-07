
package StepDefs;

import PageObject.ProductDetailPage;
import io.cucumber.java.en.And;

public class ProductDetailPageStepDefs {

    private final ProductDetailPage productDetailPage;

    public ProductDetailPageStepDefs() {
        productDetailPage = new ProductDetailPage();
    }

    @And("the user selects product options and adds it to the bag")
    public void theUserSelectsProductOptionsAndAddsItToTheBag() throws InterruptedException {
        productDetailPage.selectRandomProductColorAndSize();
    }

    @And("User clicks on the bag icon")
    public void userClicksOnTheBagIcon() throws InterruptedException {
        productDetailPage.clickBagIcon();
    }
}
