package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.MainPage;

public class SauceDemoSteps {

    LoginPage loginPage;
    MainPage mainPage;
    WebDriver driver;

    @Before
    public void initialize() {
        System.out.println("Inicializando el WebDriver...");
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Ejecutar sin interfaz gráfica
            options.addArguments("--disable-gpu"); // Mejor compatibilidad en algunos entornos
            options.addArguments("--no-sandbox"); // Evita problemas en entornos CI/CD
            options.addArguments("--disable-dev-shm-usage"); // Mejora estabilidad en contenedores
            System.out.println("Configurando WebDriverManager...");
            WebDriverManager.chromedriver().setup();
            System.out.println("WebDriverManager configurado.");
            System.out.println("Creando instancia de ChromeDriver...");
            driver = new ChromeDriver(options);
            System.out.println("Instancia de ChromeDriver creada.");
            loginPage = new LoginPage(driver);
            mainPage = new MainPage(driver);
            System.out.println("Páginas inicializadas.");
        } catch (Exception e) {
            System.err.println("Error al inicializar el WebDriver: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-lanza la excepción para que la prueba falle
        }
        System.out.println("WebDriver inicializado correctamente.");
    }

    @After
    public void closeNav() {
        // driver.quit();
    }

    @Given("I navigate to www.saucedemo.com")
    public void iNavigateToSauceDemo() {
        loginPage.navigateToSauceDemo();
    }

    @When("Login using a correct password")
    public void LoginSuccesfully() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("standard_user", "secret_sauce");
        mainPage.logoutUser();
    }

    @Then("Login using incorrect password")
    public void LoginFailed() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("standard_user", "ecret_sauce");
        // Assert.assertTrue(loginPage.getErrorMessageB());
    }

    @Then("Login using a blocked account")
    public void LogingBlockedAccount() {
        loginPage.navigateToSauceDemo();
        loginPage.loginUser("locked_out_user", "secret_sauce");
        // Assert.assertTrue(loginPage.getErrorMessageB());
    }

}
