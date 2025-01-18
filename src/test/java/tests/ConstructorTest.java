package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.ConstructorPage;
import tests.selenidetest.BaseUITest;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static pageobject.ConstructorPage.CONSTRUCTOR_PAGE_URL;

public class ConstructorTest extends BaseUITest {
    private ConstructorPage constructorPage;

    @Before
    public void setUp() {
        open(CONSTRUCTOR_PAGE_URL, ConstructorPage.class);
        constructorPage = new ConstructorPage();
    }

    @Test
    @Step("Проверка выбора раздела Булки")
    public void selectBunsTest() {
        constructorPage.selectBuns(); // Выбор раздела булки
        assertTrue(constructorPage.isActiveSectionBun()); // Проверка, что раздел активен
    }

    @Test
    @Step("Проверка выбора раздела Соусы")
    public void selectSaucesTest() {
        constructorPage.selectSauces(); // Выбор раздела соусы
        assertTrue(constructorPage.isActiveSectionSauces()); // Проверка, что раздел активен
    }

    @Test
    @Step("Проверка выбора раздела Начинки")
    public void selectToppingsTest() {
        constructorPage.selectToppings(); // Выбор раздела начинки
        assertTrue(constructorPage.isActiveSectionToppings()); // Проверка, что раздел активен
    }

    @After
    public void tearDown() {
        closeWebDriver(); // Закрываем браузер
    }
}


