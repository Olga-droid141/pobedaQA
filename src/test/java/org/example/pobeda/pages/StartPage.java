package org.example.pobeda.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v140.autofill.model.Address;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

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

    @FindBy(xpath = "//button[.='Поиск']")
    private WebElement searchBtn;

    @FindBy(xpath = "//input[@placeholder='Откуда' and @readonly]/following-sibling::*")
    private WebElement departureCityInput;

    @FindBy(xpath = "//input[@placeholder='Куда' and @readonly]/following-sibling::*")
    private WebElement arrivalCityInput;

    @FindBy(xpath = "(//input[@placeholder='Туда' and @readonly]/parent::div)[2]")
    //Их почему-то 2 и они абсолютно одинаковые, тольк id разные, но сгенеренные
    private WebElement departureDate;

    @FindBy(xpath = "(//input[@placeholder='Обратно' and @readonly])[2]")
    private WebElement arrivalDate;

    @FindBy(xpath = "//button/span[text()='Управление бронированием'][1]")
    private WebElement manageReservation;

    @FindBy(xpath = "//input[@placeholder='Фамилия клиента']")
    private WebElement inputMiddleName;

    @FindBy(xpath = "//input[@placeholder='Номер бронирования или билета']")
    private WebElement inputReservationNum;


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
        return new FindCityDialogWindow(driver).inputCity(cityName);
    }

    public StartPage chooseArrivalCity(String cityName) {
        arrivalCityInput.click();
        return new FindCityDialogWindow(driver).inputCity(cityName);
    }

    public StartPage checkTitle() {
        Assertions.assertTrue(title.isDisplayed());
        Assertions.assertFalse(logo.isEmpty());
        return this;
    }

    public StartPage checkInfoContent() {
        Actions action = new Actions(driver);
        action.moveToElement(information).perform();
        Assertions.assertTrue(gettingReadyToFlight.isDisplayed());
        Assertions.assertTrue(usefulInfo.isDisplayed());
        Assertions.assertTrue(aboutCompany.isDisplayed());
        return this;
    }

    public StartPage checkSearchArea() {
        new Actions(driver).scrollToElement(departureCityInput);
        Assertions.assertTrue(departureCityInput.isDisplayed());
        Assertions.assertTrue(arrivalCityInput.isDisplayed());
        Assertions.assertTrue(departureDate.isDisplayed());
        Assertions.assertTrue(arrivalDate.isDisplayed());
        return this;
    }

    public StartPage submitAndError() {
        searchBtn.click();
        Assertions.assertEquals("true", departureDate.getAttribute("data-failed"));
        return this;
    }

    public StartPage checkReservationSection() {
        new Actions(driver).scrollToElement(manageReservation).perform();
        manageReservation.click();
        Assertions.assertTrue(inputMiddleName.isDisplayed());
        Assertions.assertTrue(inputReservationNum.isDisplayed());
        return this;
    }

    public void findReservation(String middleName, String number) {
        inputMiddleName.sendKeys(middleName);
        inputReservationNum.sendKeys(number);
        searchBtn.click();
    }
}
