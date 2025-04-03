package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverWaitUtils;
import pages.BasePage;

public class LoginPagePST extends BasePage {
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@data-test='login-error']")
    private WebElement errorMessage;

    public LoginPagePST(WebDriver driver, WebDriverWaitUtils waitUtils) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        waitUtils.waitForVisibility(emailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        waitUtils.waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    public String getErrorMessage() {
        waitUtils.waitForVisibility(errorMessage);
        return errorMessage.getText();
    }

    public boolean isLoginPageDisplayed() {
        waitUtils.waitForVisibility(emailInput);
        return emailInput.isDisplayed();
    }
}
