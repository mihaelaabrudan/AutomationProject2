package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillPayElementsHA {
    private WebDriver driver;  // Obiect WebDriver pentru a interacționa cu elementele web

    // Constructor care inițializează driverul
    public BillPayElementsHA(WebDriver driver) {
        this.driver = driver;  // Alocă driverul pentru utilizare în metodele acestei clase
    }

    // Returnează elementul care reprezintă linkul "Bill Pay"
    public WebElement billPayLink() {
        return driver.findElement(By.linkText("Bill Pay"));  // Găsește linkul "Bill Pay" pe pagină după textul acestuia
    }

    // Returnează elementul câmpului pentru numele plătitorului
    public WebElement payeeNameField() {
        return driver.findElement(By.name("payee.name"));  // Găsește câmpul de text pentru numele plătitorului după atributul 'name'
    }

    // Returnează elementul câmpului pentru strada adresei plătitorului
    public WebElement payeeAddressStreetField() {
        return driver.findElement(By.name("payee.address.street"));  // Găsește câmpul de text pentru strada adresei plătitorului după atributul 'name'
    }

    // Returnează elementul câmpului pentru orașul adresei plătitorului
    public WebElement payeeAddressCityField() {
        return driver.findElement(By.name("payee.address.city"));  // Găsește câmpul de text pentru orașul adresei plătitorului după atributul 'name'
    }

    // Returnează elementul câmpului pentru statul adresei plătitorului
    public WebElement payeeAddressStateField() {
        return driver.findElement(By.name("payee.address.state"));  // Găsește câmpul de text pentru statul adresei plătitorului după atributul 'name'
    }

    // Returnează elementul câmpului pentru codul poștal al adresei plătitorului
    public WebElement payeeAddressZipCodeField() {
        return driver.findElement(By.name("payee.address.zipCode"));  // Găsește câmpul de text pentru codul poștal al adresei plătitorului după atributul 'name'
    }

    // Returnează elementul câmpului pentru numărul de telefon al plătitorului
    public WebElement payeePhoneNumberField() {
        return driver.findElement(By.name("payee.phoneNumber"));  // Găsește câmpul de text pentru numărul de telefon al plătitorului după atributul 'name'
    }

    // Returnează elementul câmpului pentru numărul de cont al plătitorului
    public WebElement payeeAccountNumberField() {
        return driver.findElement(By.name("payee.accountNumber"));  // Găsește câmpul de text pentru numărul de cont al plătitorului după atributul 'name'
    }

    // Returnează elementul câmpului pentru verificarea contului
    public WebElement verifyAccountField() {
        return driver.findElement(By.name("verifyAccount"));  // Găsește câmpul de text pentru verificarea contului după atributul 'name'
    }

    // Returnează elementul câmpului pentru suma de plată
    public WebElement amountField() {
        return driver.findElement(By.name("amount"));  // Găsește câmpul de text pentru suma de plată după atributul 'name'
    }

    // Returnează elementul dropdown pentru selectarea contului din care se face plata
    public WebElement fromAccountDropdown() {
        return driver.findElement(By.name("fromAccountId"));  // Găsește dropdown-ul pentru selectarea contului sursă după atributul 'name'
    }

    // Returnează elementul butonului de trimitere a plății
    public WebElement sendPaymentButton() {
        return driver.findElement(By.cssSelector("input.button[value='Send Payment']"));  // Găsește butonul de trimitere a plății după selectorul CSS
    }

    // Returnează elementul titlului mesajului de confirmare a plății
    public WebElement paymentCompleteTitle() {
        return driver.findElement(By.xpath("//h1[contains(text(),'Bill Payment Complete')]"));  // Găsește titlul mesajului de confirmare a plății după textul său
    }

    // Returnează elementul care afișează numele plătitorului în confirmarea plății
    public WebElement payeeNameResult() {
        return driver.findElement(By.id("payeeName"));  // Găsește elementul care afișează numele plătitorului după ID-ul său
    }

    // Returnează elementul care afișează suma plătită în confirmarea plății
    public WebElement amountResult() {
        return driver.findElement(By.id("amount"));  // Găsește elementul care afișează suma plătită după ID-ul său
    }

    // Returnează elementul care afișează ID-ul contului din care s-a efectuat plata în confirmarea plății
    public WebElement fromAccountIdResult() {
        return driver.findElement(By.id("fromAccountId"));  // Găsește elementul care afișează ID-ul contului sursă după ID-ul său
    }
}