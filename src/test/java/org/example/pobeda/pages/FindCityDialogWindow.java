package org.example.pobeda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindCityDialogWindow {

    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement cityInputFld;

    @FindBy(css = "button[class$='closeBtn']")
    private WebElement closeBtn;

    @FindBy(xpath = "(//div[contains(@class,'suggestionName')])[1]")
    private WebElement foundCity;

    public FindCityDialogWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FindCityDialogWindow inputCity(String cityName) {
        cityInputFld.sendKeys(cityName);
        foundCity.click();
        return this;
    }

    public StartPage close() {
        closeBtn.click();
        return new StartPage(driver);
    }
}
