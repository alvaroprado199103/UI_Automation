package pages;

// Importaciones necesarias  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration; // Import for Duration  

public class SeleniumTestExample {

    // Instancia del WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configuración del WebDriver
        System.setProperty("webdriver.chrome.driver", "ruta/al/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Manejo de ventanas
    }

    @Test
    public void testWebPage() {
        // Abrir una página web
        driver.get("http://example.com");

        // Ejemplo de Page Object Model
        PageObject page = PageFactory.initElements(driver, PageObject.class);
        page.clickElement();

        // Ejemplo de locators
        WebElement element = driver.findElement(By.id("elementId"));
        element.click();

        // Manejo de esperas (Waits)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated line
        wait.until(ExpectedConditions.titleIs("Título Esperado"));

        // Aserción simple
        Assert.assertEquals(driver.getTitle(), "Título Esperado");
    }

    @Test
    public void testAPIConnection() {
        // Conexión a una API usando RestAssured
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testJSONFileConnection() throws Exception {
        // Conexión a un archivo JSON
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File("ruta/al/archivo.json"));
        Assert.assertNotNull(jsonNode);
    }

    @Test
    public void testDatabaseConnection() {
        // Conexión a una base de datos
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_bd", "usuario", "contraseña");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tu_tabla");
            while (rs.next()) {
                System.out.println(rs.getString("columna"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWindowHandling() {
        // Manejo de ventanas
        driver.get("http://example.com");
        String originalWindow = driver.getWindowHandle();
        // Supongamos que se abre un nuevo enlace
        WebElement link = driver.findElement(By.linkText("Open new window"));
        link.click();

        // Cambiar a la nueva ventana
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Aserta que la nueva ventana tiene el URL esperado
        Assert.assertEquals(driver.getCurrentUrl(), "http://expected-url.com");
        // Cierra la nueva ventana y vuelve a la original
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @AfterClass
    public void tearDown() {
        // Cerrar el WebDriver
        if (driver != null) {
            driver.quit();
        }
    }

    // Clase Page Object para el uso de locators con Page Factory
    public static class PageObject {
        @FindBy(id = "elementId")
        private WebElement element;

        public void clickElement() {
            element.click();
        }
    }
}