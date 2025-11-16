package org.example.pobeda.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservationPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::span")
    private WebElement agreeCheckbox;

    @FindBy(css = "button.btn_search")
    private WebElement searchBtn;

    @FindBy(xpath = "//div[text()='Заказ с указанными параметрами не найден']")
    private WebElement errorMsg;

    public ReservationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ReservationPage openPage() {
        String original = driver.getWindowHandle();
        for (String handle: driver.getWindowHandles()) {
            if (!handle.equals(original)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return this;
    }

    public void checkErrorMsg() {
        agreeCheckbox.click();
        searchBtn.click();
        Assertions.assertTrue(errorMsg.isDisplayed());
    }
}
