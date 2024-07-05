package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.OpenNewAccountHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;
import utile.ConfigLoader;

public class OpenNewAccountTest extends BaseTestHA {

    // Instanță a clasei LoginHA pentru funcționalitățile de autentificare
    private LoginHA loginHA;
    // Instanță a clasei OpenNewAccountHA pentru funcționalitățile de deschidere a unui cont nou
    private OpenNewAccountHA openNewAccountHA;

    // Metoda de test pentru deschiderea unui cont nou
    @Test
    public void openNewAccount() {
        // Inițializează testul cu un nume descriptiv
        initTest("Open New Account");

        // Creează o instanță a clasei LoginHA folosind driver-ul
        loginHA = new LoginHA(driver);
        // Creează o instanță a clasei OpenNewAccountHA folosind driver-ul
        openNewAccountHA = new OpenNewAccountHA(driver);

        // Autentifică utilizatorul folosind metoda loginUser() din LoginHA
        loginHA.loginUser();

        // Încarcă valorile necesare din fișierul de proprietăți
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/propietati/account.properties");
        // Obține tipul de cont și ID-ul contului din care se transferă din fișierul de proprietăți
        String accountType = configLoader.getProperty("accountType");
        String fromAccountId = configLoader.getProperty("fromAccountId");

        // Log pentru diagnosticare - afișează tipul de cont și ID-ul contului din care se transferă
        System.out.println("Account Type: " + accountType);
        System.out.println("From Account ID: " + fromAccountId);

        // Navighează la secțiunea "Open New Account" folosind metoda corespunzătoare
        openNewAccountHA.navigateToOpenNewAccount();

        // Introduce detaliile necesare pentru deschiderea unui cont nou și apasă butonul de deschidere
        openNewAccountHA.enterNewAccountDetails(accountType, fromAccountId);

        // Face click pe butonul "Open New Account" pentru a deschide un nou cont
        openNewAccountHA.clickOpenNewAccountButton();

        // Verifică dacă titlul de confirmare a deschiderii contului este prezent pe pagină
        Assert.assertTrue(openNewAccountHA.isAccountOpenedTitlePresent(), "Titlul de deschidere a contului nu este prezent!");
        // Verifică dacă mesajul de confirmare a deschiderii contului este prezent pe pagină
        Assert.assertTrue(openNewAccountHA.isAccountOpenedMessagePresent(), "Mesajul de deschidere a contului nu este prezent!");

        // Obține ID-ul noului cont creat și verifică dacă acesta nu este nul
        String newAccountId = openNewAccountHA.getNewAccountId();
        Assert.assertNotNull(newAccountId, "ID-ul noului cont nu a fost găsit!");
        // Log pentru diagnosticare - afișează ID-ul noului cont creat
        System.out.println("Noul cont a fost creat cu ID-ul: " + newAccountId);

        // Navighează la pagina "Accounts Overview" pentru a vizualiza lista de conturi
        openNewAccountHA.navigateToAccountsOverview();

        // Verifică dacă ID-ul noului cont apare în lista de conturi
        Assert.assertTrue(openNewAccountHA.isNewAccountPresentInOverview(newAccountId), "ID-ul noului cont nu este prezent în Accounts Overview!");
    }
}