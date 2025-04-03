package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverWaitUtils;
import utilities.ApiWaitUtils;
import pages.BasePage;
import java.util.List;

public class HomePage extends BasePage {
    private ApiWaitUtils apiWaitUtils;
    private Actions actions;

    @FindBy(xpath = "//input[@data-test='search-query']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@data-test='search-submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-test='nav-sign-in']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@data-test='nav-cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//div[@class='checkbox']//label")
    private List<WebElement> categorySelector;

    @FindBy(xpath = "//div[@class='checkbox']//label//input[@type='checkbox']")
    private List<WebElement> categorySelectorcheckbox;

    @FindBy(xpath = "//select[@aria-label='sort']")
    private WebElement sortSelector;

    @FindBy(xpath = "//span[@aria-label='ngx-slider']")
    private WebElement minPriceInput;

    @FindBy(xpath = "//span[@aria-label='ngx-slider-max']")
    private WebElement maxPriceInput;

    @FindBy(xpath = "//button[@data-test='filter-button']")
    private WebElement filterButton;

    @FindBy(xpath = "//div[@data-test='search_completed']")
    private WebElement searchCompletedMessage;

    @FindBy(xpath = "//img[contains(@src, 'hammer06.avif')]")
    private WebElement productImage;

    @FindBy(xpath = "//a[@id='menu']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@data-test='nav-my-invoices']")
    private WebElement myInvoicesButton;

    public HomePage(WebDriver driver, WebDriverWaitUtils waitUtils) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.apiWaitUtils = new ApiWaitUtils(driver);
        this.actions = new Actions(driver);
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public void navigateToHomePage() {
        driver.get("https://practicesoftwaretesting.com/");
    }

    public void searchProduct(String productName) {
        waitUtils.waitForVisibility(searchInput);
        searchInput.clear();
        searchInput.sendKeys(productName);
        waitUtils.waitForElementToBeClickable(searchButton);
        searchButton.click();
        waitUtils.waitForVisibility(searchCompletedMessage);
        waitUtils.waitForVisibility(productImage);
    }

    public void clickLogin() {
        waitUtils.waitForElementToBeClickable(loginLink);
        loginLink.click();
    }

    public void goToCart() {
        waitUtils.waitForElementToBeClickable(cartLink);
        cartLink.click();
    }

    public void selectCategory(String category) {
        apiWaitUtils.waitForApiResponse("link[href*='content-all.css']");
        waitUtils.waitForVisibility(categorySelector.get(0));
        for (int i = 0; i < categorySelector.size(); i++) {
            if (categorySelector.get(i).getText().equals(category)) {
                System.out.println("Select Category: valor catergory" + i + ": " + categorySelector.get(i).getText());
                waitUtils.waitForElementToBeClickable(categorySelector.get(i));
                categorySelector.get(i).click();
                break;
            }
        }
    }

    public void sortProducts(String sortOption) {
        waitUtils.waitForElementToBeClickable(sortSelector);
        sortSelector.click();
        sortSelector.sendKeys(sortOption);
        sortSelector.click();
    }

    public void filterByPrice(int minPrice, int maxPrice) {
        waitUtils.waitForVisibility(minPriceInput);
        actions.dragAndDropBy(minPriceInput, (minPrice), 0).perform();

        waitUtils.waitForVisibility(maxPriceInput);
        actions.dragAndDropBy(maxPriceInput, (maxPrice), 0).perform();

        apiWaitUtils.waitForApiResponse("link[href*='content-all.css']");
    }

    public boolean isSearchCompleted() {
        waitUtils.waitForVisibility(searchCompletedMessage);
        return searchCompletedMessage.isDisplayed();
    }

    public void goToMyInvoices() {
        waitUtils.waitForElementToBeClickable(menuButton);
        menuButton.click();
        waitUtils.waitForElementToBeClickable(myInvoicesButton);
        myInvoicesButton.click();
    }
}
