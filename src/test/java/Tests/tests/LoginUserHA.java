package Tests.tests;

import Pages.Actions.LoginHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class LoginUserHA extends BaseTestHA {

    private LoginHA loginHA;

    @Test
    public void loginUser() {
        initTest("Login User");
        loginHA = new LoginHA(driver);
        loginHA.loginUser();

        // Afișează valorile firstName și lastName din fișierul .properties
        String expectedFirstName = loginHA.getFirstName();
        String expectedLastName = loginHA.getLastName();
        String expectedText = "Welcome " + expectedFirstName + " " + expectedLastName;

        // Verifică dacă textul de bun venit conține valorile așteptate
        String actualText = loginHA.getWelcomeText();
        Assert.assertTrue(actualText.contains(expectedText), "Textul de bun venit nu este corect! Așteptat: " + expectedText + " dar a fost: " + actualText);
    }
}