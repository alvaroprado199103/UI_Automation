package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverWaitUtils;
import utilities.ApiWaitUtils;
import pages.BasePage;

import java.util.List;

public class FilterPage extends BasePage {
    private ApiWaitUtils apiWaitUtils;

    @FindBy(xpath = "(//a[@class='card'])")
    private List<WebElement> productCards;

    @FindBy(xpath = "(//a[@class='card'])//span[@data-test='product-price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "(//a[@class='card'])//button[@data-test='add-to-cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "(//h5[@class='card-title'])")
    private List<WebElement> productNames;

    @FindBy(xpath = "//select[@data-test='sort-select']")
    private WebElement sortDropdown;

    @FindBy(xpath = "//input[@data-test='price-min']")
    private WebElement minPriceInput;

    @FindBy(xpath = "//input[@data-test='price-max']")
    private WebElement maxPriceInput;

    @FindBy(xpath = "//button[@data-test='filter-button']")
    private WebElement filterButton;

    @FindBy(xpath = "//button[@data-test='add-to-cart']")
    private WebElement addToCartButton;

    public FilterPage(WebDriver driver, WebDriverWaitUtils waitUtils) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.apiWaitUtils = new ApiWaitUtils(driver);
    }

    public void selectProduct(String productName) {
        waitUtils.waitForVisibility(productCards.get(0));
        for (int i = 0; i < productCards.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                System.out.println("Select product: Producto encontrado: " + productNames.get(i).getText());
                productNames.get(i).click();
                break;
            }
        }
    }

    public double getProductPrice(String productName) {
        waitUtils.waitForVisibility(productCards.get(0));
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                String priceText = productPrices.get(i).getText().replace("$", "").trim();
                return Double.parseDouble(priceText);
            }
        }
        return 0.0;
    }

    public void addProductToCart(String productName) {
        apiWaitUtils.waitForApiResponse("link[href*='products?between=price']");
        selectProduct(productName);
    }

    public boolean isProductAvailable(String productName) {
        waitUtils.waitForVisibility(productCards.get(0));
        return productNames.stream()
                .anyMatch(element -> element.getText().equals(productName));
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
