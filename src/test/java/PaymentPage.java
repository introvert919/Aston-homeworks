import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Необходимо взять тест из практического задания в теме “Selenium. Часть 2”
и добавить Allure-репорт. После прогона теста необходимо открыть отчет
и выслать скриншот вместе с решением задания.  */

class PaymentPage {
    WebDriver driver;

    // Картинки платежных систем.
    By imageVisa = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']");
    By imageVerifiedByVisa = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg']");
    By imageMasterCard = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']");
    By imageMasterCardSecureCode = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg']");
    By imageBelcard = By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']");


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
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
}