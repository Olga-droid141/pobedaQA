package org.example.pobeda.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FindCityDialogWindow {


    private final SelenideElement cityInputFld = $(By.xpath("//input[@placeholder='Поиск']"));


    public StartPage inputCity(String cityName) {
        cityInputFld.setValue(cityName).pressEnter();
        return new StartPage();
    }
}
