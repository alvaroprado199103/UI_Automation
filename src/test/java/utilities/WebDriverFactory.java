package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverFactory {

    private static final Logger LOGGER = Logger.getLogger(WebDriverFactory.class.getName());
    private static final int TIMEOUT_SECONDS = 10;
    private WebDriver driver;

    public WebDriver createDriver() {
        LOGGER.log(Level.INFO, "Initializing WebDriver...");
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            LOGGER.log(Level.INFO, "Configuring WebDriverManager...");
            WebDriverManager.chromedriver().setup();
            LOGGER.log(Level.INFO, "WebDriverManager configured.");
            LOGGER.log(Level.INFO, "Creating ChromeDriver instance...");

            driver = new ChromeDriver(options);
            LOGGER.log(Level.INFO, "ChromeDriver instance created.");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error initializing WebDriver: " + e.getMessage(), e);
            throw e;
        }
        LOGGER.log(Level.INFO, "WebDriver initialized successfully.");
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            LOGGER.log(Level.INFO, "Closing WebDriver...");
            driver.quit();
            LOGGER.log(Level.INFO, "WebDriver closed.");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    // Explicit wait for a WebElement to be visible
    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Explicit wait for a WebElement to be clickable
    public void waitForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
