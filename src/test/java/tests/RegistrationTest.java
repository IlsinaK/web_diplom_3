package tests;

import api.UserApi;
import api.UserDataLombok;
import api.UserGenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobject.ConstructorPage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import pageobject.RegisterPage;

import io.qameta.allure.Step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pageobject.ConstructorPage.CONSTRUCTOR_PAGE_URL;

public class RegistrationTest {
    private WebDriver driver;
    private ConstructorPage constructorPage;
    private LoginPage loginPage;
    private RegisterPage registrationPage;
    private UserApi userApi;
    private UserDataLombok user;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(CONSTRUCTOR_PAGE_URL);

        // Открытие страницы конструктора и переход на страницу регистрации
        constructorPage = new ConstructorPage(driver);
        constructorPage.goToProfile(); // Переход на страницу логина
        loginPage = new LoginPage(driver);
        loginPage.goToRegister(); // Переход на страницу регистрации
        registrationPage = new RegisterPage(driver);

        userApi = new UserApi();
        user = UserGenerator.getRandomUser(); // Генерация случайного пользователя
    }

    @Test
    @Step("Проверка успешной регистрации")
    public void successfulRegistration() {
        registrationPage.goRegister("Анна", "anna@mail.ru", "anna1234"); // Регистрация
        assertEquals(LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl()); // Проверка, что открыта страница логина

        // Вход после регистрации
        loginPage.login("anna@mail.ru", "anna1234");
        assertEquals(CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl()); // Проверка, что открыта страница конструктора

        // Переход на профиль
        constructorPage.goToProfile();
        assertTrue(ProfilePage.profileButton()); // Проверка наличия кнопки "Профиль"
    }

    @Test
    @Step("Проверка ошибки для некорректного пароля")
    public void errorForInvalidPassword() {
        registrationPage.goRegister("Анна", "anna@mail.ru", "12345"); // Пароль меньше 6 символов
        assertTrue(registrationPage.getErrorMessage()); // Проверка наличия сообщения об ошибке
        assertTrue(registrationPage.hasRedBorder());

        // Проверка для каждого некорректного пароля
        String[] invalidPasswords = {"1234", "12", "1", null}; // Разные некорректные пароли
        for (String password : invalidPasswords) {
            registrationPage.clearPasswordField(); // Очистка поля пароля
            if (password != null) {
                registrationPage.passwordInput(password); // Ввод некорректного пароля
            }
            registrationPage.goRegister(); // Нажимаем кнопку регистрации
            assertTrue(registrationPage.getErrorMessage()); // Проверка ошибки
            assertTrue(registrationPage.hasRedBorder());
        }
    }

    @After
    public void tearDown() {
        userApi.deleteUser(user.getEmail()); // Удаление созданного пользователя через API
        driver.quit(); // Закрытие драйвера
    }
}

