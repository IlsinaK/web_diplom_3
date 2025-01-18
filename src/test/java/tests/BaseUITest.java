//package tests;
//
//import org.example.browser.Browser;
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.WebDriver;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//public class BaseUITest {
//
//    protected WebDriver driver;
//
//    @Before
//    public void startUp() throws IOException {
//        driver = Browser.initDriver(); // Инициализация драйвера
//        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); // Установка таймаута
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit(); // Закрытие драйвера
//        }
//    }
//}


