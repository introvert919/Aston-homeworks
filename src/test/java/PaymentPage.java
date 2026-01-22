import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
Перевести ранее написанный тест на использование паттерна PageObject и добавить следующие проверки:
Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
услуги связи, домашний интернет, рассрочка, задолженность;
Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
нажать кнопку «Продолжить» и в появившемся окне проверить корректность
отображения суммы (в том числе на кнопке), номера телефона, а также надписей
в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем. */

class PaymentPage {
    WebDriver driver;

    // Блок «Онлайн пополнение без комиссии».
    // Заголовок блока.
    By headerText = By.xpath("//h2[contains(text(),'Онлайн пополнение')]");

    // Ссылка подробнее о сервисе.
    By linkAboutService = By.linkText("Подробнее о сервисе");

    // Картинки платежных систем.
    By imageVisa = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']");
    By imageVerifiedByVisa = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg']");
    By imageMasterCard = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']");
    By imageMasterCardSecureCode = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg']");
    By imageBelcard = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']");

    // Вкладка "Услуги связи".
    By communicationServices = By.xpath("//button[@class='select__header']");
    By phoneNumberService = By.id("connection-phone"); // Поле "Номер телефона".
    By sumService = By.id("connection-sum"); // Поле "Сумма".
    By emailService = By.id("connection-email"); // Поле "E-mail".

    // Вкладка "Домашний интернет".
    By homeInternet = By.xpath("//p[text()='Домашний интернет']/parent::li");
    By phoneNumberInternet = By.id("internet-phone"); // Поле "Номер телефона".
    By sumInternet = By.id("internet-sum"); // Поле "Сумма".
    By emailInternet = By.id("internet-email"); // Поле "E-mail".

    // Вкладка "Рассрочка".
    By credit = By.xpath("//p[text()='Рассрочка']/parent::li"); // Вкладка "Рассрочка".
    By accountCredit = By.id("score-instalment"); // Поле "Номер счета".
    By sumCredit = By.id("instalment-sum"); // Поле "Сумма".
    By emailCredit = By.id("instalment-email"); // Поле "E-mail".

    // Вкладка "Задолжность".
    By debt = By.xpath("//p[text()='Задолженность']/parent::li"); // Вкладка "Задолжность".
    By accountDebt = By.id("score-arrears"); // Поле "Номер счета".
    By sumDebt = By.id("arrears-sum"); // Поле "Сумма".
    By emailDebt = By.id("arrears-email"); // Поле "E-mail".


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Старые тесты.
    // Текст заголовка блока.
    public String headerText() {
        return (driver.findElement(headerText).getText());
    }

    // Ссылка "Подробнее о сервисе".
    public String linkAboutService() {
        driver.findElement(linkAboutService).click();
        return (driver.getTitle());
    }

    // Картинки платежных систем.
    public boolean imageIsDisplayed(String imageName) {
        boolean result = false;

        switch (imageName) {
            case "Visa": {
                result = driver.findElement(imageVisa).isDisplayed();
                break;
            }
            case "Verified by Visa": {
                result = driver.findElement(imageVerifiedByVisa).isDisplayed();
                break;
            }
            case "MasterCard": {
                result = driver.findElement(imageMasterCard).isDisplayed();
                break;
            }
            case "MasterCard Secure Code": {
                result = driver.findElement(imageMasterCardSecureCode).isDisplayed();
                break;
            }
            case "Belcard": {
                result = driver.findElement(imageBelcard).isDisplayed();
                break;
            }
        }
        return result;
    }

    // Новые тесты.
    // Тексты полей разделов блока.
    public String tabText(String tab, String field) {
        String result ="";

        switch (tab) {
            case "Услуги связи": {
                switch (field) {
                    case "Номер телефона": {
                        result = driver.findElement(phoneNumberService).getAttribute("placeholder");
                        break;
                    }
                    case "Сумма": {
                        result = driver.findElement(sumService).getAttribute("placeholder");
                        break;
                    }
                    case "E-mail": {
                        result = driver.findElement(emailService).getAttribute("placeholder");
                        break;
                    }
                }
                break;
            }
            case "Домашний интернет": {
                driver.findElement(communicationServices).click();
                driver.findElement(homeInternet).click();

                switch (field) {
                    case "Номер абонента": {
                        result = driver.findElement(phoneNumberInternet).getAttribute("placeholder");
                        break;
                    }
                    case "Сумма": {
                        result = driver.findElement(sumInternet).getAttribute("placeholder");
                        break;
                    }
                    case "E-mail": {
                        result = driver.findElement(emailInternet).getAttribute("placeholder");
                        break;
                    }
                }
                break;
            }
            case "Рассрочка": {
                driver.findElement(communicationServices).click();
                driver.findElement(credit).click();

                switch (field) {
                    case "Номер счета": {
                        result = driver.findElement(accountCredit).getAttribute("placeholder");
                        break;
                    }
                    case "Сумма": {
                        result = driver.findElement(sumCredit).getAttribute("placeholder");
                        break;
                    }
                    case "E-mail": {
                        result = driver.findElement(emailCredit).getAttribute("placeholder");
                        break;
                    }
                }
                break;
            }
            case "Задолжность": {
                driver.findElement(communicationServices).click();
                driver.findElement(debt).click();

                switch (field) {
                    case "Номер счета": {
                        result = driver.findElement(accountDebt).getAttribute("placeholder");
                        break;
                    }
                    case "Сумма": {
                        result = driver.findElement(sumDebt).getAttribute("placeholder");
                        break;
                    }
                    case "E-mail": {
                        result = driver.findElement(emailDebt).getAttribute("placeholder");
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }
}










