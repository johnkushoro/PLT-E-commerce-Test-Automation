
package StepDefs;

import PageObject.ShoppingCartPage;
import PageObject.CheckOutPage;
import Model.ProductDetails;
import Utils.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckOutPageStepDefs {

    private final CheckOutPage checkOutPage;
    private final ShoppingCartPage shoppingCartPage;


    public CheckOutPageStepDefs() {
        checkOutPage = new CheckOutPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @And("User enters email address and selects continue")
    public void userEntersUsernameAndSelectsContinue() throws Exception {
        String emailAddress = Config.getPropertyWithException("emailAddress");
        checkOutPage.enterEmailAddress(emailAddress);
        checkOutPage.clickContinueButton();
    }

    @And("User enters password and selects continue")
    public void userEntersPasswordAndSelectsContinue() throws Exception {
        String password = Config.getPropertyWithException("passWord");
        checkOutPage.enterPassword(password);
        checkOutPage.clickContinueButton();
    }

    @Then("The product name, size, and subtotal should match in the bag section on the checkout page")
    public void theProductNameSizeAndSubtotalShouldMatchInTheBagSectionOnTheCheckoutPage() {

        ProductDetails shoppingCartProductDetails = shoppingCartPage.getProductDetails();

        checkOutPage.storeProductDetailsOnCheckout();
        ProductDetails checkoutPageProductDetails = checkOutPage.getProductDetails();

        Assert.assertEquals(shoppingCartProductDetails.getProductName(), checkoutPageProductDetails.getProductName(), "Product names do not match!");
        Assert.assertEquals(shoppingCartProductDetails.getProductSize(), checkoutPageProductDetails.getProductSize(), "Product sizes do not match!");
        Assert.assertEquals(shoppingCartProductDetails.getProductColour(), checkoutPageProductDetails.getProductColour(), "Product colours do not match!");
        Assert.assertEquals(shoppingCartProductDetails.getProductSubtotal(), checkoutPageProductDetails.getProductSubtotal(), "Product subtotals do not match!");


    }

    @And("The bag section should display the delivery total and grand total")
    public void theBagSectionShouldDisplayTheDeliveryTotalAndGrandTotal() {
        Assert.assertNotEquals("Delivery total not displayed", checkOutPage.checkAndGetDeliveryTotalText());
        Assert.assertNotEquals("Grand total not displayed", checkOutPage.checkAndGetGrandTotalText());
    }

    @When("User scrolls to the payment method")
    public void userScrollsToThePaymentMethod() {
        String paymentInfoText = checkOutPage.checkAndGetPaymentInformationText("Payment Information");
        Assert.assertEquals(paymentInfoText, "Payment Information", "Payment Information text does not match or is not displayed");
    }


    @Then("User selects and verifies a payment method")
    public void userSelectsAndVerifiesAPaymentMethod() {
        checkOutPage.clickAndVerifyButtonByLabelText("PayPal");
    }
}



