package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.practicesoftwaretestingpages.*;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import org.junit.Assert;

@Epic("E-commerce Application")
@Feature("Shopping Experience")
public class PracticeSoftwareTestingSteps {
    private static final Logger LOGGER = Logger.getLogger(PracticeSoftwareTestingSteps.class.getName());
    private WebDriver driver;
    private HomePage homePage;
    private LoginPagePST loginPage;
    private ProductListPage productsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private AccountPage accountPage;
    private CheckoutPage checkoutPage;
    private InvoicesPage invoicesPage;
    private InvoiceDetailPage invoiceDetailPage;
    private static final int MIN_PRICE = 50;
    private static final int MAX_PRICE = 150;
    private static final String[] SHIPPING_INFO = { "John", "Doe", "123 Main St", "New Yersey", "New York", "10001",
            "Unites States" };
    int min, max;

    @Before
    public void setup() {
        LOGGER.log(Level.INFO, "Initializing test environment...");
        try {
            driver = BasePage.initializeDriver(true);
            homePage = new HomePage(driver);
            loginPage = new LoginPagePST(driver);
            productsPage = new ProductListPage(driver);
            productPage = new ProductPage(driver);
            cartPage = new CartPage(driver);
            checkoutPage = new CheckoutPage(driver);
            invoicesPage = new InvoicesPage(driver);
            invoiceDetailPage = new InvoiceDetailPage(driver);
            accountPage = new AccountPage(driver);
            min = MIN_PRICE;
            max = MAX_PRICE;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error setting up test environment: " + e.getMessage(), e);
            saveScreenshot("Setup Error");
            throw e;
        }
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(String name) {
        try {
            return ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to take screenshot: " + e.getMessage(), e);
            return new byte[0];
        }
    }

    @Given("the user is on the home page")
    @Step("User navigates to the home page")
    @Description("User navigates to the application home page")
    @Severity(SeverityLevel.BLOCKER)
    public void userIsOnHomePage() {
        homePage.navigateToHomePage();
        Allure.addAttachment("Home Page", "text/plain", "User successfully navigated to the home page");
    }

    @Given("the user is authenticated with valid credentials")
    @Step("User authenticates with valid credentials")
    @Description("User logs in with valid email and password")
    @Severity(SeverityLevel.BLOCKER)
    public void userIsAuthenticated() {
        homePage.clickLogin();
        loginPage.login("customer@practicesoftwaretesting.com", "welcome01");
        accountPage.goToHome();
        Allure.addAttachment("Authentication", "text/plain", "User successfully authenticated");
    }

    @When("the user searches for a Hammer using the search bar")
    @Step("User searches for a Hammer")
    @Description("User searches for a Hammer using the search bar")
    @Severity(SeverityLevel.NORMAL)
    public void userSearchesForHandTool() {
        homePage.searchProduct("hammer");
        Allure.addAttachment("Search", "text/plain", "User searched for 'Hammer'");
    }

    @When("the user selects a Cordless Drill 24V using category filters")
    @Step("User selects a Cordless Drill 24V category")
    @Description("User selects the Power Tools category from filters")
    @Severity(SeverityLevel.NORMAL)
    public void userSelectsPowerTool() {
        homePage.selectCategory("Power Tools");
        Allure.addAttachment("Category Selection", "text/plain", "User selected 'Power Tools' category");
    }

    @When("the user searches for a Leather toolbelt in the 'Other' category, " +
            "with a price between '50' and '150', " +
            "sorting the results by price from 'Low to High'")
    @Step("User applies combined filters")
    @Description("User selects Other category, sorts by price, and applies price filter")
    @Severity(SeverityLevel.NORMAL)
    public void userSearchesWithCombinedFilters() {
        homePage.selectCategory("Other");
        homePage.sortProducts("Price (Low - High)");
        homePage.filterByPrice(min, max);
        Allure.addAttachment("Filter Application", "text/plain",
                String.format("User applied filters: Category=Other, Sort=Price (Low-High), Price Range=%d-%d", min,
                        max));
    }

    @And("adds the Hammer to the cart")
    @Step("User adds the Hammer to cart")
    @Description("User adds a Hammer to the shopping cart")
    @Severity(SeverityLevel.NORMAL)
    public void addsHammerToCart() {
        productsPage.addProductToCart("Hammer");
        productPage.addToCart();
        Allure.addAttachment("Add to Cart", "text/plain", "User added 'Hammer' to cart");
    }

    @And("adds the Cordless Drill 24V to the cart")
    @Step("User adds Cordless Drill 24V to cart")
    @Description("User adds a Cordless Drill 24V to the shopping cart")
    @Severity(SeverityLevel.NORMAL)
    public void addPowerToolToCart() {
        productsPage.addProductToCart("Cordless Drill 24V");
        productPage.addToCart();
        Allure.addAttachment("Add to Cart", "text/plain", "User added 'Cordless Drill 24V' to cart");
    }

    @And("adds the Leather toolbelt to the cart")
    @Step("User adds Leather toolbelt to cart")
    @Description("User adds a Leather toolbelt to the shopping cart")
    @Severity(SeverityLevel.NORMAL)
    public void addThirdToolToCart() {
        productsPage.addProductToCart("Leather toolbelt");
        productPage.addToCart();
        Allure.addAttachment("Add to Cart", "text/plain", "User added 'Leather toolbelt' to cart");
    }

    @When("the user goes to the cart")
    @Step("User navigates to shopping cart")
    @Description("User navigates to the shopping cart page")
    @Severity(SeverityLevel.NORMAL)
    public void userGoesToCart() {
        homePage.goToCart();
        Allure.addAttachment("Navigation", "text/plain", "User navigated to shopping cart");
    }

    @When("the user proceeds to checkout")
    @Step("User proceeds to checkout")
    @Description("User clicks on the proceed to checkout button")
    @Severity(SeverityLevel.NORMAL)
    public void userProceedsToCheckout() {
        cartPage.proceedToCheckout();
        Allure.addAttachment("Checkout", "text/plain", "User proceeded to checkout");
    }

    @When("the user fills in shipping information")
    @Step("User fills shipping information")
    @Description("User fills in shipping details including name, address, and contact information")
    @Severity(SeverityLevel.CRITICAL)
    public void userFillsShippingInfo() {
        checkoutPage.fillShippingInfo(SHIPPING_INFO);
        Allure.addAttachment("Shipping Info", "text/plain",
                String.format("User filled shipping info: ",
                        Arrays.toString(SHIPPING_INFO)));
    }

    @When("the user fills in payment information")
    @Step("User fills payment information")
    @Description("User fills in payment details including card number, expiry date, CVV, and cardholder name")
    @Severity(SeverityLevel.CRITICAL)
    public void userFillsPaymentInfo() {
        checkoutPage.fillPaymentInfo("4242-4242-4242-4242", "12/2026", "507", "John Doe");
        Allure.addAttachment("Payment Info", "text/plain",
                "User filled payment info: Card ending in Visa, Expiry: 12/2026, CVV: 507, Name: John Doe");
    }

    @When("the user places the order")
    @Step("User places order")
    @Description("User clicks on the place order button to complete the purchase")
    @Severity(SeverityLevel.CRITICAL)
    public void userPlacesOrder() {
        checkoutPage.placeOrder();
        Allure.addAttachment("Order Placement", "text/plain", "User placed the order");
    }

    @When("the user completes the payment process")
    @Step("User completes payment process")
    @Description("User completes the entire payment process including shipping and payment information")
    @Severity(SeverityLevel.CRITICAL)
    public void userCompletesPayment() {
        userFillsShippingInfo();
        userFillsPaymentInfo();
        userPlacesOrder();
        Allure.addAttachment("Payment Process", "text/plain", "User completed the entire payment process");
    }

    @Then("the purchase is completed successfully")
    @Step("Purchase is completed successfully")
    @Description("Verify that the purchase was completed successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void purchaseIsCompleted() {
        boolean isConfirmed = checkoutPage.isOrderConfirmed();
        Assert.assertTrue("Order confirmation should be visible", isConfirmed);
        Allure.addAttachment("Order Confirmation", "text/plain",
                isConfirmed ? "Order was confirmed successfully" : "Order confirmation failed");
        saveScreenshot("Order Confirmation");
    }

    @Then("the invoice is successfully associated with the user account")
    @Step("Invoice is associated with user account")
    @Description("Verify that the invoice is associated with the user account")
    @Severity(SeverityLevel.BLOCKER)
    public void invoiceIsAssociatedWithUser() {
        String orderNumber = checkoutPage.getOrderNumber();
        Assert.assertNotNull("Order number should not be null", orderNumber);
        Allure.addAttachment("Order Number", "text/plain", "Order Number: " + orderNumber);

        homePage.goToMyInvoices();
        invoicesPage.isInvoiceAssociated(orderNumber);
        Allure.addAttachment("Invoice Association", "text/plain",
                "Invoice was successfully associated with user account");

        invoiceDetailPage.setOrderNumber(orderNumber);
        saveScreenshot("Invoice Details");
    }

    @Then("the order should be confirmed")
    @Step("Order is confirmed")
    @Description("Verify that the order is confirmed")
    @Severity(SeverityLevel.BLOCKER)
    public void orderShouldBeConfirmed() {
        boolean isConfirmed = checkoutPage.isOrderConfirmed();
        Assert.assertTrue("Order confirmation should be visible", isConfirmed);
        Allure.addAttachment("Order Confirmation", "text/plain",
                isConfirmed ? "Order was confirmed successfully" : "Order confirmation failed");
        saveScreenshot("Order Confirmation");
    }

    @Then("the user should see the order number")
    @Step("User sees order number")
    @Description("Verify that the order number is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void userShouldSeeOrderNumber() {
        String orderNumber = checkoutPage.getOrderNumber();
        Assert.assertNotNull("Order number should not be null", orderNumber);
        Allure.addAttachment("Order Number", "text/plain", "Order Number: " + orderNumber);
    }

    @Then("the user should be able to view the invoice")
    @Step("User views invoice")
    @Description("Verify that the user can view the invoice")
    @Severity(SeverityLevel.NORMAL)
    public void userShouldViewInvoice() {
        String orderNumber = checkoutPage.getOrderNumber();
        Assert.assertNotNull("Order number should not be null", orderNumber);
        Allure.addAttachment("Order Number", "text/plain", "Order Number: " + orderNumber);

        homePage.goToMyInvoices();
        invoicesPage.isInvoiceAssociated(orderNumber);
        Allure.addAttachment("Invoice Association", "text/plain",
                "Invoice was successfully associated with user account");

        invoiceDetailPage.setOrderNumber(orderNumber);
        saveScreenshot("Invoice Details");
    }
}
