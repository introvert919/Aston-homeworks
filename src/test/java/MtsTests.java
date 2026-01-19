import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
        var headerTextParent = driver.findElement(By.className("pay__wrapper"));
        var headerTextChild = headerTextParent.findElement(By.tagName("h2"));
        String actual = headerTextChild.getText();
        String expected = "Онлайн пополнение\nбез комиссии";
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Наличие картинок карт оплаты")
    @ParameterizedTest
    @ValueSource(strings = { "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img",  // Visa.
                             "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img",  // Verified by Visa.
                             "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img",  // Master Card.
                             "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img",  // Master Card Secure Code.
                             "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"}) // Белкард.

    public void imageIsDisplayedTest (String xPath)
    {
        var image = driver.findElement(By.xpath(xPath));
        boolean actual = image.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @DisplayName("Работа ссылки \"Подробнее о сервисе\"")
    @Test
    public void aboutServiceLinkTest ()
    {
        var serviceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        serviceLink.click();
        String actual = driver.getTitle();
        String expected = "Порядок оплаты и безопасность интернет платежей";
        Assertions.assertEquals(expected, actual);

        driver.navigate().back();
    }

    @DisplayName("Работа кнопки \"Продолжить\"")
    @Test
    public void continueButtonTest ()
    {
        // Поле "Номер телефона".
        var PhoneNumber = driver.findElement(By.id("connection-phone"));
        PhoneNumber.sendKeys("297777777");

        // Поле "Сумма к оплате".
        var Payment = driver.findElement(By.id("connection-sum"));
        Payment.sendKeys("100");

        // Поле "E-mail".
        var EMail = driver.findElement(By.id("connection-email"));
        EMail.sendKeys("introvert919@mail.ru");

        // Кнопка "Продолжить".
        var buttonContinueParent = driver.findElement(By.id("pay-connection"));
        var buttonContinueChild = buttonContinueParent.findElement(By.tagName("button"));
        buttonContinueChild.click();

        // Окно для платежа.
        var iframe = driver.findElement(By.className("payment-widget-iframe"));
        driver.switchTo().frame(iframe);
        var paymentData = driver.findElement(By.className("pay-description__text"));

        String actual = paymentData.getText();
        String expected = "Оплата: Услуги связи Номер:375297777777";
        Assertions.assertEquals(expected, actual);
    }
}