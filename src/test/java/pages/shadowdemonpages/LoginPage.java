package pages.shadowdemonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utilities.WebDriverWaitUtils;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver, WebDriverWaitUtils waitUtils) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToSauceDemo() {
        driver.get("https://www.saucedemo.com/");
    }

    public void loginUser(String username, String password) {
        waitUtils.waitForElementToBeClickable(loginButton);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        waitUtils.waitForVisibility(errorMessage);
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        waitUtils.waitForVisibility(errorMessage);
        return errorMessage.getText();
    }

    public boolean isLoginPageDisplayed() {
        waitUtils.waitForVisibility(loginButton);
        return loginButton.isDisplayed();
    }
}
