
package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordPage {
    private WebDriver driver;

    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private By loginButton = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/login']"); // Кнопка "Войти" внизу страницы



    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ForgotPasswordPage openForgotPasswordPage(){
        driver.get(FORGOT_PASSWORD_PAGE_URL);
        return this;
        }

    public void loginButtonClick() {
//        WebDriverWait wait = new WebDriverWait(driver, 5, TimeUnit.SECONDS.ordinal());
        driver.findElement(loginButton).click();
    }
}