package org.example.pobeda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[.='Поиск']")
    private WebElement searchBtn;

    @FindBy(xpath = "//input[@placeholder='Откуда' and @readonly]/following-sibling::*")
    private WebElement departureCityInput;

    @FindBy(xpath = "//input[@placeholder='Куда' and @readonly]/following-sibling::*")
    private WebElement arrivalCityInput;

    @FindBy(css = "*:has(> input[placeholder='Туда']) > div > svg")
    private WebElement departureDate;


    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public StartPage openPage() {
        driver.get("https://www.flypobeda.ru/");
        return this;
    }

    public StartPage chooseDepartureCity(String cityName) {
        departureCityInput.click();
        return new FindCityDialogWindow(driver).inputCity(cityName).close();
    }

    public StartPage chooseArrivalCity(String cityName) {
        arrivalCityInput.click();
        return new FindCityDialogWindow(driver).inputCity(cityName).close();
    }

    public StartPage chooseDate() {
        departureDate.click();
        return new CalendarDialogWindow(driver).chooseFirstAvailableDate()
                .clickDontNeedReturnTicket();
    }

    public SearchResaltPage next() {
        searchBtn.click();
        return new SearchResaltPage(driver);
    }
}
