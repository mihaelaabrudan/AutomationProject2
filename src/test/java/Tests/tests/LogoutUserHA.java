package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.LogoutHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class LogoutUserHA extends BaseTestHA {

    private LoginHA loginHA;
    private LogoutHA logoutHA;

    @Test
    public void logoutUser() {
        initTest("Logout User");
        loginHA = new LoginHA(driver);
        loginHA.loginUser();
        logoutHA = new LogoutHA(driver);

        // Verifică dacă butonul de logout este prezent și face click pe el
        Assert.assertTrue(logoutHA.isLogoutButtonPresent(), "Butonul de logout nu este prezent!");
        logoutHA.clickLogoutButton();

        // Verifică dacă utilizatorul a fost redirecționat la pagina de login după logout
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://parabank.parasoft.com/parabank/index.htm"), "Logout-ul nu a reușit! Utilizatorul nu a fost redirecționat la pagina de login.");
    }
}

