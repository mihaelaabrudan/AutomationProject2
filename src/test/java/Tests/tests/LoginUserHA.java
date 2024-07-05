package Tests.tests;

import Pages.Actions.LoginHA;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginUserHA extends BaseTestHA {

    // Instanță a clasei de acțiune pentru funcționalitatea de login
    private LoginHA loginHA;
    // Instanță WebDriverWait pentru a aștepta anumite condiții
    private WebDriverWait wait;

    // Metoda de test pentru verificarea login-ului cu un utilizator valid
    @Test
    public void loginUser() {
        // Inițializează testul cu un nume descriptiv
        initTest("Login User");

        // Creează o instanță a clasei LoginHA pentru a accesa funcționalitățile de login
        loginHA = new LoginHA(driver);

        // Creează o instanță a WebDriverWait pentru a aștepta până la 10 secunde
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Începe procesul de autentificare folosind datele de login specificate în cadrul metodei loginUser()
        loginHA.loginUser();

        // Așteaptă până când textul de bun venit este vizibil pe pagină
        wait.until(ExpectedConditions.visibilityOf(loginHA.getWelcomeTextElement()));

        // Afișează valorile firstName și lastName din fișierul .properties
        String expectedFirstName = loginHA.getFirstName();
        String expectedLastName = loginHA.getLastName();
        String expectedText = "Welcome " + expectedFirstName + " " + expectedLastName;

        // Verifică dacă textul de bun venit obținut conține valorile așteptate
        String actualText = loginHA.getWelcomeText();
        Assert.assertTrue(actualText.contains(expectedText),
                "Textul de bun venit nu este corect! Așteptat: " + expectedText + " dar a fost: " + actualText);

        // Așteaptă până când elementul "Account Services" este vizibil pe pagină
        wait.until(ExpectedConditions.visibilityOf(loginHA.getAccountServicesHeaderElement()));

        // Verifică dacă textul "Account Services" este prezent pe pagină
        boolean isAccountServicesPresent = loginHA.isAccountServicesHeaderPresent();
        Assert.assertTrue(isAccountServicesPresent,
                "Textul 'Account Services' nu este prezent!");
    }
}