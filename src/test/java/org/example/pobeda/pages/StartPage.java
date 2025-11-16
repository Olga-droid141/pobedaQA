package org.example.pobeda.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class StartPage {

    private WebDriver driver;

    @FindBy(css = "a > img[src*='logo']")
    private List<WebElement> logo;

    @FindBy(xpath = "//h2[text()='Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы']")
    private WebElement title;

    @FindBy(xpath = "//a[@href='/information']")
    private WebElement information;

    @FindBy(css = "//a[text()='Подготовка к полёту']")
    private WebElement gettingReadyToFlight;

    @FindBy(css = "//a[text()='Полезная информация']")
    private WebElement usefulInfo;

    @FindBy(css = "//a[text()='О компании']")
    private WebElement aboutCompany;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public StartPage openPage() {
        driver.get("https://www.flypobeda.ru/");
        return this;
    }

    public StartPage checkTitle() {
        Assertions.assertTrue(title.isDisplayed());
        Assertions.assertFalse(logo.isEmpty());
        return this;
    }

    public void checkInfoContent() {
        Actions action = new Actions(driver);
        action.moveToElement(information).perform();
        Assertions.assertTrue(gettingReadyToFlight.isDisplayed());
        Assertions.assertTrue(usefulInfo.isDisplayed());
        Assertions.assertTrue(aboutCompany.isDisplayed());
    }
}
