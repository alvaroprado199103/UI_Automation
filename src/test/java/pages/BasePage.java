package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WebDriverWaitUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWaitUtils waitUtils;
    private static final int DEFAULT_TIMEOUT_SECONDS = 10;
    private static final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        this.waitUtils = new WebDriverWaitUtils(driver);
    }

    public static WebDriver initializeDriver(boolean headless) {
        LOGGER.log(Level.INFO, "Initializing WebDriver...");
        try {
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            LOGGER.log(Level.INFO, "WebDriver initialized successfully.");
            return driver;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error initializing WebDriver: " + e.getMessage(), e);
            throw e;
        }
    }

    protected void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
