package org.example.pobeda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResaltPage {

    private WebDriver driver;

    @FindBy(xpath = "(//tr[@class='contentRow']//div)[1]")
    private WebElement firstAvailablePrice;

    @FindBy(css = "span.mobileHide")
    private WebElement nextBtn;

    public SearchResaltPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ClientDataPage chooseAvailableAndNext() {
        firstAvailablePrice.click();
        nextBtn.click();
        return new ClientDataPage(driver);
    }
}
