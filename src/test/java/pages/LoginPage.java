package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name")
    private WebElement Username;
    @FindBy(how = How.ID, using = "password")
    private WebElement Password;
    @FindBy(how = How.ID, using = "login-button")
    private WebElement LoginBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']")
    private WebElement ErrorMsg;
    Wait<WebDriver> wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to www.saucedemo.com
    public void navigateToSauceDemo() {
        driver.get("https://www.saucedemo.com/");
    }

    // Login User
    public void loginUser(String username, String password) {
        wait.until(d -> LoginBtn.isEnabled());
        Username.sendKeys(username);
        Password.sendKeys(password);
        LoginBtn.click();
    }

    // Get error Message
    public boolean getErrorMessageB() {
        return ErrorMsg.isDisplayed();
    }

}
