package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverWaitUtils;
import pages.BasePage;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//button[@data-test='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//h1[@data-test='product-name']")
    private WebElement productName;

    @FindBy(xpath = "//span[@data-test='product-price']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@data-test='product-description']")
    private WebElement productDescription;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement toastMessage;

    @FindBy(xpath = "//a[@data-test='nav-home']")
    private WebElement homeButton;

    public ProductPage(WebDriver driver, WebDriverWaitUtils waitUtils) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        waitUtils.waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
        waitUtils.waitForVisibility(toastMessage);
        clickHome();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void clickHome() {
        waitUtils.waitForElementToBeClickable(homeButton);
        homeButton.click();
    }
}
