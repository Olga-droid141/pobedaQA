package org.example.pobeda.test;

import org.example.pobeda.pages.StartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PobedaTest {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void testCase() {
        new StartPage(driver).openPage()
                .checkTitle()
                .checkInfoContent()
                .checkSearchArea()
                .chooseDepartureCity("Москва")
                .chooseArrivalCity("Санкт-Петербург")
                .submitAndError();
    }
}
