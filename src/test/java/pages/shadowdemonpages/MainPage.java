package pages.shadowdemonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utilities.WebDriverWaitUtils;
import org.openqa.selenium.TimeoutException;

public class MainPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='app_logo' and text()='Swag Labs']")
    private WebElement mainMenuTitle;

    public MainPage(WebDriver driver, WebDriverWaitUtils waitUtils) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logoutUser() {
        waitUtils.waitForElementToBeClickable(menuButton);
        menuButton.click();
        waitUtils.waitForElementToBeClickable(logoutButton);
        logoutButton.click();
    }

    public boolean isMainMenuVisible() {
        try {
            waitUtils.waitForVisibility(mainMenuTitle);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getUsername() {
        waitUtils.waitForVisibility(username);
        return username.getText();
    }

    public boolean isErrorMessageDisplayed() {
        waitUtils.waitForVisibility(errorMessage);
        return errorMessage.isDisplayed();
    }
}
