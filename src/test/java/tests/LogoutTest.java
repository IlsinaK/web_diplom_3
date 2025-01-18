package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import io.qameta.allure.Step;

import static org.junit.Assert.assertEquals;

public class LogoutTest {
    private WebDriver driver;
    private ConstructorPage constructorPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        constructorPage = new ConstructorPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    @Step("Тест выхода из аккаунта")
    public void testLogout() {
        // Открываем страницу конструктора
        ConstructorPage constructorPage = new ConstructorPage(driver);
        driver.get(ConstructorPage.CONSTRUCTOR_PAGE_URL);

        constructorPage.goToAccount();// Нажимаем кнопку "Войти в аккаунт" и переходим на LoginPage

        // Вводим данные для входа и нажимаем "Войти"
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ilsina156@list.ru", "123456789");

        assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl()); // Проверяем, что открылась страница конструктора
        constructorPage.goToProfile();  // Нажимаем на кнопку "Личный кабинет" и переходим на ProfilePage
        ProfilePage profilePage = new ProfilePage(driver);// Проверяем, что мы находимся на странице профиля
        assertEquals(ProfilePage.PROFILE_PAGE_URL, driver.getCurrentUrl());
        profilePage.logout();// Нажимаем кнопку "Выход"
        assertEquals(LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());// Проверяем, что открылась страница входа
    }


    @After
    public void tearDown() {
        driver.quit(); // Закрытие драйвера
    }
}
