package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverWaitUtils;
import pages.BasePage;

public class AccountPage extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homeLink;

    @FindBy(xpath = "//h1[normalize-space()='My account']")
    private WebElement accountTitle;

    public AccountPage(WebDriver driver, WebDriverWaitUtils waitUtils) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickHome() {
        waitUtils.waitForVisibility(accountTitle);
        waitUtils.waitForElementToBeClickable(homeLink);
        homeLink.click();
    }
}
