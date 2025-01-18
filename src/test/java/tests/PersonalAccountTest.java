package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import io.qameta.allure.Step;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest {
    private WebDriver driver;
    private ConstructorPage constructorPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConstructorPage.CONSTRUCTOR_PAGE_URL); // Переход на страницу конструктора
        constructorPage = new ConstructorPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    @Step("Проверка перехода в личный кабинет через кнопку «Личный кабинет»")
    public void testGoToPersonalAccount() {
        constructorPage.goToProfile(); // Переход к форме входа

        assertEquals(LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl()); // Проверяем, что URL соответствует URL страницы входа
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

