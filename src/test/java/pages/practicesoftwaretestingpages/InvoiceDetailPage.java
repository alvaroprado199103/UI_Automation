package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.ApiWaitUtils;

import pages.BasePage;

public class InvoiceDetailPage extends BasePage {
    private static final int ONE_SECOND = 1000;
    private static final int MAX_WAIT_TIME = 30;
    private static final int POLLING_INTERVAL = 1;
    private static final String DOWNLOAD_PATH = System.getProperty("user.home") + "/Downloads";
    private static final String PDF_EXTENSION = ".pdf";

    @FindBy(xpath = "//button[contains(text(),'Download PDF ')]")
    private WebElement downloadPdfButton;

    @FindBy(xpath = "//div[contains(text(), 'Download started')]")
    private WebElement downloadStartedMessage;

    private ApiWaitUtils apiWaitUtils;
    private String orderNumber;

    public InvoiceDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void downloadPDF() {
        apiWaitUtils.waitForApiResponse("link[href*='invoices/01jqw2j06zd19gp1jfkqe4dgwy']");
        apiWaitUtils.waitForApiResponse("link[href*='invoices/download-pdf-status']");

        waitUtils.waitForElementToBeClickable(downloadPdfButton);
        try {
            Thread.sleep(ONE_SECOND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        downloadPdfButton.click();
        System.out.println("download click ✅");

        if (waitForDownload(DOWNLOAD_PATH, orderNumber + PDF_EXTENSION, driver)) {
            System.out.println("✅");
        } else {
            System.out.println("❌ ");
        }
    }

    public boolean waitForDownload(String downloadPath, String expectedFileName, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));

        return wait.until(d -> {
            File file = new File(downloadPath + "/" + expectedFileName);
            return file.exists();
        });
    }
}
