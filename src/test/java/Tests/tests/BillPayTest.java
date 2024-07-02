package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.BillPayHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class BillPayTest extends BaseTestHA {

    private LoginHA loginHA;
    private BillPayHA billPayHA;

    @Test
    public void payBill() {
        initTest("Pay Bill");
        loginHA = new LoginHA(driver);
        billPayHA = new BillPayHA(driver);

        loginHA.loginUser();

        // Navighează la secțiunea "Bill Pay"
        billPayHA.navigateToBillPay();

        // Introduce detaliile necesare pentru plată
        billPayHA.enterBillPayDetails();

        // Apasă butonul "Send Payment"
        billPayHA.clickSendPaymentButton();

        // Verifică dacă titlul de confirmare a plății este prezent
        Assert.assertTrue(billPayHA.isPaymentCompleteTitlePresent(), "Mesajul de confirmare a plății nu este prezent!");

        // Verifică dacă detaliile plății sunt corecte
        Assert.assertTrue(billPayHA.verifyPaymentDetails(), "Detaliile plății nu sunt corecte!");
    }
}