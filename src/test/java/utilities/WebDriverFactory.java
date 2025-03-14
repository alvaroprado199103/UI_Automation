package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverFactory {

    private static Logger LOGGER = Logger.getLogger(WebDriverFactory.class.getName());

    public WebDriver createDriver() {
        WebDriver driver;
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
}
