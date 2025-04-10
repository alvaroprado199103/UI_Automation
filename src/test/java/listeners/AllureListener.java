package listeners;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AllureListener implements ConcurrentEventListener {
    private final EventHandler<TestCaseStarted> testCaseStartedHandler = this::handleTestCaseStarted;
    private final EventHandler<TestCaseFinished> testCaseFinishedHandler = this::handleTestCaseFinished;
    private final EventHandler<TestStepStarted> testStepStartedHandler = this::handleTestStepStarted;
    private final EventHandler<TestStepFinished> testStepFinishedHandler = this::handleTestStepFinished;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, testCaseStartedHandler);
        publisher.registerHandlerFor(TestCaseFinished.class, testCaseFinishedHandler);
        publisher.registerHandlerFor(TestStepStarted.class, testStepStartedHandler);
        publisher.registerHandlerFor(TestStepFinished.class, testStepFinishedHandler);
    }

    private void handleTestCaseStarted(TestCaseStarted event) {
        // The real implementation will be handled through the Allure plugin
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        // Capture screenshot if available
        try {
            WebDriver driver = BasePage.getCurrentDriver();
            if (driver instanceof TakesScreenshot) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // The real implementation will be handled through the Allure plugin
            }
        } catch (Exception e) {
            // Ignore if screenshot cannot be captured
        }
    }

    private void handleTestStepStarted(TestStepStarted event) {
        try {
            WebDriver driver = BasePage.getCurrentDriver();
            if (driver instanceof TakesScreenshot) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // The real implementation will be handled through the Allure plugin
            }
        } catch (Exception e) {
            // Ignore if screenshot cannot be captured
        }
    }

    private void handleTestStepFinished(TestStepFinished event) {
        try {
            WebDriver driver = BasePage.getCurrentDriver();
            if (driver instanceof TakesScreenshot) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // The real implementation will be handled through the Allure plugin
            }
        } catch (Exception e) {
            // Ignore if screenshot cannot be captured
        }
    }
}
