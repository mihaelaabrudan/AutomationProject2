package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordElementsHA {
    private WebDriver driver;  // Obiect WebDriver pentru a interacționa cu elementele web

    // Constructor care inițializează driverul
    public ForgotPasswordElementsHA(WebDriver driver) {
        this.driver = driver;  // Alocă driverul pentru utilizare în metodele acestei clase
    }

    // Returnează elementul care reprezintă linkul "Forgot Password"
    public WebElement forgotPasswordLink() {
        return driver.findElement(By.xpath("//a[@href='lookup.htm']"));  // Găsește linkul "Forgot Password" după atributul 'href'
    }

    // Returnează elementul câmpului de input pentru prenumele utilizatorului
    public WebElement firstNameInput() {
        return driver.findElement(By.id("firstName"));  // Găsește câmpul de input pentru prenumele utilizatorului după ID-ul său
    }

    // Returnează elementul câmpului de input pentru numele de familie al utilizatorului
    public WebElement lastNameInput() {
        return driver.findElement(By.id("lastName"));  // Găsește câmpul de input pentru numele de familie al utilizatorului după ID-ul său
    }

    // Returnează elementul câmpului de input pentru strada adresei utilizatorului
    public WebElement streetInput() {
        return driver.findElement(By.id("address.street"));  // Găsește câmpul de input pentru strada adresei utilizatorului după ID-ul său
    }

    // Returnează elementul câmpului de input pentru orașul adresei utilizatorului
    public WebElement cityInput() {
        return driver.findElement(By.id("address.city"));  // Găsește câmpul de input pentru orașul adresei utilizatorului după ID-ul său
    }

    // Returnează elementul câmpului de input pentru statul adresei utilizatorului
    public WebElement stateInput() {
        return driver.findElement(By.id("address.state"));  // Găsește câmpul de input pentru statul adresei utilizatorului după ID-ul său
    }

    // Returnează elementul câmpului de input pentru codul poștal al adresei utilizatorului
    public WebElement zipCodeInput() {
        return driver.findElement(By.id("address.zipCode"));  // Găsește câmpul de input pentru codul poștal al adresei utilizatorului după ID-ul său
    }

    // Returnează elementul câmpului de input pentru SSN (numărul de securitate socială) al utilizatorului
    public WebElement ssnInput() {
        return driver.findElement(By.id("ssn"));  // Găsește câmpul de input pentru SSN-ul utilizatorului după ID-ul său
    }

    // Returnează elementul butonului pentru a găsi informațiile de login
    public WebElement findPasswordButton() {
        return driver.findElement(By.xpath("//input[@type='submit' and @value='Find My Login Info']"));  // Găsește butonul de submit pentru a găsi informațiile de login după atributele sale
    }

    // Returnează elementul care afișează mesajul de confirmare după găsirea informațiilor de login
    public WebElement confirmationMessage() {
        return driver.findElement(By.xpath("//p[contains(text(), 'Your login information was located successfully. You are now logged in.')]"));  // Găsește mesajul de confirmare după textul său
    }

    // Returnează elementul care afișează numele de utilizator în mesajul de confirmare
    public WebElement displayedUsername() {
        return driver.findElement(By.xpath("//p/b[contains(text(), 'Username')]/following-sibling::br/following-sibling::text()"));  // Găsește numele de utilizator afișat după textul 'Username'
    }

    // Returnează elementul care afișează parola în mesajul de confirmare
    public WebElement displayedPassword() {
        return driver.findElement(By.xpath("//p/b[contains(text(), 'Password')]/following-sibling::text()"));  // Găsește parola afișată după textul 'Password'
    }

    // Returnează elementul care reprezintă antetul paginii de căutare a utilizatorului
    public WebElement customerLookupHeader() {
        return driver.findElement(By.xpath("//*[@id='rightPanel']/h1"));  // Găsește antetul paginii de căutare a utilizatorului după XPath-ul său
    }

    // Returnează elementul care conține detaliile confirmării informațiilor de login
    public WebElement confirmationDetails() {
        return driver.findElement(By.xpath("//*[@id='rightPanel']/p[2]"));  // Găsește detaliile confirmării după XPath-ul său
    }
}