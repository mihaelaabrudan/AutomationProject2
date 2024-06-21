package Tests;

import Pages.pages.FoundMonthPage;
import Pages.pages.HomePage;
import Pages.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utile.BaseTest;

public class FoundMonthTest extends BaseTest {

    @Test
    public void testSuccessfulFoundMonth() {
        initTest("testSuccessfulFoundMonth");

        // Logare pe site
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setemail("mihaela.abrudan99@gmail.com");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.submitButton();

        // Navigare până la luna August 2024
        FoundMonthPage foundMonthPage = homePage.goToAugust2024();

        // Verificare dacă luna curentă este August 2024
        assert foundMonthPage.isAugust2024();
    }
}