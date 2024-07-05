package Pages.Actions;

import Pages.WebElements.ForgotPasswordElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class ForgotPasswordHA {
    private ForgotPasswordElementsHA elements;  // Obiect care conține elementele web pentru pagina de recuperare a parolei
    private WebDriverWait wait;  // Obiect WebDriverWait pentru gestionarea așteptărilor explicite
    private ConfigLoader configLoader;  // Obiect ConfigLoader pentru încărcarea datelor de test din fișierul de configurare

    // Constructor care inițializează elementele și așteptările explicite
    public ForgotPasswordHA(WebDriver driver, String propertyFilePath) {
        elements = new ForgotPasswordElementsHA(driver);  // Inițializarea elementelor pentru pagina de recuperare a parolei
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Inițializarea WebDriverWait cu un timeout de 10 secunde
        configLoader = new ConfigLoader(propertyFilePath);  // Încarcă fișierul de configurare pentru datele de test
    }

    // Navighează la pagina de recuperare a parolei făcând click pe linkul corespunzător
    public void navigateToForgotPasswordPage() {
        elements.forgotPasswordLink().click();  // Face click pe linkul de recuperare a parolei
    }

    // Introduce detaliile utilizatorului în formularul de recuperare a parolei
    public void enterUserDetails() {
        sendKeysSafe(elements.firstNameInput(), configLoader.getProperty("firstName"));  // Completează câmpul pentru prenume
        sendKeysSafe(elements.lastNameInput(), configLoader.getProperty("lastName"));  // Completează câmpul pentru nume
        sendKeysSafe(elements.streetInput(), configLoader.getProperty("address"));  // Completează câmpul pentru adresa
        sendKeysSafe(elements.cityInput(), configLoader.getProperty("city"));  // Completează câmpul pentru oraș
        sendKeysSafe(elements.stateInput(), configLoader.getProperty("state"));  // Completează câmpul pentru stat
        sendKeysSafe(elements.zipCodeInput(), configLoader.getProperty("zipCode"));  // Completează câmpul pentru codul poștal
        sendKeysSafe(elements.ssnInput(), configLoader.getProperty("ssn"));  // Completează câmpul pentru numărul de securitate socială
    }

    // Trimite cererea de recuperare a parolei făcând click pe butonul corespunzător
    public void submitRequest() {
        elements.findPasswordButton().click();  // Face click pe butonul de găsire a parolei
    }

    // Obține mesajul de confirmare afișat după trimiterea cererii
    public String getConfirmationMessage() {
        return elements.confirmationMessage().getText();  // Returnează textul mesajului de confirmare
    }

    // Obține numele de utilizator afișat pe pagină
    public String getDisplayedUsername() {
        return elements.displayedUsername().getText().trim();  // Returnează numele de utilizator afișat, fără spații inutile
    }

    // Obține parola afișată pe pagină
    public String getDisplayedPassword() {
        return elements.displayedPassword().getText().trim();  // Returnează parola afișată, fără spații inutile
    }

    // Obține o proprietate din fișierul de configurare
    public String getConfigProperty(String key) {
        return configLoader.getProperty(key);  // Returnează valoarea proprietății specificate din fișierul de configurare
    }

    // Obține textul antetului secțiunii de căutare a clientului
    public String getCustomerLookupHeaderText() {
        return elements.customerLookupHeader().getText();  // Returnează textul antetului secțiunii de căutare a clientului
    }

    // Obține detaliile de confirmare afișate pe pagină
    public String getConfirmationDetails() {
        return elements.confirmationDetails().getText();  // Returnează textul detaliilor de confirmare
    }

    // Metodă ajutătoare pentru a trimite texte într-un câmp, verificând că valoarea nu este null
    private void sendKeysSafe(WebElement element, String value) {
        if (value != null) {
            element.sendKeys(value);  // Trimite textul în câmpul specificat
        } else {
            throw new IllegalArgumentException("Value for element cannot be null");  // Aruncă excepție dacă valoarea este null
        }
    }
}