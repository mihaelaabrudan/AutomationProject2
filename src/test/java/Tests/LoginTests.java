package Tests;

import org.testng.annotations.Test;
import Pages.pages.HomePage;
import Pages.pages.LoginPage;

import utile.BaseTest;

import static org.testng.Assert.assertTrue;


public class LoginTests extends BaseTest {
    protected HomePage homePage;

    @Test
    public void testSuccessfulLogin() {
        initTest("testSuccessfulLogin"); // Initialize ExtentTest
        // Creează o instanță a clasei HomePage
        HomePage homePage = new HomePage(driver);
        // Click pe link-ul 'Register' și navighează la RegisterPage
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setemail("mihaela.abrudan99@gmail.com");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.submitButton();

    }



}
