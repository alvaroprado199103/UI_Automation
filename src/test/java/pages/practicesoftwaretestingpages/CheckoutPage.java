package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ApiWaitUtils;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX = 1;
    private static final int STREET_INDEX = 2;
    private static final int CITY_INDEX = 3;
    private static final int STATE_INDEX = 4;
    private static final int POSTAL_CODE_INDEX = 5;
    private static final int COUNTRY_INDEX = 6;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='street']")
    private WebElement streetInput;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='postal_code']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement countrySelect;

    @FindBy(xpath = "//input[@id='credit_card_number']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@id='expiration_date']")
    private WebElement expiryDateInput;

    @FindBy(xpath = "//input[@id='cvv']")
    private WebElement cvvInput;

    @FindBy(xpath = "//button[contains(text(), ' Proceed to checkout ')]")
    private WebElement placeOrderButton;

    @FindBy(xpath = "(//button[contains(.,'Proceed to checkout ')])[2]")
    private WebElement ProceedToCheckout3;

    @FindBy(xpath = "//select[@id='payment-method']")
    private WebElement paymentMethodSelect;

    @FindBy(xpath = "//option[@value='credit-card']")
    private WebElement creditCardOption;

    @FindBy(xpath = "//input[@id='card_holder_name']")
    private WebElement cardHolderNameInput;

    @FindBy(xpath = "//button[@data-test='finish']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement orderConfirmation;

    @FindBy(xpath = "//span[contains(text(), 'INV-')]")
    private WebElement orderNumber;

    private ApiWaitUtils apiWaitUtils;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.apiWaitUtils = new ApiWaitUtils(driver);
    }

    public void fillShippingInfo(String[] shippingInfo) {
        try {
            waitUtils.waitForElementToBeClickable(placeOrderButton);
            placeOrderButton.click();
        } catch (Exception e) {
            waitUtils.waitForVisibility(firstNameInput);
            firstNameInput.clear();
            firstNameInput.click();
            firstNameInput.sendKeys(shippingInfo[FIRST_NAME_INDEX]);

            waitUtils.waitForVisibility(lastNameInput);
            lastNameInput.clear();
            lastNameInput.click();
            lastNameInput.sendKeys(shippingInfo[LAST_NAME_INDEX]);
        }

        waitUtils.waitForElementToBeClickable(streetInput);
        streetInput.click();
        streetInput.clear();
        streetInput.sendKeys(shippingInfo[STREET_INDEX]);

        waitUtils.waitForElementToBeClickable(cityInput);
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(shippingInfo[CITY_INDEX]);

        waitUtils.waitForElementToBeClickable(countrySelect);
        countrySelect.click();
        countrySelect.clear();
        countrySelect.sendKeys(shippingInfo[COUNTRY_INDEX]);

        waitUtils.waitForElementToBeClickable(stateInput);
        stateInput.click();
        stateInput.sendKeys(shippingInfo[STATE_INDEX]);

        waitUtils.waitForElementToBeClickable(postalCodeInput);
        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(shippingInfo[POSTAL_CODE_INDEX]);

        waitUtils.waitForElementToBeClickable(ProceedToCheckout3);
        ProceedToCheckout3.click();
    }

    public void fillPaymentInfo(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        waitUtils.waitForElementToBeClickable(paymentMethodSelect);
        paymentMethodSelect.click();
        waitUtils.waitForElementToBeClickable(creditCardOption);
        creditCardOption.click();

        waitUtils.waitForVisibility(cardNumberInput);
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumber);

        waitUtils.waitForVisibility(expiryDateInput);
        expiryDateInput.clear();
        expiryDateInput.sendKeys(expiryDate);

        waitUtils.waitForVisibility(cvvInput);
        cvvInput.clear();
        cvvInput.sendKeys(cvv);

        waitUtils.waitForVisibility(cardHolderNameInput);
        cardHolderNameInput.clear();
        cardHolderNameInput.sendKeys(cardHolderName);

        waitUtils.waitForElementToBeClickable(confirmButton);
        confirmButton.click();
    }

    public void placeOrder() {
        waitUtils.waitForVisibility(orderConfirmation);
        confirmButton.click();
    }

    public boolean isCheckoutPageDisplayed() {
        waitUtils.waitForVisibility(firstNameInput);
        return firstNameInput.isDisplayed();
    }

    public boolean isOrderConfirmed() {
        waitUtils.waitForVisibility(orderConfirmation);
        confirmButton.click();
        return orderConfirmation.isDisplayed();
    }

    public String getTheInvoiceNumber() {
        waitUtils.waitForVisibility(orderConfirmation);
        String confirmationText = orderConfirmation.getText();
        String invoiceNumber = confirmationText.split("Invoice Number: ")[1].split(" ")[0];
        return invoiceNumber;
    }

    public String getOrderNumber() {
        apiWaitUtils.waitForApiResponse("link[href*='invoices']");
        return orderNumber.getText();
    }
}
