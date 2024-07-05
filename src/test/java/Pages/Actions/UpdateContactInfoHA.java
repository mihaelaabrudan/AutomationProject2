package Pages.Actions;

import Pages.WebElements.UpdateContactInfoElementsHA;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class UpdateContactInfoHA {
    private UpdateContactInfoElementsHA elements;  // Obiect care conține elementele web pentru actualizarea informațiilor de contact
    private ConfigLoader configLoader;  // Loader pentru încărcarea proprietăților din fișiere de configurare
    private WebDriverWait wait;  // Obiect pentru a aștepta condiții specifice

    // Constructor care inițializează elementele, loaderul de configurare și obiectul de așteptare
    public UpdateContactInfoHA(WebDriver driver) {
        elements = new UpdateContactInfoElementsHA(driver);  // Inițializează obiectul UpdateContactInfoElementsHA pentru a accesa elementele de pe pagina de actualizare a contactelor
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Inițializează WebDriverWait cu un timeout de 10 secunde
    }

    // Navighează la pagina de actualizare a informațiilor de contact
    public void navigateToUpdateContactInfo() {
        WebElement updateContactLink = wait.until(ExpectedConditions.elementToBeClickable(elements.updateContactInfoLink()));  // Așteaptă ca linkul de actualizare a contactului să fie disponibil pentru clic
        updateContactLink.click();  // Face clic pe linkul de actualizare a contactului
    }

    // Setează un nou număr de telefon în câmpul de telefon
    public void setNewPhoneNumber(String newPhoneNumber) {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOf(elements.phoneNumberField()));  // Așteaptă ca câmpul de telefon să fie vizibil

        // Șterge conținutul câmpului de telefon până când este gol
        phoneNumberField.click();  // Face clic pe câmpul de telefon pentru a-l activa
        phoneNumberField.sendKeys(Keys.CONTROL + "a");  // Selectează tot textul din câmpul de telefon
        phoneNumberField.sendKeys(Keys.DELETE);  // Șterge textul selectat

        // Asigură-te că câmpul este complet gol
        while (!phoneNumberField.getAttribute("value").isEmpty()) {
            phoneNumberField.sendKeys(Keys.CONTROL + "a");  // Selectează tot textul din câmpul de telefon
            phoneNumberField.sendKeys(Keys.DELETE);  // Șterge textul selectat
        }

        // Introduce noul număr de telefon
        phoneNumberField.sendKeys(newPhoneNumber);  // Scrie noul număr de telefon în câmpul de telefon
    }

    // Face clic pe butonul de actualizare a profilului
    public void clickUpdateProfileButton() {
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(elements.updateProfileButton()));  // Așteaptă ca butonul de actualizare să fie disponibil pentru clic
        updateButton.click();  // Face clic pe butonul de actualizare
    }

    // Verifică dacă titlul de actualizare a profilului este prezent pe pagină
    public boolean isProfileUpdatedTitlePresent() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOf(elements.profileUpdatedTitle()));  // Așteaptă ca titlul de actualizare a profilului să fie vizibil
        return titleElement.isDisplayed();  // Verifică dacă titlul este afișat
    }

    // Obține numărul de telefon curent din câmpul de telefon
    public String getCurrentPhoneNumber() {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOf(elements.phoneNumberField()));  // Așteaptă ca câmpul de telefon să fie vizibil
        return phoneNumberField.getAttribute("value");  // Returnează valoarea curentă a câmpului de telefon
    }

    // Actualizează informațiile de contact ale utilizatorului folosind datele din fișierul de configurare
    public void updateContactInfoUser() {
        configLoader = new ConfigLoader("src/test/resources/propietati/dateUpdateContactInfo.properties");  // Inițializează ConfigLoader pentru a încărca proprietățile de actualizare a contactelor
        String newPhoneNumber = configLoader.getProperty("newPhoneNumber");  // Obține noul număr de telefon din fișierul de configurare

        navigateToUpdateContactInfo();  // Navighează la pagina de actualizare a informațiilor de contact
        setNewPhoneNumber(newPhoneNumber);  // Setează noul număr de telefon
        clickUpdateProfileButton();  // Face clic pe butonul de actualizare
    }
}