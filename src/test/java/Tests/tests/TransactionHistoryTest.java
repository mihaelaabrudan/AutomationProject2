package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.TransactionHistoryHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;
import utile.ConfigLoader;

public class TransactionHistoryTest extends BaseTestHA {

    private LoginHA loginHA;
    private TransactionHistoryHA transactionHistoryHA;

    // Metoda de test pentru vizualizarea istoricului tranzacțiilor
    @Test
    public void viewTransactionHistory() throws InterruptedException {
        // Inițializează testul cu un nume descriptiv
        initTest("View Transaction History");

        // Creează instanțe ale claselor necesare pentru test
        loginHA = new LoginHA(driver);
        transactionHistoryHA = new TransactionHistoryHA(driver);

        // Autentifică utilizatorul
        loginHA.loginUser();

        // Încarcă valorile de configurare pentru test din fișierul de proprietăți
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/propietati/transactionHistory.properties");
        String accountId = configLoader.getProperty("accountId");
        String transactionId = configLoader.getProperty("transactionId");

        // Log pentru diagnosticare: afișează valorile de configurare
        System.out.println("Account ID: " + accountId);
        System.out.println("Transaction ID: " + transactionId);

        // Navighează la secțiunea "Accounts Overview" pentru a vizualiza conturile
        transactionHistoryHA.navigateToAccountsOverview();

        // Selectează contul specificat din lista de conturi
        transactionHistoryHA.selectAccount(accountId);

        // Selectează tranzacția specificată din lista de tranzacții
        transactionHistoryHA.selectTransaction(transactionId);

        // Verifică dacă descrierea tranzacției este prezentă în detaliile tranzacției
        Assert.assertTrue(transactionHistoryHA.isTransactionDescriptionPresent(), "Descrierea tranzacției nu este prezentă!");

        // Verifică dacă suma tranzacției este prezentă în detaliile tranzacției
        Assert.assertTrue(transactionHistoryHA.isTransactionAmountPresent(), "Suma tranzacției nu este prezentă!");
    }
}