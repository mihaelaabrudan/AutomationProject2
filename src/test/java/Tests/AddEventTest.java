package Tests;

import org.testng.annotations.Test;
import Pages.pages.AddEventPage;
import Pages.pages.HomePage;
import Pages.pages.LoginPage;
import utile.BaseTest;

import java.util.Arrays;
import java.util.List;

public class AddEventTest extends BaseTest {
    protected HomePage homePage;

    @Test
    public void testSuccessfulAddEvent() {
        initTest("testSuccessfulAddEvent"); // Initialize ExtentTest
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickLogin();
        loginPage.setemail("mihaela.abrudan99@gmail.com");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.submitButton();


        // Click pe data și navighează la RegisterPage
        //AddEventPage addeventPage =homePage.clickCalendarDay();

        // Adaugă titlul evenimentului
        //addeventPage.seteventTitle("Automation Training");

        // Apasă butonul de creare a evenimentului
        //addeventPage.clickCreateEventButton();

        // Lista de date la care vrem să adăugăm evenimente
        String[] dates = {"June 24, 2024", "June 26, 2024", "June 28, 2024"};

        for (String date : dates) {
            AddEventPage addEventPage = homePage.clickCalendarDay(date);
            addEventPage.clearEventTitle();
            addEventPage.setEventTitle("Eveniment pentru " + date);
            addEventPage.clickCreateEventButton();
        }


    }
}
