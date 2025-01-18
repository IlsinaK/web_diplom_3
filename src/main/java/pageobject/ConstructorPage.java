package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

import java.util.concurrent.TimeUnit;

public class ConstructorPage {
    public HTMLInputElement goToProfile;
    private WebDriver driver;
    public static final String CONSTRUCTOR_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    // Элементы на странице конструктора
    public By signAccountButton = By.xpath(".//button[contains(@class, 'button__33qZ0')]");  // кнопка входа в аккаунт
    public By personalAccountButton = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and@href='/account']"); // кнопка входа в личный кабинет
    private By sectionBun = By.xpath("//div[@class='tab_tab__1SPyG']//span[text()='Булки']"); // раздел Булки
    private By sectionSauces = By.xpath("//div[@class='tab_tab__1SPyG']//span[text()='Соусы']"); // раздел Соусы
    private By sectionToppings = By.xpath("//div[@class='tab_tab__1SPyG']//span[text()='Начинки']"); // раздел Начинки
    private By activeSectionBun = By.xpath(".//div[contains(@class, 'current')]//span[text()='Булки']"); // строка Булки
    private By activeSectionSauces = By.xpath(".//div[contains(@class, 'current')]//span[text()='Соусы']"); // строка Соусы
    private By activeSectionToppings = By.xpath(".//div[contains(@class, 'current')]//span[text()='Начинки']"); // строка Начинки

    public ConstructorPage(WebDriver driver) {
        this.driver= driver;
    }
    public ConstructorPage(){

    }
public ConstructorPage openConstructorPage(){
        driver.get(CONSTRUCTOR_PAGE_URL);
        return this;
}

    // Метод для перехода в личный кабинет
    public void goToProfile() {
        driver.findElement(personalAccountButton).click();
    }
    public void goToAccount() {
        driver.findElement(signAccountButton).click();
    }

    // Выбор раздела булки
    public void selectBuns() {
        driver.findElement(sectionBun).click();
    }

    // Выбор раздела соусы
    public void selectSauces() {
        driver.findElement(sectionSauces).click();
    }

    // Выбор раздела начинки
    public void selectToppings() {
        driver.findElement(sectionToppings).click();
    }


    public boolean isActiveSectionBun() {
        // Логика для проверки, что булки активны
        return driver.findElement(activeSectionBun).isDisplayed(); // предполагаем, что элемент с id "activeSectionBun" появляется, когда раздел активен
    }

    public boolean isActiveSectionSauces() {
        // Логика для проверки, что соусы активны
        return driver.findElement(activeSectionSauces).isDisplayed(); // предполагаем, что элемент с id "activeSectionSauces" появляется, когда раздел активен
    }

    public boolean isActiveSectionToppings() {
        // Логика для проверки, что начинки активны
        return driver.findElement(activeSectionToppings).isDisplayed(); // предполагаем, что элемент с id "activeSectionToppings" появляется, когда раздел активен
    }
}

