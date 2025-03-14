package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.WebDriverWaitUtils;

public class MainPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name")
    private WebElement Username;
    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    private WebElement MenuBtn;
    @FindBy(how = How.ID, using = "logout_sidebar_link")
    private WebElement LogoutBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']")
    private WebElement ErrorMsg;
    @FindBy(how = How.XPATH, using = "//div[@class='app_logo' and text()='Swag Labs']")
    private WebElement MainMenuTitle;

    private WebDriverWaitUtils webDriverWaitUtils;

    public MainPage(WebDriver driver, WebDriverWaitUtils webDriverWaitUtils) {
        super(driver);
        this.webDriverWaitUtils = webDriverWaitUtils;
    }

    // Logout User
    public void logoutUser() {
        webDriverWaitUtils.waitForClickability(MenuBtn);
        MenuBtn.click();
        webDriverWaitUtils.waitForClickability(LogoutBtn);
        LogoutBtn.click();
    }

    // Error Msg Validation
    public boolean ErrorMsg() {
        webDriverWaitUtils.waitForVisibility(ErrorMsg);
        return ErrorMsg.isDisplayed();
    }

    // Main menu Dashboard validation
    public void MainMenuValidation() {
        webDriverWaitUtils.waitForVisibility(MainMenuTitle);
    }
}
