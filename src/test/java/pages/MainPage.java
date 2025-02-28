package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name")
    private WebElement Username;
    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    private WebElement MenuBtn;
    @FindBy(how = How.ID, using = "logout_sidebar_link")
    private WebElement LogoutBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']")
    private WebElement ErrorMsg;
    Wait<WebDriver> wait;

    public MainPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Logout User
    public void logoutUser() {
        wait.until(d -> MenuBtn.isDisplayed());
        MenuBtn.click();
        wait.until(d -> LogoutBtn.isDisplayed());
        LogoutBtn.click();
    }

    // Error MsgValidation
    public boolean ErrorMsg() {
        wait.until(d -> ErrorMsg.isDisplayed());
        return ErrorMsg.isDisplayed();
    }

}
