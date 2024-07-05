package Tests.tests;

import Pages.Actions.ForgotPasswordHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class ForgotPasswordTest extends BaseTestHA {

    // Instanță a clasei de acțiune pentru funcționalitatea de recuperare a parolei
    private ForgotPasswordHA forgotPasswordHA;

    // Cale către fișierul de proprietăți care conține datele utilizatorului pentru testare
    private static final String PROPERTY_FILE_PATH = "src/test/resources/propietati/dateUser2.properties";

    // Metoda de test pentru verificarea funcționalității de recuperare a parolei
    @Test
    public void testForgotPassword() {
        // Creează instanța pentru pagina de recuperare a parolei cu driver-ul și calea către fișierul de proprietăți
        forgotPasswordHA = new ForgotPasswordHA(driver, PROPERTY_FILE_PATH);

        // Navighează la pagina de recuperare a parolei
        forgotPasswordHA.navigateToForgotPasswordPage();

        // Introduce detaliile utilizatorului necesare pentru recuperarea parolei
        forgotPasswordHA.enterUserDetails();

        // Apasă butonul pentru a trimite cererea de recuperare a parolei
        forgotPasswordHA.submitRequest();

        // Verifică dacă textul "Customer Lookup" apare pe pagină
        String customerLookupHeaderText = forgotPasswordHA.getCustomerLookupHeaderText();
        Assert.assertEquals(customerLookupHeaderText, "Customer Lookup", "Textul 'Customer Lookup' nu este prezent!");

        // Verifică dacă mesajul de confirmare a recuperării parolei este afișat corect
        String confirmationMessage = forgotPasswordHA.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Your login information was located successfully. You are now logged in.", "Mesajul de confirmare nu este corect!");

        // Verifică detaliile de confirmare a recuperării parolei
        String confirmationDetails = forgotPasswordHA.getConfirmationDetails();
        String expectedUsername = forgotPasswordHA.getConfigProperty("username");
        String expectedPassword = forgotPasswordHA.getConfigProperty("password");

        // Extrage username-ul și parola din textul de confirmare
        String[] details = confirmationDetails.split("\n");
        String actualUsername = details[0].split(":")[1].trim();
        String actualPassword = details[1].split(":")[1].trim();

        // Verifică dacă username-ul extras din textul de confirmare este corect
        Assert.assertEquals(actualUsername, expectedUsername, "Username-ul nu este corect!");

        // Verifică dacă parola extrasă din textul de confirmare este corectă
        Assert.assertEquals(actualPassword, expectedPassword, "Parola nu este corectă!");
    }
}