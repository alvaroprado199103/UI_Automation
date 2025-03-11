package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.WebDriverFactory;

public class MainPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name")
    private WebElement Username;
    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    private WebElement MenuBtn;
    @FindBy(how = How.ID, using = "logout_sidebar_link")
    private WebElement LogoutBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']")
    private WebElement ErrorMsg;

    private WebDriverFactory webDriverFactory;

    public MainPage(WebDriver driver, WebDriverFactory webDriverFactory) {
        super(driver);
        this.webDriverFactory = webDriverFactory;
    }

    // Logout User
    public void logoutUser() {
        webDriverFactory.waitForClickability(MenuBtn);
        MenuBtn.click();
        webDriverFactory.waitForClickability(LogoutBtn);
        LogoutBtn.click();
    }

    // Error Msg Validation
    public boolean ErrorMsg() {
        webDriverFactory.waitForVisibility(ErrorMsg);
        return ErrorMsg.isDisplayed();
    }
}
