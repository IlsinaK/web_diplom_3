package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ProfilePage;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import io.qameta.allure.Step;

import static org.junit.Assert.assertEquals;


public class ProfileNavigationTest {
    private WebDriver driver;
    private ProfilePage profilePage;
    private ConstructorPage constructorPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Открытие страницы конструктора
        constructorPage = new ConstructorPage(driver);
        driver.get(ConstructorPage.CONSTRUCTOR_PAGE_URL);

        loginPage = new LoginPage(driver);
        constructorPage.goToAccount(); // Переход на страницу логина
        loginPage.login("ilsina12@list.ru", "123456789"); // Вводим email и пароль

        // Проверяем, что открылась страница конструктора
        assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl());

        // Переход на страницу профиля
        constructorPage.goToProfile(); // Переход к личному кабинету
        profilePage = new ProfilePage(driver); // Инициализация страницы профиля
    }

    @Test
    @Step("Проверка перехода из личного кабинета в конструктор через кнопку «Конструктор»")
    public void testGoToConstructorFromProfile() {
        profilePage.goToConstructor(); // Переход в конструктор
        assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl()); // Проверка URL
    }

    @Test
    @Step("Проверка перехода из личного кабинета в конструктор через логотип Stellar Burgers")
    public void testGoToConstructorFromLogo() {
        profilePage.clickLogo(); // Клик на логотип
        assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl()); // Проверка URL
    }

    @After
    public void tearDown() {
        driver.quit(); // Закрытие драйвера
    }
}


