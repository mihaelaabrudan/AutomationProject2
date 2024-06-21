package Tests;

import Pages.pages.LoginPage;
import Pages.pages.EventPage;
import org.testng.annotations.Test;
import utile.BaseTest;

public class EventTest extends BaseTest {

    @Test
    public void testSuccessfulDeleteEvent() {
        initTest("testSuccessfulDeleteEvent");

        // Logare pe site
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setemail("mihaela.abrudan99@gmail.com");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.submitButton();


        // Click pe evenimentul specificat
        EventPage eventPage = homePage.clickEvent("Eveniment pentru June 26, 2024");

        // Click pe butonul de ștergere a evenimentului
        eventPage.deleteEvent();


    }
}