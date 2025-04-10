package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ApiWaitUtils {
    private WebDriverWait wait;
    private static final int DEFAULT_TIMEOUT_SECONDS = 10;
    public int sec;

    public ApiWaitUtils(WebDriver driver) {
        sec = DEFAULT_TIMEOUT_SECONDS;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
    }

    public void waitForApiResponse(String cssSelector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
        } catch (Exception e) {
        }
    }
}
