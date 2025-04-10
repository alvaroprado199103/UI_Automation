package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.practicesoftwaretestingpages.components.NavigationBarComponent;

public class AccountPage extends BasePage {
    @FindBy(css = "a[data-test='nav-sign-in']")
    private WebElement loginLink;

    private NavigationBarComponent navigationBar;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.navigationBar = new NavigationBarComponent(driver);
    }

    public void goToLogin() {
        waitUtils.waitForElementToBeClickable(loginLink);
        loginLink.click();
    }

    public void goToHome() {
        navigationBar.goToHome();
    }
}
