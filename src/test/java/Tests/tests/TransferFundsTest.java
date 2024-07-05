package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.TransferFundsHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;
import utile.ConfigLoader;

public class TransferFundsTest extends BaseTestHA {

    private LoginHA loginHA;
    private TransferFundsHA transferFundsHA;

    // Metoda de test pentru transferul de fonduri
    @Test
    public void transferFunds() {
        // Inițializează testul cu un nume descriptiv pentru claritate în rapoartele de testare
        initTest("Transfer Funds");

        // Creează instanțe ale claselor necesare pentru test
        loginHA = new LoginHA(driver);
        transferFundsHA = new TransferFundsHA(driver);

        // Autentifică utilizatorul
        loginHA.loginUser();

        // Încarcă valorile de configurare pentru test din fișierul de proprietăți
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/propietati/transferFunds.properties");
        String amount = configLoader.getProperty("amount"); // Suma de transferat
        String fromAccount = configLoader.getProperty("fromAccountId"); // ID-ul contului sursă
        String toAccount = configLoader.getProperty("toAccountId"); // ID-ul contului destinație

        // Log pentru diagnosticare: afișează valorile de configurare
        System.out.println("Amount: " + amount);
        System.out.println("From Account ID: " + fromAccount);
        System.out.println("To Account ID: " + toAccount);

        // Navighează la secțiunea "Transfer Funds" pentru a iniția transferul
        transferFundsHA.navigateToTransferFunds();

        // Introduce detaliile transferului și apasă butonul de transfer
        transferFundsHA.enterTransferDetails(amount, fromAccount, toAccount);
        transferFundsHA.clickTransferButton();

        // Verifică dacă mesajul de confirmare a transferului este prezent
        Assert.assertTrue(transferFundsHA.isTransferCompleteMessagePresent(), "Mesajul de confirmare a transferului nu este prezent!");

        // Verifică dacă suma transferată este corectă
        Assert.assertEquals(transferFundsHA.getTransferAmount(), amount, "Suma transferată nu este corectă!");

        // Verifică dacă ID-ul contului sursă este corect
        Assert.assertEquals(transferFundsHA.getFromAccountId(), fromAccount, "ID-ul contului sursă nu este corect!");

        // Verifică dacă ID-ul contului destinație este corect
        Assert.assertEquals(transferFundsHA.getToAccountId(), toAccount, "ID-ul contului destinație nu este corect!");
    }
}