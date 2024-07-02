package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.TransactionHistoryHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class TransactionHistoryTest extends BaseTestHA {

    private LoginHA loginHA;
    private TransactionHistoryHA transactionHistoryHA;

    @Test
    public void viewTransactionHistory() throws InterruptedException {
        initTest("View Transaction History");
        loginHA = new LoginHA(driver);
        transactionHistoryHA = new TransactionHistoryHA(driver);

        loginHA.loginUser();

        // Navighează la secțiunea "Accounts Overview"
        transactionHistoryHA.navigateToAccountsOverview();

        // Selectează un cont
        transactionHistoryHA.selectAccount("14010");

        // Selectează o tranzacție
        transactionHistoryHA.selectTransaction("26686");

        // Verifică dacă descrierea tranzacției este prezentă
        Assert.assertTrue(transactionHistoryHA.isTransactionDescriptionPresent(), "Descrierea tranzacției nu este prezentă!");

        // Verifică dacă suma tranzacției este prezentă
        Assert.assertTrue(transactionHistoryHA.isTransactionAmountPresent(), "Suma tranzacției nu este prezentă!");
    }
}