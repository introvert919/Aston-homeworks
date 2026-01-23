import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class MtsTests {

    static WebDriver driver;
    PaymentPage objPaymentPage;

    @BeforeAll
    static void oneTimeSetUp() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement Button = driver.findElement(By.id("cookie-agree"));
        Button.click();
    }

    @BeforeEach
    void tearDown() {
        driver.navigate().refresh();
    }

    @AfterAll
    static void oneTimeTearDown() {
        driver.quit();
    }


    @DisplayName("Картинки в блоке \"Онлайн пополнение без комиссии\"")
    @ParameterizedTest
    @ValueSource(strings = {"Visa", "Verified by Visa", "MasterCard", "MasterCard Secure Code", "Belcard"})
    public void imageTest(String imageName)
    {
        objPaymentPage = new PaymentPage(driver);
        Assertions.assertTrue(objPaymentPage.imageIsDisplayed(imageName));
    }
}