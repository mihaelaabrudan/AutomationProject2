package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.UpdateContactInfoHA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;
import utile.ConfigLoader;

import java.time.Duration;

public class UpdateContactInfoTest extends BaseTestHA {

    private LoginHA loginHA;
    private UpdateContactInfoHA updateContactInfoHA;

    // Testul pentru actualizarea informațiilor de contact
    @Test
    public void updateContactInfo() {
        // Inițializează testul cu un nume descriptiv pentru claritate în rapoartele de testare
        initTest("Update Contact Info");

        // Creează instanțe ale claselor necesare pentru test
        loginHA = new LoginHA(driver);
        updateContactInfoHA = new UpdateContactInfoHA(driver);

        // Definește WebDriverWait pentru a aștepta până la 10 secunde pentru elementele vizibile
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Autentifică utilizatorul
        loginHA.loginUser();

        // Navighează la secțiunea "Update Contact Info" pentru a actualiza informațiile de contact
        updateContactInfoHA.updateContactInfoUser();

        // Încarcă valorile de configurare pentru test din fișierul de proprietăți
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/propietati/dateUpdateContactInfo.properties");
        String expectedPhoneNumber = configLoader.getProperty("newPhoneNumber"); // Numărul de telefon așteptat după actualizare

        // Așteaptă până când câmpul pentru numărul de telefon este vizibil
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.phoneNumber")));

        // Verifică dacă valoarea din câmpul de număr de telefon corespunde valorii așteptate
        Assert.assertEquals(phoneNumberField.getAttribute("value"), expectedPhoneNumber, "Numărul de telefon nu a fost actualizat corect!");

        // Verifică dacă titlul de confirmare "Profile Updated" este prezent pe pagină
        Assert.assertTrue(updateContactInfoHA.isProfileUpdatedTitlePresent(), "Titlul 'Profile Updated' nu este prezent!");
    }
}