package Tests.tests;

import Pages.Actions.LoginHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class LoginInvalidUserHA extends BaseTestHA {

    // Instanță a clasei de acțiune pentru funcționalitatea de login
    private LoginHA loginHA;

    // Metoda de test pentru verificarea login-ului cu un utilizator invalid
    @Test
    public void loginInvalidUser() {
        // Inițializează testul cu un nume descriptiv
        initTest("Login Invalid User");

        // Creează o instanță a clasei LoginHA pentru a accesa funcționalitățile de login
        loginHA = new LoginHA(driver);

        // Începe procesul de login folosind un utilizator invalid
        loginHA.loginUser();

        // Verifică dacă atât titlul de eroare, cât și textul de eroare sunt prezente pe pagină
        if (loginHA.isErrorTitlePresent() && loginHA.isErrorTextPresent()) {

            // Definirea titlului și textului de eroare așteptate
            String expectedErrorTitle = "Error!";
            String expectedErrorText = "The username and password could not be verified.";

            // Obține titlul și textul de eroare de pe pagină
            String actualErrorTitle = loginHA.getErrorTitle();
            String actualErrorText = loginHA.getErrorText();

            // Verifică dacă titlul de eroare obținut conține textul așteptat
            Assert.assertTrue(actualErrorTitle.contains(expectedErrorTitle),
                    "Titlul de eroare nu este corect! Așteptat: " + expectedErrorTitle +
                            " dar a fost: " + actualErrorTitle);

            // Verifică dacă textul de eroare obținut conține textul așteptat
            Assert.assertTrue(actualErrorText.contains(expectedErrorText),
                    "Mesajul de eroare nu este corect! Așteptat: " + expectedErrorText +
                            " dar a fost: " + actualErrorText);
        } else {
            // Dacă titlul de eroare sau textul de eroare nu sunt găsite, testul eșuează
            Assert.fail("Nici textul de bun venit, nici textul de eroare nu au fost găsite!");
        }
    }
}