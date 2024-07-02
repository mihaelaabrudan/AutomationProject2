package Tests.tests;

import Pages.Actions.LoginHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class LoginInvalidUserHA extends BaseTestHA {
    private LoginHA loginHA;

    @Test
    public void loginInvalidUser() {
        initTest("Login Invalid User");
        loginHA = new LoginHA(driver);
        loginHA.loginUser();

        if (loginHA.isErrorTitlePresent() && loginHA.isErrorTextPresent()) {
            String expectedErrorTitle = "Error!";
            String expectedErrorText = "The username and password could not be verified.";
            String actualErrorTitle = loginHA.getErrorTitle();
            String actualErrorText = loginHA.getErrorText();
            Assert.assertTrue(actualErrorTitle.contains(expectedErrorTitle), "Titlul de eroare nu este corect! Așteptat: " + expectedErrorTitle + " dar a fost: " + actualErrorTitle);
            Assert.assertTrue(actualErrorText.contains(expectedErrorText), "Mesajul de eroare nu este corect! Așteptat: " + expectedErrorText + " dar a fost: " + actualErrorText);
        } else {
            Assert.fail("Nici textul de bun venit, nici textul de eroare nu au fost găsite!");
        }
    }
}
