import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/* Необходимо написать автотесты для сайта mts.by.
Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
Проверить название указанного блока;
Проверить наличие логотипов платёжных систем;
Проверить работу ссылки «Подробнее о сервисе»;
Заполнить поля и проверить работу кнопки «Продолжить»
(проверяем только вариант «Услуги связи», номер для теста 297777777) */

public class MtsTests
{
    static WebDriver driver;

    @BeforeAll
    static void oneTimeSetUp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement Button = driver.findElement(By.id("cookie-agree"));
        Button.click();
    }

    @BeforeEach
    void tearDown()
    {
        driver.navigate().refresh();
    }

    @AfterAll
    static void oneTimeTearDown()
    {
        driver.quit();
    }


    @DisplayName("Текст заголовка \"Онлайн пополнение без комиссии\"")
    @Test
    public void headerTextTest ()
    {
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение')]")).getText());
    }

    @DisplayName("Наличие картинок карт оплаты")
    @ParameterizedTest
    @ValueSource(strings = { "//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']",  // Visa.
            "//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg']",  // Verified by Visa.
            "//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']",  // Master Card.
            "//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg']",  // Master Card Secure Code.
            "//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']"}) // Белкард.

    public void imageIsDisplayedTest (String xPath)
    {
        Assertions.assertTrue(driver.findElement(By.xpath(xPath)).isDisplayed());
    }

    @DisplayName("Работа ссылки \"Подробнее о сервисе\"")
    @Test
    public void aboutServiceLinkTest ()
    {
        driver.findElement(By.linkText("Подробнее о сервисе")).click();
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", driver.getTitle());
        driver.navigate().back();
    }

    @DisplayName("Работа кнопки \"Продолжить\"")
    @Test
    public void continueButtonTest ()
    {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777"); // Поле "Номер телефона".
        driver.findElement(By.id("connection-sum")).sendKeys("100"); // Поле "Сумма к оплате".
        driver.findElement(By.id("connection-email")).sendKeys("introvert919@mail.ru"); // Поле "E-mail".
        driver.findElement(By.xpath("//form[@id='pay-connection']/child::button")).click(); // Кнопка "Продолжить".

        var iframe = driver.findElement(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")); // Окно оплаты.
        driver.switchTo().frame(iframe);

        String actual = driver.findElement(By.xpath("//div[@class='pay-description__cost']/child::span")).getText();
        Assertions.assertEquals("100.00 BYN", actual); // В assert поиск actual не выполняется.
    }
}