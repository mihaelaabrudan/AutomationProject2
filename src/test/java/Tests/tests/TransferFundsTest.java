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

    @Test
    public void transferFunds() {
        initTest("Transfer Funds");
        loginHA = new LoginHA(driver);
        transferFundsHA = new TransferFundsHA(driver);

        loginHA.loginUser();

        // Încarcă valorile din fișierul de proprietăți
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/propietati/transferFunds.properties");
        String amount = configLoader.getProperty("amount");
        String fromAccount = configLoader.getProperty("fromAccountId");
        String toAccount = configLoader.getProperty("toAccountId");

        // Navighează la secțiunea "Transfer Funds"
        transferFundsHA.navigateToTransferFunds();

        // Introduce detaliile transferului și apasă butonul de transfer
        transferFundsHA.enterTransferDetails(amount, fromAccount, toAccount);
        transferFundsHA.clickTransferButton();

        // Verifică dacă transferul a fost efectuat cu succes
        //Assert.assertTrue(transferFundsHA.isTransferCompleteMessagePresent(), "Mesajul de confirmare a transferului nu este prezent!");

        // Verifică detaliile transferului
        Assert.assertEquals(transferFundsHA.getTransferAmount(), "$10.00", "Suma transferată nu este corectă!");
        Assert.assertEquals(transferFundsHA.getFromAccountId(), fromAccount, "ID-ul contului sursă nu este corect!");
        Assert.assertEquals(transferFundsHA.getToAccountId(), toAccount, "ID-ul contului destinație nu este corect!");
    }
}