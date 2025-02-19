package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.*;

public class SauceDemoSteps {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Given("I navigate to www.saucedemo.com")
    public void iNavigateToSauceDemo() {
        loginPage.navigateToSauceDemo();
    }

    @Then("Login using a correct password")
    public void LoginSuccesfully() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("standard_user", "secret_sauce", false);
        mainPage.logoutUser();
    }

    @When("Login using incorrect password")
    public void LoginFailed() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("standard_user", "ecret_sauce", false);
    }

    @Then("Login using a blocked account")
    public void LogingBlockedAccount() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("locked_out_user", "secret_sauce", true);
    }

}
