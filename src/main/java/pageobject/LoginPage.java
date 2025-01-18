package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    private By stringEmailInput = By.xpath(".//input[@type='text']"); // строка ввода Email
    private By stringPasswordInput = By.xpath(".//input[@type='password']"); // строка ввода пароля
    private By loginButton = By.xpath(".//button[contains(@class, 'button_button__33qZ0')]"); // кнопка Войти
    private By registerButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']"); // кнопка зарегистрироваться
    private By  forgotPasswordButton = By.xpath(".//a[@class='Auth_link__1fOlj' and@href='/forgot-password']"); // кнопка восстановления пароля
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        driver.findElement(stringEmailInput).sendKeys(email);
        driver.findElement(stringPasswordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
// регистрация
    public void goToRegister() {
        driver.findElement(registerButton).click();
    }

    public void goToForgotPassword() {
        driver.findElement(forgotPasswordButton).click();
    }
}
