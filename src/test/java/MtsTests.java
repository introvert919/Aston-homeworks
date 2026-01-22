import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class MtsTests {

    static WebDriver driver;
    PaymentPage objPaymentPage;
    PaymentIFramePage objPaymentIFramePage;

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

    // Старые тесты.
    @DisplayName("Заголовок блока \"Онлайн пополнение без комиссии\"")
    @Test
    public void headerTextTest()
    {
        objPaymentPage = new PaymentPage(driver);
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", objPaymentPage.headerText());
    }

    @DisplayName("Ссылка \"Подробнее о сервисе\"")
    @Test
    public void linkAboutServiceTest()
    {
        objPaymentPage = new PaymentPage(driver);
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", objPaymentPage.linkAboutService());
        driver.navigate().back();
    }

    @DisplayName("Картинки в блоке \"Онлайн пополнение без комиссии\"")
    @ParameterizedTest
    @ValueSource(strings = {"Visa", "Verified by Visa", "MasterCard", "MasterCard Secure Code", "Belcard"})
    public void imageTest(String imageName)
    {
        objPaymentPage = new PaymentPage(driver);
        Assertions.assertTrue(objPaymentPage.imageIsDisplayed(imageName));
    }

    // Новые тесты.
    @DisplayName("Тексты вкладкок блока \"Онлайн пополнение без комиссии\"")
    @ParameterizedTest
    @CsvSource({"Услуги связи, Номер телефона, Номер телефона",
                "Услуги связи, Сумма, Сумма",
                "Услуги связи, E-mail, E-mail для отправки чека",
                "Домашний интернет, Номер абонента, Номер абонента",
                "Домашний интернет, Сумма, Сумма",
                "Домашний интернет, E-mail, E-mail для отправки чека",
                "Рассрочка, Номер счета, Номер счета на 44",
                "Рассрочка, Сумма, Сумма",
                "Рассрочка, E-mail, E-mail для отправки чека",
                "Задолжность, Номер счета, Номер счета на 2073",
                "Задолжность, Сумма, Сумма",
                "Задолжность, E-mail, E-mail для отправки чека",
    })
    public void tabTextTest(String tab, String field, String expected)
    {
        objPaymentPage = new PaymentPage(driver);
        Assertions.assertEquals(expected, objPaymentPage.tabText(tab, field));
    }

    @DisplayName("Текст суммы оплаты в заголовке окна оплаты")
    @Test
    public void payValueHeaderTextTest()
    {
        objPaymentIFramePage = new PaymentIFramePage(driver);
        objPaymentIFramePage.paymentComunicationServices("297777777", "100", "introvert919@mail.ru");
        Assertions.assertEquals("100.00 BYN", objPaymentIFramePage.payValueHeaderText());
    }

    @DisplayName("Текст суммы на кнопке")
    @Test
    public void payValueButtonTextTest()
    {
        objPaymentIFramePage = new PaymentIFramePage(driver);
        objPaymentIFramePage.paymentComunicationServices("297777777", "100", "introvert919@mail.ru");
        Assertions.assertEquals("Оплатить 100.00 BYN", objPaymentIFramePage.payValueButtonText());
    }

    @DisplayName("Номер телефона")
    @Test
    public void phoneNumberTextTest()
    {
        objPaymentIFramePage = new PaymentIFramePage(driver);
        objPaymentIFramePage.paymentComunicationServices("297777777", "100", "introvert919@mail.ru");
        Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777", objPaymentIFramePage.phoneNumberText());
    }

    @DisplayName("Текст в полях формы")
    @ParameterizedTest
    @CsvSource ({"Номер карты, Номер карты",
                 "Срок действия, Срок действия",
                 "Имя и фамилия на карте, Имя и фамилия на карте",
                 "CVC, CVC"})
    public void fieldTextTextTest(String field, String expected)
    {
        objPaymentIFramePage = new PaymentIFramePage(driver);
        objPaymentIFramePage.paymentComunicationServices("297777777", "100", "introvert919@mail.ru");
        Assertions.assertEquals(expected, objPaymentIFramePage.fieldText(field));
    }

    @DisplayName("Картинки способов оплаты")
    @ParameterizedTest
    @ValueSource (strings = {"Visa", "MasterCard","Белкард", "Мир"})
    public void imageIsDisplayedTest(String cardName)
    {
        objPaymentIFramePage = new PaymentIFramePage(driver);
        objPaymentIFramePage.paymentComunicationServices("297777777", "100", "introvert919@mail.ru");
        Assertions.assertTrue(objPaymentIFramePage.imageIsDisplayed(cardName));
    }
}