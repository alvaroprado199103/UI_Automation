package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ApiWaitUtils;
import pages.BasePage;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.stream.IntStream;

public class ProductListPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(ProductListPage.class.getName());
    private ApiWaitUtils apiWaitUtils;

    @FindBy(css = ".card")
    private List<WebElement> productCards;

    @FindBy(css = "span[data-test='product-price']")
    private List<WebElement> productPrices;

    @FindBy(css = "h5.card-title")
    private List<WebElement> productNames;

    public ProductListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.apiWaitUtils = new ApiWaitUtils(driver);
    }

    public void addProductToCart(String productName) {
        apiWaitUtils.waitForApiResponse("link[href*='content-all.css']");
        waitUtils.waitForVisibility(productCards.get(0));

        IntStream.range(0, productNames.size())
                .filter(i -> productNames.get(i).getText().equals(productName))
                .findFirst()
                .ifPresent(i -> {
                    LOGGER.log(Level.INFO, "Product found: {0}", productName);
                    productNames.get(i).click();
                });
    }

    public boolean isProductAvailable(String productName) {
        waitUtils.waitForVisibility(productCards.get(0));
        return productNames.stream()
                .anyMatch(element -> element.getText().equals(productName));
    }
}
