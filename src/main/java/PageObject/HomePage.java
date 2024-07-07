package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends CommonPage {

    public static final String COOKIE_BUTTON_IN_DIV_XPATH = "//div[@id='onetrust-button-group']//*[text()='%s']";
    public static final String HEADER_NAVIGATION_BAR_XPATH = "//ul[@id='frame-header-nav']//a[text()='%s']";
    public static final String ITEM_CATEGORY_XPATH = "//a[contains(@class, 'font-brand-thin') and text()='%s']";


    public HomePage() {
        super();
    }


    public void clickCookieButtonByText(String buttonText) throws InterruptedException {
        String buttonXpath = String.format(COOKIE_BUTTON_IN_DIV_XPATH, buttonText);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        wait.until(ExpectedConditions.invisibilityOf(button));
    }


    public void hoverHeaderNavLinkByText(String linkText) {
        String linkXpath = String.format(HEADER_NAVIGATION_BAR_XPATH, linkText);
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkXpath)));

        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
    }

    public void clickItemCategoryByText(String linkText) {
        String linkXpath = String.format(ITEM_CATEGORY_XPATH, linkText);
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkXpath)));
        link.click();
    }

}
