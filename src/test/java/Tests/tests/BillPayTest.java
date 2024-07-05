package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.BillPayHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class BillPayTest extends BaseTestHA {

    // Instanțe ale paginilor de acțiune utilizate în test
    private LoginHA loginHA;
    private BillPayHA billPayHA;

    // Metoda de test care verifică funcționalitatea de plată a facturilor
    @Test
    public void payBill() {
        // Inițializează testul cu un nume descriptiv
        initTest("Pay Bill");

        // Creează instanțele necesare pentru paginile de acțiune
        loginHA = new LoginHA(driver);
        billPayHA = new BillPayHA(driver);

        // Efectuează autentificarea utilizatorului
        loginHA.loginUser();

        // Navighează la secțiunea "Bill Pay" din aplicație
        billPayHA.navigateToBillPay();

        // Introduce detaliile necesare pentru efectuarea plății
        billPayHA.enterBillPayDetails();

        // Apasă butonul pentru trimiterea plății
        billPayHA.clickSendPaymentButton();

        // Verifică dacă titlul de confirmare a plății este prezent pe pagină
        Assert.assertTrue(billPayHA.isPaymentCompleteTitlePresent(), "Mesajul de confirmare a plății nu este prezent!");

        // Verifică dacă detaliile plății sunt corecte comparativ cu cele introduse
        Assert.assertTrue(billPayHA.verifyPaymentDetails(), "Detaliile plății nu sunt corecte!");
    }
}