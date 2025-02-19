package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name")
    private WebElement UsernameField;
    @FindBy(how = How.ID, using = "password")
    private WebElement Password;
    @FindBy(how = How.ID, using = "login-button")
    private WebElement LoginBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']")
    private WebElement ErrorMsg;

    public LoginPage() {
        super(driver);
    }

    // Navigate to www.saucedemo.com
    public void navigateToSauceDemo() {
        navigateTo("https://www.saucedemo.com/");
    }

    // Login User
    public void loginUser(String username, String password, Boolean ErrorMessage) {
        UsernameField.sendKeys(username);
        Password.sendKeys(password);
        LoginBtn.click();
        if (ErrorMessage) {
            ErrorMsg.isDisplayed();
        }
    }

}
