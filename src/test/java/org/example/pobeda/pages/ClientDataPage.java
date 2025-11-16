package org.example.pobeda.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientDataPage {

    private WebDriver driver;

    @FindBy(xpath = "//h2[text()='Данные клиента']")
    private WebElement clientDataTitle;

    public ClientDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkTitlePresents() {
        Assertions.assertTrue(clientDataTitle.isDisplayed());
    }
}
