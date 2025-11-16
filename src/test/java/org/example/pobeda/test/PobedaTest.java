package org.example.pobeda.test;

import com.codeborne.selenide.Selenide;
import org.example.pobeda.pages.ReservationPage;
import org.example.pobeda.pages.StartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PobedaTest {

    @BeforeEach
    public void beforeEach() {
        Selenide.open();
    }

    @Test
    public void testCase() {
        new StartPage().openPage()
                .checkTitle()
                .checkInfoContent()
                .checkSearchArea()
                .chooseDepartureCity("Москва")
                .chooseArrivalCity("Санкт-Петербург")
                .submitAndError();
    }

    @Test
    public void findReservationTest() {
        new StartPage().openPage()
                .checkTitle()
                .checkReservationSection()
                .findReservation("Qwerty", "123456");
        new ReservationPage().openPage()
                .checkErrorMsg();
    }
}
