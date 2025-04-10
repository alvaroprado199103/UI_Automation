package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class AccountPage extends BasePage {
    @FindBy(css = "a[data-test='nav-home']")
    private WebElement homeLink;

    @FindBy(css = "h1[data-test='page-title']")
    private WebElement accountTitle;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToHome() {
        waitUtils.waitForVisibility(accountTitle);
        waitUtils.waitForElementToBeClickable(homeLink);
        homeLink.click();
    }
}
