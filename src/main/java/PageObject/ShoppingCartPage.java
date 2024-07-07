
package PageObject;

import Model.ProductDetails;
import Utils.DataStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends CommonPage {

    public static final String PRODUCT_NAME_IN_BAG_SELECTOR = "div > a.text-new-brand-black";
    private static final String PRODUCT_SIZE_IN_BAG_SELECTOR = ".checkout-table-max-width div:nth-child(4) li:first-child span";
    private static final String PRODUCT_COLOUR_IN_BAG_SELECTOR = ".checkout-table-max-width div:nth-child(4) li:nth-child(2) span";
    private static final String PRODUCT_SUBTOTAL_IN_BAG_SELECTOR = "p.font-brand-thin.text-new-brand-black";
    private static final String PROCEED_TO_CHECKOUT_BUTTON_SELECTOR = "#checkout-button-bottom";


    private final DataStore dataStore;
    private final ProductDetails productDetails;
    public String ProductDetailsModel = "ShoppingCartPage";

    public ShoppingCartPage() {
        super();
        this.dataStore = DataStore.getInstance();
        productDetails = new ProductDetails();
    }

    public ProductDetails getProductDetails() {
        return (ProductDetails) dataStore.getValue(ProductDetailsModel);
    }

    public void storeProductDetailsInBag() {
        storeProductNameInBag();
        storeProductSizeInBag();
        storeProductColourInBag();
        storeProductSubtotalInBag();
        System.out.println(productDetails.toString());
        dataStore.setValue(ProductDetailsModel, productDetails);
    }

    public void storeProductNameInBag() {
        String productNameInBag = ProductNameInBag();
        productDetails.setProductName(productNameInBag);
    }

    public void storeProductSizeInBag() {
        String productSizeInBag = ProductSizeInBag();
        productDetails.setProductSize(productSizeInBag);
    }

    public void storeProductColourInBag() {
        String productColourInBag = ProductColourInBag();
        productDetails.setProductColour(productColourInBag);
    }

    public void storeProductSubtotalInBag() {
        String productSubtotalInBag = ProductSubtotalInBag();
        productDetails.setProductSubtotal(productSubtotalInBag);
    }

    public String ProductNameInBag() {
        WebElement productNameInBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PRODUCT_NAME_IN_BAG_SELECTOR)));
        return productNameInBagElement.getText();
    }

    public String ProductColourInBag() {
        WebElement productColourInBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PRODUCT_COLOUR_IN_BAG_SELECTOR)));
        String fullText = productColourInBagElement.getText();
        String productColourInBag = fullText.replace("Colour: ", "").trim();
        System.out.println("Product colour in bag: " + productColourInBag);
        return productColourInBag;
    }

    public String ProductSizeInBag() {
        WebElement spanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PRODUCT_SIZE_IN_BAG_SELECTOR)));
        String productSizeInBagElement = spanElement.getText();
        return productSizeInBagElement.replaceAll("\\D+", "");
    }

    public String ProductSubtotalInBag() {
        WebElement productSubtotalInBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PRODUCT_SUBTOTAL_IN_BAG_SELECTOR)));
        return productSubtotalInBagElement.getText();
    }

    public void clickProceedToCheckOutButton() {
        WebElement proceedToCheckOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PROCEED_TO_CHECKOUT_BUTTON_SELECTOR)));
        proceedToCheckOutButton.click();
    }
}