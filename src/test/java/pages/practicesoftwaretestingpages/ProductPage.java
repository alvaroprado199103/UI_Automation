package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.practicesoftwaretestingpages.components.NavigationBarComponent;

public class ProductPage extends BasePage {
    @FindBy(css = "button[data-test='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(css = "div#toast-container")
    private WebElement toastMessage;

    private NavigationBarComponent navigationBar;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.navigationBar = new NavigationBarComponent(driver);
    }

    public void addToCart() {
        waitUtils.waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
        waitUtils.waitForVisibility(toastMessage);
        navigationBar.goToHome();
    }
}
