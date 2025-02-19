package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public constructor( WebDriver driver ) { 
    this.driver = driver;

    @FindBy(how = How.ID, using = "user-name")
    private WebElement Username;
    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    private WebElement MenuBtn;
    @FindBy(how = How.ID, using = "logout_sidebar_link")
    private WebElement LogoutBtn;
    PageFactory.initElement(driver, this);
    }

    public MainPage() {
        super(driver);
    }

    // Logout User
    public void logoutUser() {
        MenuBtn.click();
        LogoutBtn.click();
        Username.isDisplayed();
    }

}
