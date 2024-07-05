package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElementsHA {
    private WebDriver driver;  // Obiect WebDriver pentru a interacționa cu elementele web

    // Constructor care inițializează driverul
    public LoginElementsHA(WebDriver driver) {
        this.driver = driver;  // Alocă driverul pentru utilizare în metodele acestei clase
    }

    // Returnează elementul câmpului de input pentru numele de utilizator
    public WebElement myUsername() {
        return driver.findElement(By.cssSelector("input[type='text'].input[name='username']"));  // Găsește câmpul de input pentru numele de utilizator după selectorul CSS
    }

    // Returnează elementul câmpului de input pentru parola utilizatorului
    public WebElement myPassword() {
        return driver.findElement(By.cssSelector("input[type='password'].input[name='password']"));  // Găsește câmpul de input pentru parola utilizatorului după selectorul CSS
    }

    // Returnează elementul butonului de autentificare
    public WebElement loginButton() {
        return driver.findElement(By.cssSelector("input[type='submit'].button[value='Log In']"));  // Găsește butonul de autentificare după selectorul CSS
    }

    // Returnează elementul textului de bun venit după autentificare
    public WebElement welcomeText() {
        return driver.findElement(By.cssSelector("p.smallText"));  // Găsește textul de bun venit după selectorul CSS
    }

    // Returnează elementul care conține titlul de eroare
    public WebElement errorTitle() {
        return driver.findElement(By.cssSelector("h1.title"));  // Găsește titlul de eroare după selectorul CSS
    }

    // Returnează elementul care conține textul de eroare
    public WebElement errorText() {
        return driver.findElement(By.cssSelector("p.error"));  // Găsește textul de eroare după selectorul CSS
    }

    // Returnează elementul antetului pentru secțiunea "Account Services"
    public WebElement accountServicesHeader() {
        return driver.findElement(By.xpath("//h2[text()='Account Services']"));  // Găsește antetul secțiunii "Account Services" după XPath-ul său
    }

    // Returnează localizatorul pentru antetul secțiunii "Account Services"
    public By accountServicesHeaderLocator() {
        return By.xpath("//h2[text()='Account Services']");  // Localizatorul pentru antetul secțiunii "Account Services"
    }

    // Returnează localizatorul pentru textul de bun venit
    public By welcomeTextLocator() {
        return By.cssSelector("p.smallText");  // Localizatorul pentru textul de bun venit
    }

    // Returnează localizatorul pentru titlul de eroare
    public By errorTitleLocator() {
        return By.cssSelector("h1.title");  // Localizatorul pentru titlul de eroare
    }

    // Returnează localizatorul pentru textul de eroare
    public By errorTextLocator() {
        return By.cssSelector("p.error");  // Localizatorul pentru textul de eroare
    }

    // Verifică dacă un element este prezent pe pagină, pe baza unui localizator dat
    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();  // Verifică dacă lista de elemente găsite cu localizatorul dat nu este goală
    }
}