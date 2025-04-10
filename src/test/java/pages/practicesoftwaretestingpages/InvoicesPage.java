package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ApiWaitUtils;
import pages.BasePage;
import java.util.List;

public class InvoicesPage extends BasePage {
    @FindBy(xpath = "//tbody/tr/td[1]")
    private List<WebElement> invoiceNumbers;

    @FindBy(xpath = "//tbody/tr/td[5]//a[contains(text(),'Details')]")
    private List<WebElement> detailsButtons;

    @FindBy(xpath = "//li//a[contains(@aria-label, 'Next')]")
    private WebElement nextPageButton;

    private ApiWaitUtils apiWaitUtils;

    public InvoicesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.apiWaitUtils = new ApiWaitUtils(driver);
    }

    public void isInvoiceAssociated(String orderNumber) {
        boolean invoiceFound = false;
        int currentPage = 1;

        while (!invoiceFound) {
            apiWaitUtils.waitForApiResponse("link[href*='invoices?page=" + currentPage + "']");
            waitUtils.waitForVisibility(invoiceNumbers.get(0));

            for (int i = 0; i < invoiceNumbers.size(); i++) {
                if (invoiceNumbers.get(i).getText().equals(orderNumber)) {
                    System.out.println("Invoice found in page " + currentPage + " at position " + (i + 1));
                    waitUtils.waitForElementToBeClickable(detailsButtons.get(i));
                    detailsButtons.get(i).click();
                    invoiceFound = true;
                    break;
                }
            }

            if (!invoiceFound) {
                try {
                    waitUtils.waitForElementToBeClickable(nextPageButton);
                    nextPageButton.click();
                    currentPage++;
                } catch (Exception e) {
                    System.out.println("Invoice not found in any page");
                    break;
                }
            }
        }
    }
}
