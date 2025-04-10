package pages.practicesoftwaretestingpages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverWaitUtils;

public class NavigationBarComponent {
    private WebDriverWaitUtils waitUtils;

    @FindBy(xpath = "//a[@data-test='nav-sign-in']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@data-test='nav-cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//a[@id='menu']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@data-test='nav-my-invoices']")
    private WebElement myInvoicesButton;

    @FindBy(css = "a[data-test='nav-home']")
    private WebElement homeButton;

    public NavigationBarComponent(WebDriver driver) {
        this.waitUtils = new WebDriverWaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        waitUtils.waitForElementToBeClickable(loginLink);
        loginLink.click();
    }

    public void goToCart() {
        waitUtils.waitForElementToBeClickable(cartLink);
        cartLink.click();
    }

    public void goToMyInvoices() {
        waitUtils.waitForElementToBeClickable(menuButton);
        menuButton.click();
        waitUtils.waitForElementToBeClickable(myInvoicesButton);
        myInvoicesButton.click();
    }

    public void goToHome() {
        waitUtils.waitForElementToBeClickable(homeButton);
        homeButton.click();
    }
}
