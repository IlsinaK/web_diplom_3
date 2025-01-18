package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    public By constructorButton = By.xpath(".//p[contains(@class,'AppHeader_header') and text()= 'Конструктор'])]"); // кнопка Конструктор
    public By logoStellarBurgersButton = By.xpath(".//div[contains(@class, 'AppHeader_header__logo__2D0X2')])"); // кнопка логотипа Stellar Burgers
    private By exitButton = By.xpath(".//button[contains(@class, 'Account_button__14Yp3')]"); // кнопка выход
    private By profileButton = By.xpath(".//li[contains(@class, 'Account_listItem__35dAP')]//a[text()='Профиль']"); // кнопка Профиль
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static boolean profileButton() {
        return true;
    }

    //выход из аккаунта
    public void logout() {
        driver.findElement(exitButton).click();
    }
//переход через нажатие на Конструктор
    public void goToConstructor() {
        driver.findElement(constructorButton).click();
    }
//переход через нажатие на лого
    public void clickLogo() {
        driver.findElement(logoStellarBurgersButton).click();
    }
}



