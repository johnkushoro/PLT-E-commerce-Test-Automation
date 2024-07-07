package StepDefs;

import PageObject.HomePage;
import Utils.Config;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HomePageStepDefs {

    private final HomePage homePage;

    public HomePageStepDefs() {
        homePage = new HomePage();
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() throws Exception {
        String prettyLittleThingUrl = Config.getPropertyWithException("url");
        Driver.getWebDriver().get(prettyLittleThingUrl);
        homePage.clickCookieButtonByText("Accept All");
    }

    @When("User navigates to PLP by selecting a product category")
    public void userNavigatesToPLPBySelectingAProductCategory() {
        homePage.hoverHeaderNavLinkByText("DRESSES");
        homePage.clickItemCategoryByText("Midi Dresses");
    }


}
