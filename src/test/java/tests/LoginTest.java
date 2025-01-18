package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import api.UserApi;
import api.UserDataLombok;
import api.UserGenerator;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import pageobject.ForgotPasswordPage;
import io.qameta.allure.Step;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private ConstructorPage constructorPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;
    private UserApi userApi;
    private UserDataLombok user;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        userApi = new UserApi();
        // Генерация случайного пользователя
        user = UserGenerator.getRandomUser();

        // Регистрация пользователя через API
        String requestBody = String.format("{\"email\":\"%s\",\"password\":\"%s\",\"name\":\"%s\"}",
                user.getEmail(), user.getPassword(), user.getName());
        userApi.registerUser(requestBody);

        // Инициализация страниц
//        driver.get(ConstructorPage.CONSTRUCTOR_PAGE_URL);
        constructorPage = new ConstructorPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(ConstructorPage.CONSTRUCTOR_PAGE_URL);
    }

    @Test
    @Step("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void loginFromMainPage() {
        constructorPage.goToAccount(); // Переход к форме входа
        // Залогинимся
        loginPage.login(user.getEmail(), user.getPassword());
        assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl()); // Проверка перехода на страницу конструктора
    }

    @Test
    @Step("Вход через кнопку «Личный кабинет» со страницы конструктора")
    public void loginFromProfileButton() {
        constructorPage.goToProfile();  // Переход к форме входа
        // Залогинимся
        loginPage.login(user.getEmail(), user.getPassword());
        assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl()); // Проверка перехода на страницу конструктора
    }

    @Test
    @Step("Вход через кнопку «Войти» в форме регистрации")
    public void loginFromRegistrationPage() {
        constructorPage.goToAccount(); // Переход к форме входа
        loginPage.goToRegister();  // Переход к форме регистрации
        registerPage.goToLogin(); // Переход на страницу логина
        // Залогинимся
        loginPage.login(user.getEmail(), user.getPassword());
        assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl()); // Проверка перехода на страницу конструктора
    }

    @Test
    @Step("Вход через кнопку «Войти» в форме восстановления пароля")
    public void loginFromForgotPasswordPage() {
        constructorPage.goToAccount(); // Переход к форме входа
        loginPage.goToForgotPassword(); // Переход на страницу восстановления пароля
        forgotPasswordPage.loginButtonClick(); // Клик по кнопке "Войти"

        assertEquals(LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl()); // Проверка перехода на страницу логина

        // Залогинимся
        loginPage.login(user.getEmail(), user.getPassword());

        assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl());// Проверяем, что открылась страница конструктора
    }

    @After
    public void tearDown() {
        userApi.deleteUser(user.getEmail()); // Удаление пользователя через API
        driver.quit(); // Закрытие драйвера
    }
}




