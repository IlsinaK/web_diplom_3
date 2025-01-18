package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    private WebDriver driver;

    // Элементы для страницы регистрации
    private By stringNameInput = By.xpath(".//input[@name='name' and preceding-sibling::label[text()='Имя']]"); // строка ввода Имя
    private By stringEmailInput = By.xpath(".//input[@name='name' and preceding-sibling::label[text()='Email']]"); // строка ввода Email
    private By stringPasswordInput = By.xpath(".//input[@type='password']"); // строка ввода пароль
    public By registerButton = By.xpath(".//button[contains(@class, 'button_button__33qZ0')]"); // кнопка зарегистрироваться
    private By loginButton = By.xpath(".//a[contains(@class, 'Auth_link')]"); // кнопка Войти
    private By incorrectPasswordText = By.xpath(".//p[contains(@class, 'input__error')]"); // Некорректный пароль текст
    private By redBorder = By.xpath(".//div[contains(@class, 'input_status_error')]"); // выделение поля пароль красным

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Метод для регистрации
    public void goRegister(String name, String email, String password) {
        driver.findElement(stringNameInput).sendKeys(name);
        driver.findElement(stringEmailInput).sendKeys(email);
        driver.findElement(stringPasswordInput).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    // Получение сообщения об ошибке
    public boolean getErrorMessage() {
        return driver.findElement(incorrectPasswordText).isDisplayed();
    }

    // Проверка наличия красной рамки вокруг поля пароля
    public boolean hasRedBorder() {
        return driver.findElement(redBorder).isDisplayed();
    }

    public void clearPasswordField() {
        driver.findElement(stringPasswordInput).clear(); // Очистить поле пароля
    }

    public void passwordInput(String password) {
        clearPasswordField(); // Сначала очищаем поле
        if (password != null) {
            driver.findElement(stringPasswordInput).sendKeys(password); // Вводим пароль
        }
    }


    // Переход на страницу регистрации
    public void goToRegister() {
        driver.get(REGISTER_PAGE_URL);
    }

    // Переход на страницу входа
    public void goToLogin() {
        driver.findElement(loginButton).click();
    }
    public void goRegister() {
        driver.findElement(registerButton).click();
    }
}




