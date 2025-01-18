package org.example.browser;

import com.codeborne.selenide.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Browser {

    public static void initDriver() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/browser.properties"));

        String browserProperty = properties.getProperty("testBrowser");
        System.out.println("Test Browser: " + browserProperty); // Отладочный вывод

        BrowserType browserType = BrowserType.valueOf(browserProperty);
        switch (browserType) {
            case CHROME:
                Configuration.browser = "chrome";
                break;
            case YANDEX:
                Configuration.browser = "yandex";
                break;
            default:
                throw new RuntimeException("Browser undefined");
        }

        String baseUrl = properties.getProperty("selenide.url");
        if (baseUrl != null) {
            Configuration.baseUrl = baseUrl;
        }
    }
}




