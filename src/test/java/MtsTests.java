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

        WebElement Button = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        Button.click();
    }

    @BeforeEach
    void tearDown()
    {
        driver.navigate().refresh();

        var element = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]"));
        Actions a = new Actions(driver); a.moveToElement(element).perform();
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
        var headerText = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        String actual = headerText.getText();
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
        var serviceLink = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
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
        var PhoneNumber = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        PhoneNumber.sendKeys("297777777");

        // Поле "Сумма к оплате".
        var Payment = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        Payment.sendKeys("100");

        // Поле "E-mail".
        var EMail = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        EMail.sendKeys("introvert919@mail.ru");

        // Кнопка "Продолжить".
        var buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();

        // Окно для платежа.
        var iframe = driver.findElement(By.xpath("/html/body/div[9]/div/iframe"));
        driver.switchTo().frame(iframe);
        var PaymentWindow = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));

        String actual = PaymentWindow.getText();
        String expected = "Оплата: Услуги связи Номер:375297777777";
        Assertions.assertEquals(expected, actual);
    }
}