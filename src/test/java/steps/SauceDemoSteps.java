package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import pages.*;

public class SauceDemoSteps {

    LoginPage loginPage;
    MainPage mainPage;
    WebDriver driver;

    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @After
    public void closeNav() {
        driver.quit();
    }

    @Given("I navigate to www.saucedemo.com")
    public void iNavigateToSauceDemo() {
        loginPage.navigateToSauceDemo();
    }

    @When("Login using a correct password")
    public void LoginSuccesfully() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("standard_user", "secret_sauce");
        mainPage.logoutUser();
    }

    @Then("Login using incorrect password")
    public void LoginFailed() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("standard_user", "ecret_sauce");
        // Assert.assertTrue(loginPage.getErrorMessageB());
    }

    @Then("Login using a blocked account")
    public void LogingBlockedAccount() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("locked_out_user", "secret_sauce");
        // Assert.assertTrue(loginPage.getErrorMessageB());
    }

}
