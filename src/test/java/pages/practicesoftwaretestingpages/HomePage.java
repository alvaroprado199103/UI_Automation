package pages.practicesoftwaretestingpages;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.practicesoftwaretestingpages.components.FilterComponent;
import pages.practicesoftwaretestingpages.components.NavigationBarComponent;

public class HomePage extends BasePage {
    private NavigationBarComponent navigationBar;
    private FilterComponent filterComponent;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBarComponent(driver);
        this.filterComponent = new FilterComponent(driver);
    }

    public void navigateToHomePage() {
        driver.get("https://practicesoftwaretesting.com/");
    }

    public void searchProduct(String productName) {
        filterComponent.searchProduct(productName);
    }

    public void clickLogin() {
        navigationBar.clickLogin();
    }

    public void goToCart() {
        navigationBar.goToCart();
    }

    public void selectCategory(String category) {
        filterComponent.selectCategory(category);
    }

    public void sortProducts(String sortOption) {
        filterComponent.sortProducts(sortOption);
    }

    public void filterByPrice(int minPrice, int maxPrice) {
        filterComponent.filterByPrice(minPrice, maxPrice);
    }

    public boolean isSearchCompleted() {
        return filterComponent.isSearchCompleted();
    }

    public void goToMyInvoices() {
        navigationBar.goToMyInvoices();
    }
}
