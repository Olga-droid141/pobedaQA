package org.example.pobeda.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindCityDialogWindow {

    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement cityInputFld;

    public FindCityDialogWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public StartPage inputCity(String cityName) {
        cityInputFld.sendKeys(cityName);
        new Actions(driver).sendKeys(Keys.ENTER);
        return new StartPage(driver);
    }
}
