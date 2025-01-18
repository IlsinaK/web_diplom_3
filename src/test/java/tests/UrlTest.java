package tests;

import org.junit.Test;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.codeborne.selenide.Selenide.open;
import static pageobject.ConstructorPage.CONSTRUCTOR_PAGE_URL;

public class UrlTest {
    @Test
    public void urlTest() {

        open (CONSTRUCTOR_PAGE_URL);

        System.out.println("url = " + url());
    }
}

