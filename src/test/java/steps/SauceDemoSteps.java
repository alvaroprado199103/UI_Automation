package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.shadowdemonpages.LoginPage;
import pages.shadowdemonpages.MainPage;
import io.cucumber.java.en.Then;
import utilities.WebDriverWaitUtils;
import pages.BasePage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SauceDemoSteps {
    private static final Logger LOGGER = Logger.getLogger(SauceDemoSteps.class.getName());
    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;
    private WebDriverWaitUtils webDriverWaitUtils;

    @Before
    public void initialize() {
        LOGGER.log(Level.INFO, "Initializing SauceDemo test environment...");
        try {
            driver = BasePage.initializeDriver(true);
            webDriverWaitUtils = new WebDriverWaitUtils(driver);
            loginPage = new LoginPage(driver, webDriverWaitUtils);
            mainPage = new MainPage(driver, webDriverWaitUtils);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error setting up SauceDemo test environment: " + e.getMessage(), e);
            throw e;
        }
    }

    @After
    public void closeNav() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I navigate to www.saucedemo.com")
    public void iNavigateToSauceDemo() {
        loginPage.navigateToSauceDemo();
    }

    @When("standard user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPage.loginUser("standard_user", "secret_sauce");
    }

    @When("the user logs out")
    public void userLogsOut() {
        mainPage.logoutUser();
    }

    @When("standard user logs in with invalid credentials")
    public void userLogsInWithInvalidCredentials() {
        loginPage.loginUser("standard_user", "ecret_sauce");
    }

    @When("a blocked user attempts to log in")
    public void loginBlockedAccount() {
        loginPage.loginUser("locked_out_user", "secret_sauce");
    }

    @Then("the user should be able to access the inventory page")
    public void userShouldAccessInventory() {
        Assert.assertTrue(mainPage.isMainMenuVisible());
    }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }
}
