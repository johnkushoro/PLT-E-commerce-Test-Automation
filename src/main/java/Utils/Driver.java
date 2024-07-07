
package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void createWebDriver() {
        WebDriverManager.chromedriver().browserVersion("126.0.6478.127").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver.set(new ChromeDriver(options));
        getWebDriver().manage().window().maximize();
    }

    public void closeWebDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
            driver.remove();
        }
    }

    public static WebDriver getWebDriver() {
        return driver.get();
    }
}
