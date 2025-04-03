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
import utilities.WebDriverWaitUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PracticeSoftwareTestingSteps {
    private static final Logger LOGGER = Logger.getLogger(PracticeSoftwareTestingSteps.class.getName());
    private WebDriver driver;
    private HomePage homePage;
    private LoginPagePST loginPage;
    private FilterPage productsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private AccountPage accountPage;
    private CheckoutPage checkoutPage;
    private InvoicesPage invoicesPage;
    private InvoiceDetailPage invoiceDetailPage;
    private WebDriverWaitUtils waitUtils;
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
            waitUtils = new WebDriverWaitUtils(driver);
            homePage = new HomePage(driver, waitUtils);
            loginPage = new LoginPagePST(driver, waitUtils);
            productsPage = new FilterPage(driver, waitUtils);
            productPage = new ProductPage(driver, waitUtils);
            cartPage = new CartPage(driver, waitUtils);
            checkoutPage = new CheckoutPage(driver, waitUtils);
            invoicesPage = new InvoicesPage(driver, waitUtils);
            invoiceDetailPage = new InvoiceDetailPage(driver, waitUtils);
            accountPage = new AccountPage(driver, waitUtils);
            min = MIN_PRICE;
            max = MAX_PRICE;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error setting up test environment: " + e.getMessage(), e);
            throw e;
        }
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("the user is on the home page")
    public void userIsOnHomePage() {
        homePage.navigateToHomePage();
    }

    @Given("the user is authenticated with valid credentials")
    public void userIsAuthenticated() {
        homePage.clickLogin();
        loginPage.login("customer@practicesoftwaretesting.com", "welcome01");
        accountPage.clickHome();
    }

    @When("the user searches for a hand tool using the search bar")
    public void userSearchesForHandTool() {
        homePage.searchProduct("hammer");
    }

    @When("the user selects a power tool using category filters")
    public void userSelectsPowerTool() {
        homePage.selectCategory("Power Tools");
    }

    @When("the user searches for another tool using combined filters")
    public void userSearchesWithCombinedFilters() {
        homePage.selectCategory("Other");
        homePage.sortProducts("Price (Low - High)");
        homePage.filterByPrice(min, max);
    }

    @And("adds the hand tool to the cart")
    public void addHandToolToCart() {
        productsPage.addProductToCart("Hammer");
        productPage.addToCart();
    }

    @And("adds the power tool to the cart")
    public void addPowerToolToCart() {
        productsPage.addProductToCart("Cordless Drill 24V");
        productPage.addToCart();
    }

    @And("adds the third tool to the cart")
    public void addThirdToolToCart() {
        productsPage.addProductToCart("Leather toolbelt");
        productPage.addToCart();
    }

    @When("the user goes to the cart")
    public void userGoesToCart() {
        homePage.goToCart();
    }

    @When("the user proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage.proceedToCheckout();
    }

    @When("the user fills in shipping information")
    public void userFillsShippingInfo() {
        checkoutPage.fillShippingInfo(SHIPPING_INFO);
    }

    @When("the user fills in payment information")
    public void userFillsPaymentInfo() {
        checkoutPage.fillPaymentInfo("4242-4242-4242-4242", "12/2026", "507", "John Doe");
    }

    @When("the user places the order")
    public void userPlacesOrder() {
        checkoutPage.placeOrder();
    }

    @When("the user completes the payment process")
    public void userCompletesPayment() {
        userFillsShippingInfo();
        userFillsPaymentInfo();
        userPlacesOrder();
    }

    @Then("the purchase is completed successfully")
    public void purchaseIsCompleted() {
        assert checkoutPage.isOrderConfirmed();
    }

    @Then("the invoice is successfully associated with the user account")
    public void invoiceIsAssociatedWithUser() {
        String orderNumber = checkoutPage.getOrderNumber();
        System.out.println("Invoice Number: " + orderNumber);
        assert orderNumber != null;
        homePage.goToMyInvoices();
        invoicesPage.isInvoiceAssociated(orderNumber);
        invoiceDetailPage.setOrderNumber(orderNumber);
        // invoiceDetailPage.downloadPDF();
    }

    @Then("the order should be confirmed")
    public void orderShouldBeConfirmed() {
        assert checkoutPage.isOrderConfirmed();
    }

    @Then("the user should see the order number")
    public void userShouldSeeOrderNumber() {
        assert checkoutPage.getOrderNumber() != null;
    }

    @Then("the user should be able to view the invoice")
    public void userShouldViewInvoice() {
        String orderNumber = checkoutPage.getOrderNumber();
        homePage.goToMyInvoices();
        invoicesPage.isInvoiceAssociated(orderNumber);
        invoiceDetailPage.setOrderNumber(orderNumber);
        // invoiceDetailPage.downloadPDF();
    }
}
