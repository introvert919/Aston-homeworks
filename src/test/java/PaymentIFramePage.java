import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentIFramePage
{
    WebDriver driver;

    // Переключение на окно платежа.
    By phoneNumberService = By.id("connection-phone"); // Поле "Номер телефона".
    By sumService = By.id("connection-sum"); // Поле "Сумма".
    By emailService = By.id("connection-email"); // Поле "E-mail".
    By continueButton = By.xpath("//form[@id='pay-connection']/child::button"); // Кнопка продолжить.
    By iframe = By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']"); // Поиск фрейма.

    // Тесты.
    // Тексты.
    By payValueText = By.xpath("//div[@class='pay-description__cost']/child::span"); // Текст суммы оплаты в заголовке.
    By phoneNumber = By.xpath("//span[contains(text(),'Оплата: Услуги связи')]"); // Текст в поле "Номер телефона".
    By cardNumberText = By.xpath("//label[text()='Номер карты']"); // Текст в поле "Номер карты".
    By validityPeriod = By.xpath("//label[text()='Имя и фамилия на карте']"); // Текст в поле "Срок действия карты".
    By nameAndSurnameOnCard = By.xpath("//label[text()='Срок действия']"); // Текст в поле "Имя и фомилия".
    By cvc = By.xpath("//label[text()='CVC']"); // Текст в поле CVS.

    // Картинки платежных систем.
    By imageVisa = By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"); // Картинка Visa.
    By imageMasterCard = By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"); // Картинка Мастер кард.
    By imageBelcard = By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"); // Картинка Белкард.
    By imageMir = By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']"); // Картинка Мир.

    // Текст суммы оплаты на кнопке.
    By payValueOnButtonCardNumber = By.xpath("//input[@id='cc-number']"); // Поле "Номер карты".
    By payValueOnButtonValidityPeriod = By.xpath("//input[@autocomplete='cc-exp']"); // Поле "Период действия карты".
    By payValueOnButtonNameAndSurname = By.xpath("//input[@autocomplete='cc-name']"); // Поле "Имя и фамилия как на карте".
    By payValueOnButtonCVC = By.xpath("//input[@autocomplete='cc-csc']"); // Поле "CVC".
    By payValueOnButton = By.xpath("//span[text()=' Оплатить  100.00 BYN ']"); // Текст на кнопе оплаты.

    public PaymentIFramePage(WebDriver driver) {
        this.driver = driver;
    }

    // Переключение на окно платежа.
    public void paymentComunicationServices(String phoneNumber, String sum, String email)
    {
        driver.findElement(phoneNumberService).sendKeys(phoneNumber);
        driver.findElement(sumService).sendKeys(sum);
        driver.findElement(emailService).sendKeys(email);
        driver.findElement(continueButton).click();

        var paymentFrame = driver.findElement(iframe);
        driver.switchTo().frame(paymentFrame);
    }

    // Текст сумма оплаты в заголовке окна оплаты.
    public String payValueHeaderText()
    {
        return (driver.findElement(payValueText).getText());
    }

    // Текст суммы на кнопке.
    public String payValueButtonText()
    {
        driver.findElement(payValueOnButtonCardNumber).sendKeys("2200701786166949");
        driver.findElement(payValueOnButtonValidityPeriod).sendKeys("1227");
        driver.findElement(payValueOnButtonNameAndSurname).sendKeys("Ivan Ivanov");
        driver.findElement(payValueOnButtonCVC).sendKeys("111");
        return (driver.findElement(payValueOnButton).getText());
    }

    // Номер телефона на странице оплаты.
    public String phoneNumberText()
    {
        return (driver.findElement(phoneNumber).getText());
    }

    // Текст полей страницы оплаты.
    public String fieldText(String field)
    {
        String result = "";

        switch (field) {
            case "Номер карты": {
                result = driver.findElement(cardNumberText).getText();
                break;
            }
            case "Срок действия": {
                result = driver.findElement(validityPeriod).getText();
                break;
            }
            case "Имя и фамилия на карте": {
                result = driver.findElement(nameAndSurnameOnCard).getText();
                break;
            }
            case "CVC": {
                result = driver.findElement(cvc).getText();
                break;
            }
        }
        return (result);
    }

    // Иконки платежных систем на странице оплаты.
    public boolean imageIsDisplayed(String field)
    {
        boolean result = false;

        switch (field) {
            case "Visa": {
                result = driver.findElement(imageVisa).isDisplayed();
                break;
            }
            case "MasterCard": {
                result = driver.findElement(imageMasterCard).isDisplayed();
                break;
            }
            case "Белкард": {
                result = driver.findElement(imageBelcard).isDisplayed();
                break;
            }
            case "Мир": {
                result = driver.findElement(imageMir).isDisplayed();
                break;
            }
        }
        return (result);
    }
}
