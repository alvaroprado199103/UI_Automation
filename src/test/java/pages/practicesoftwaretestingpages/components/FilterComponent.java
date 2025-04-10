package pages.practicesoftwaretestingpages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ApiWaitUtils;
import utilities.WebDriverWaitUtils;
import java.util.List;

public class FilterComponent {
    private WebDriverWaitUtils waitUtils;
    private ApiWaitUtils apiWaitUtils;
    private Actions actions;

    @FindBy(xpath = "//input[@data-test='search-query']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@data-test='search-submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='checkbox']//label")
    private List<WebElement> categorySelector;

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

    @FindBy(xpath = "//select[@data-test='sort-select']")
    private WebElement sortDropdown;

    public FilterComponent(WebDriver driver) {
        this.waitUtils = new WebDriverWaitUtils(driver);
        this.apiWaitUtils = new ApiWaitUtils(driver);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
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

    public void sortByPrice(String sortOption) {
        waitUtils.waitForElementToBeClickable(sortDropdown);
        sortDropdown.click();
        sortDropdown.sendKeys(sortOption);
    }

    public void setPriceRange(String minPrice, String maxPrice) {
        waitUtils.waitForVisibility(minPriceInput);
        minPriceInput.clear();
        minPriceInput.sendKeys(minPrice);

        waitUtils.waitForVisibility(maxPriceInput);
        maxPriceInput.clear();
        maxPriceInput.sendKeys(maxPrice);

        waitUtils.waitForElementToBeClickable(filterButton);
        filterButton.click();
    }
}
