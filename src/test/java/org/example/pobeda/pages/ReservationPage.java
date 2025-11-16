package org.example.pobeda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ReservationPage {

    
    private final SelenideElement agreeCheckbox = $(By.xpath("//input[@type='checkbox']/following-sibling::span"));

    private final SelenideElement searchBtn = $("button.btn_search");

    private final SelenideElement errorMsg = $(By.xpath("//div[text()='Заказ с указанными параметрами не найден']"));


    public ReservationPage openPage() {
        String original = Selenide.webdriver().driver().getWebDriver().getWindowHandle();
        for (String handle: Selenide.webdriver().driver().getWebDriver().getWindowHandles()) {
            if (!handle.equals(original)) {
                Selenide.switchTo().window(handle);
                break;
            }
        }
        return this;
    }

    public void checkErrorMsg() {
        agreeCheckbox.click();
        searchBtn.click();
        errorMsg.shouldBe(Condition.visible);
    }
}
