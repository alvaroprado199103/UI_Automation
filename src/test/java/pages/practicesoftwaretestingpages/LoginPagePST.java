package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class LoginPagePST extends BasePage {
    @FindBy(css = "#email")
    private WebElement emailInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "input[value='Login']")
    private WebElement loginButton;

    public LoginPagePST(WebDriver driver) {
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

    public boolean isLoginPageDisplayed() {
        waitUtils.waitForVisibility(emailInput);
        return emailInput.isDisplayed();
    }
}
