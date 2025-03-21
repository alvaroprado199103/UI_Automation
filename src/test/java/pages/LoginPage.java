package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.WebDriverWaitUtils;

public class LoginPage extends BasePage {

    private WebDriverWaitUtils webDriverWaitUtils;

    @FindBy(how = How.ID, using = "user-name")
    private WebElement Username;
    @FindBy(how = How.ID, using = "password")
    private WebElement Password;
    @FindBy(how = How.ID, using = "login-button")
    private WebElement LoginBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']")
    private WebElement ErrorMsg;

    public LoginPage(WebDriver driver, WebDriverWaitUtils webDriverWaitUtils) {
        super(driver);
        this.webDriverWaitUtils = webDriverWaitUtils;
    }

    // Navigate to www.saucedemo.com
    public void navigateToSauceDemo() {
        driver.get("https://www.saucedemo.com/");
    }

    // Login User
    public void loginUser(String username, String password) {
        webDriverWaitUtils.waitForClickability(LoginBtn);
        Username.sendKeys(username);
        Password.sendKeys(password);
        LoginBtn.click();
    }

    // Get error Message
    public boolean isErrorMessageDisplayed() {
        return ErrorMsg.isDisplayed();
    }
}
