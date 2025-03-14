package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverWaitUtils {

    private static final Logger LOGGER = Logger.getLogger(WebDriverWaitUtils.class.getName());
    private static final int TIMEOUT_SECONDS = 10;
    private WebDriver driver;

    public WebDriverWaitUtils(WebDriver driver) {
        this.driver = driver;
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

    public void closeDriver() {
        if (driver != null) {
            LOGGER.log(Level.INFO, "Closing WebDriver...");
            driver.quit();
            LOGGER.log(Level.INFO, "WebDriver closed.");
        }
    }
}
