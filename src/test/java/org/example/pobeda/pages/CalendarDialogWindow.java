package org.example.pobeda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarDialogWindow {

    private WebDriver driver;

    @FindBy(xpath = "(//div[@role='dialog']//button[@tabindex and not(@data-muted)])[1]")
    private WebElement firstAvailableDate;

    @FindBy(css = "button[class$='closeBtn']")
    private WebElement closeBtn;

    @FindBy(xpath = "//button[text()='Обратный билет не нужен']")
    private WebElement dontNeedToReturn;

    public CalendarDialogWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalendarDialogWindow chooseFirstAvailableDate() {
        firstAvailableDate.click();
        return this;
    }

    public StartPage clickDontNeedReturnTicket() {
        dontNeedToReturn.click();
        return new StartPage(driver);
    }

    public StartPage close() {
        closeBtn.click();
        return new StartPage(driver);
    }
}
