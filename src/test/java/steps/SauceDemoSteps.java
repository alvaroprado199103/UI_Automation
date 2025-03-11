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

public class SauceDemoSteps {
    LoginPage loginPage;
    MainPage mainPage;
    WebDriver driver;
    WebDriverFactory webDriverFactory;

    @Before
    public void initialize() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createDriver();
        loginPage = new LoginPage(driver, webDriverFactory);
        mainPage = new MainPage(driver, webDriverFactory);
    }

    @After
    public void closeNav() {
        webDriverFactory.closeDriver();
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
        Assert.assertTrue(loginPage.getErrorMessageB());
    }

    @When("a blocked user attempts to log in")
    public void loginBlockedAccount() {
        loginPage.loginUser("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessageB());
    }

    @Then("the user should be able to access the inventory page")
    public void userShouldAccessInventory() {
    }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        Assert.assertTrue(loginPage.getErrorMessageB());
    }
}
