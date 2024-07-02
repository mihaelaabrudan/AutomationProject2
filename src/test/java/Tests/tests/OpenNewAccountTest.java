package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.OpenNewAccountHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;
import utile.ConfigLoader;

public class OpenNewAccountTest extends BaseTestHA {

    private LoginHA loginHA;
    private OpenNewAccountHA openNewAccountHA;

    @Test
    public void openNewAccount() {
        initTest("Open New Account");
        loginHA = new LoginHA(driver);
        openNewAccountHA = new OpenNewAccountHA(driver);

        loginHA.loginUser();

        // Încarcă valorile din fișierul de proprietăți
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/propietati/account.properties");
        String accountType = configLoader.getProperty("accountType");
        String fromAccountId = configLoader.getProperty("fromAccountId");

        // Navighează la secțiunea "Open New Account"
        openNewAccountHA.navigateToOpenNewAccount();

        // Selectează tipul de cont și contul sursă
        openNewAccountHA.selectAccountType(accountType);
        openNewAccountHA.selectFromAccountId(fromAccountId);

        // Face click pe butonul de deschidere a unui nou cont
        openNewAccountHA.clickOpenNewAccountButton();

        // Verifică dacă titlul de confirmare a deschiderii contului este prezent
        Assert.assertTrue(openNewAccountHA.isAccountOpenedTitlePresent(), "Titlul de deschidere a contului nu este prezent!");
        Assert.assertTrue(openNewAccountHA.isAccountOpenedMessagePresent(), "Mesajul de deschidere a contului nu este prezent!");

        // Obține ID-ul noului cont
        String newAccountId = openNewAccountHA.getNewAccountId();
        Assert.assertNotNull(newAccountId, "ID-ul noului cont nu a fost găsit!");
        System.out.println("Noul cont a fost creat cu ID-ul: " + newAccountId);

        // Navighează la pagina "Accounts Overview"
        openNewAccountHA.navigateToAccountsOverview();

        // Verifică dacă ID-ul noului cont este prezent în lista de conturi
        Assert.assertTrue(openNewAccountHA.isNewAccountPresentInOverview(newAccountId), "ID-ul noului cont nu este prezent în Accounts Overview!");
    }


}
