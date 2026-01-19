import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class PaymentsPageObject
{
    protected WebDriver driver;

    // Вкладка "Услуги связи".
    private By service = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    // Вкладка "Домашний интернет"
    private By homeInternet = By.xpath("password");
    // Вкладка "Рассрочка"
    private By credit = By.xpath("sign_in");
    // Вкладка "Задолжность"
    private By debt = By.xpath("sign_in");


    public SignInPage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().equals("Sign In Page")) {
            throw new IllegalStateException("This is not Sign In Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }


}





