package org.example.pobeda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {

    private final String URL = "https://www.flypobeda.ru/";

    private final long elementTimeOut = 3L;

    private final SelenideElement logo = $(By.cssSelector("a > img[src*='logo']"));

    private final SelenideElement title = $(By.xpath("//h2[text()='Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы']"));

    private final SelenideElement information = $(By.xpath("//a[@href='/information']"));

    private final SelenideElement gettingReadyToFlight = $(By.xpath("//a[text()='Подготовка к полёту']"));

    private final SelenideElement usefulInfo = $(By.xpath("//a[text()='Полезная информация']"));

    private final SelenideElement aboutCompany = $(By.xpath("//a[text()='О компании']"));

    private final SelenideElement searchBtn = $(By.xpath("//button[.='Поиск']"));

    private final SelenideElement departureCityInput = $(By.xpath("//input[@placeholder='Откуда' and @readonly]/following-sibling::*"));

    private final SelenideElement arrivalCityInput = $(By.xpath("//input[@placeholder='Куда' and @readonly]/following-sibling::*"));

    private final SelenideElement departureDate = $(By.xpath("(//input[@placeholder='Туда' and @readonly]/parent::div)[2]"));

    private final SelenideElement arrivalDate = $(By.xpath("(//input[@placeholder='Обратно' and @readonly])[2]"));

    private final SelenideElement manageReservation = $(By.xpath( "//button/span[text()='Управление бронированием'][1]"));

    private final SelenideElement inputMiddleName = $(By.xpath("//input[@placeholder='Фамилия клиента']"));

    private final SelenideElement inputReservationNum = $(By.xpath("//input[@placeholder='Номер бронирования или билета']"));


    public StartPage openPage() {
        Selenide.open(URL);
        return this;
    }

    public StartPage chooseDepartureCity(String cityName) {
        departureCityInput.hover().click();
        return new FindCityDialogWindow().inputCity(cityName);
    }

    public StartPage chooseArrivalCity(String cityName) {
        arrivalCityInput.click();
        return new FindCityDialogWindow().inputCity(cityName);
    }

    public StartPage checkTitle() {
        title.shouldBe(Condition.visible);
        logo.shouldBe(Condition.visible);
        return this;
    }

    public StartPage checkInfoContent() {
        information.hover();
        gettingReadyToFlight.shouldBe(Condition.visible, Duration.ofSeconds(elementTimeOut));
        usefulInfo.shouldBe(Condition.visible, Duration.ofSeconds(elementTimeOut));
        aboutCompany.shouldBe(Condition.visible);
        return this;
    }

    public StartPage checkSearchArea() {
        departureCityInput.scrollTo();
        departureCityInput.shouldBe(Condition.visible);
        arrivalCityInput.shouldBe(Condition.visible);
        departureDate.shouldBe(Condition.visible);
        arrivalDate.shouldBe(Condition.visible);
        return this;
    }

    public void submitAndError() {
        searchBtn.click();
        departureDate.shouldBe(Condition.attribute("data-failed", "true"));
    }

    public StartPage checkReservationSection() {
        manageReservation.scrollTo().click();
        inputMiddleName.shouldBe(Condition.visible);
        inputReservationNum.shouldBe(Condition.visible);
        return this;
    }

    public void findReservation(String middleName, String number) {
        inputMiddleName.setValue(middleName);
        inputReservationNum.sendKeys(number);
        searchBtn.click();
    }
}
