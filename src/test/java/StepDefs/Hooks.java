
package StepDefs;

import Utils.Config;
import Utils.Driver;
import io.cucumber.java.*;

public class Hooks {
    private Driver driver;

    public Hooks() {
    }

    @After
    public void tearDown(Scenario scenario) {
        if (Driver.getWebDriver() != null) {
            Driver.getWebDriver().manage().deleteAllCookies();
            driver.closeWebDriver();
        }
    }

    @BeforeAll
    public static void startReporting() {
        Config.setConfig();
    }

    @Before
    public void setUp() {
        driver = new Driver();
        driver.createWebDriver();
    }

    @AfterAll
    public static void endReport() {
        if (Driver.getWebDriver() != null) {
            new Driver().closeWebDriver();
        }
    }
}
