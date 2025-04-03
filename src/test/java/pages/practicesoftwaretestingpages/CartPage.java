package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverWaitUtils;
import pages.BasePage;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class='cart-item']")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//a[@aria-label='cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='wizard-steps horizontal']//aw-wizard-step//app-cart//div//button[@type='button']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='cart-total']")
    private WebElement cartTotal;

    @FindBy(xpath = "//button[@data-test='remove-item']")
    private List<WebElement> removeButtons;

    @FindBy(xpath = "//input[@data-test='quantity-input']")
    private List<WebElement> quantityInputs;

    public CartPage(WebDriver driver, WebDriverWaitUtils waitUtils) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        waitUtils.waitForElementToBeClickable(cartButton);
        cartButton.click();
        waitUtils.waitForElementToBeClickable(checkoutButton);
        checkoutButton.click();
    }
}
