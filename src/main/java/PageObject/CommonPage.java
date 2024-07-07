
package PageObject;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(60);

    public CommonPage() {
        this.driver = Driver.getWebDriver();
        if (this.driver == null) {
            throw new IllegalStateException("WebDriver instance is not initialized.");
        }
        this.wait = new WebDriverWait(this.driver, PAGE_LOAD_TIMEOUT);
    }
}
