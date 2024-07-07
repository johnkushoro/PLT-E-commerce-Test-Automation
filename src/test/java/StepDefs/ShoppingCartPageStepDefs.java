package StepDefs;

import PageObject.ShoppingCartPage;
import PageObject.ProductDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ShoppingCartPageStepDefs {


    private final ShoppingCartPage shoppingCartPage;
    private final ProductDetailPage productDetailPage;

    public ShoppingCartPageStepDefs() {
        shoppingCartPage = new ShoppingCartPage();
        productDetailPage = new ProductDetailPage();
    }

    @Then("Product in the bag should match the selected product")
    public void productInTheBagShouldMatchTheSelectedProduct() {

        shoppingCartPage.storeProductDetailsInBag();
        var productDetailsPageModel = productDetailPage.getProductDetails();
        var shoppingCartPageModel = shoppingCartPage.getProductDetails();

        Assert.assertEquals(productDetailsPageModel.getProductName(), shoppingCartPageModel.getProductName(), "Product names do not match!");
        Assert.assertEquals(productDetailsPageModel.getProductSize(), shoppingCartPageModel.getProductSize(), "Product sizes do not match!");
        Assert.assertEquals(productDetailsPageModel.getProductColour(), shoppingCartPageModel.getProductColour(), "Product colours do not match!");
    }


    @And("the cart subtotal is stored")
    public void theCartSubtotalIsStored() {
        shoppingCartPage.storeProductDetailsInBag();
        String storedProductSubtotalInBag = shoppingCartPage.getProductDetails().getProductSubtotal();
        Assert.assertNotNull(storedProductSubtotalInBag, "The cart subtotal was not stored");
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        shoppingCartPage.clickProceedToCheckOutButton();
    }
}