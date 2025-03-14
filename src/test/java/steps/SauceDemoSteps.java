package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.MainPage;
import utilities.WebDriverFactory;
import utilities.WebDriverWaitUtils;

public class SauceDemoSteps {
    LoginPage loginPage;
    MainPage mainPage;
    WebDriver driver;
    WebDriverFactory webDriverFactory;
    WebDriverWaitUtils webDriverWaitUtils;

    @Before
    public void initialize() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createDriver();
        webDriverWaitUtils = new WebDriverWaitUtils(driver);
        loginPage = new LoginPage(driver, webDriverWaitUtils);
        mainPage = new MainPage(driver, webDriverWaitUtils);
    }

    @After
    public void closeNav() {
        webDriverWaitUtils.closeDriver();
    }

    @Given("I navigate to www.saucedemo.com")
    public void iNavigateToSauceDemo() {
        loginPage.navigateToSauceDemo();
    }

    @When("standard user logs in with valid credentials")
    public void loginSuccessfully() {
        loginPage.loginUser("standard_user", "secret_sauce");
    }

    @When("the user logs out")
    public void userLogsOut() {
        mainPage.logoutUser();
    }

    @When("standard user logs in with invalid credentials")
    public void loginFailed() {
        loginPage.loginUser("standard_user", "ecret_sauce");
    }

    @When("a blocked user attempts to log in")
    public void loginBlockedAccount() {
        loginPage.loginUser("locked_out_user", "secret_sauce");
    }

    @Then("the user should be able to access the inventory page")
    public void userShouldAccessInventory() {
        mainPage.MainMenuValidation();
    }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        Assert.assertTrue(loginPage.getErrorMessageB());
    }
}
