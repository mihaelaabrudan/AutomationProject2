package Pages.Actions;

import Pages.WebElements.LoginElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utile.ConfigLoader;

public class LoginHA {

    private LoginElementsHA elements;  // Obiect care conține elementele web pentru pagina de autentificare
    private ConfigLoader configLoader;  // Obiect ConfigLoader pentru încărcarea datelor de autentificare din fișierul de configurare

    // Constructor care inițializează elementele și fișierul de configurare
    public LoginHA(WebDriver driver) {
        elements = new LoginElementsHA(driver);  // Inițializarea elementelor pentru pagina de autentificare
        configLoader = new ConfigLoader("src/test/resources/propietati/dateUser2.properties");  // Încarcă fișierul de configurare cu datele de autentificare
    }

    // Completează câmpul de nume de utilizator cu valoarea specificată
    public void setMyUsername(String myUsername) {
        elements.myUsername().sendKeys(myUsername);  // Trimite valoarea în câmpul de nume de utilizator
    }

    // Completează câmpul de parolă cu valoarea specificată
    public void setMyPassword(String myPassword) {
        elements.myPassword().sendKeys(myPassword);  // Trimite valoarea în câmpul de parolă
    }

    // Face clic pe butonul de autentificare
    public void clickLoginButton() {
        elements.loginButton().click();  // Face clic pe butonul de autentificare
    }

    // Obține textul de bun venit afișat pe pagină
    public String getWelcomeText() {
        return elements.welcomeText().getText();  // Returnează textul de bun venit afișat
    }

    // Returnează elementul care conține textul de bun venit
    public WebElement getWelcomeTextElement() {
        return elements.welcomeText();  // Returnează WebElement-ul pentru textul de bun venit
    }

    // Verifică dacă textul de bun venit este prezent pe pagină
    public boolean isWelcomeTextPresent() {
        return elements.isElementPresent(elements.welcomeTextLocator());  // Verifică dacă textul de bun venit este prezent utilizând localizatorul
    }

    // Returnează WebElement-ul pentru antetul serviciilor de cont
    public WebElement getAccountServicesHeaderElement() {
        return elements.accountServicesHeader();  // Returnează WebElement-ul pentru antetul serviciilor de cont
    }

    // Verifică dacă titlul de eroare este prezent pe pagină
    public boolean isErrorTitlePresent() {
        return elements.isElementPresent(elements.errorTitleLocator());  // Verifică dacă titlul de eroare este prezent utilizând localizatorul
    }

    // Verifică dacă textul de eroare este prezent pe pagină
    public boolean isErrorTextPresent() {
        return elements.isElementPresent(elements.errorTextLocator());  // Verifică dacă textul de eroare este prezent utilizând localizatorul
    }

    // Verifică dacă antetul serviciilor de cont este prezent pe pagină
    public boolean isAccountServicesHeaderPresent() {
        return elements.isElementPresent(elements.accountServicesHeaderLocator());  // Verifică dacă antetul serviciilor de cont este prezent utilizând localizatorul
    }

    // Autentifică utilizatorul utilizând datele de autentificare din fișierul de configurare
    public void loginUser() {
        String myUsername = configLoader.getProperty("myusername");  // Obține numele de utilizator din fișierul de configurare
        String myPassword = configLoader.getProperty("mypassword");  // Obține parola din fișierul de configurare

        setMyUsername(myUsername);  // Completează câmpul de nume de utilizator
        setMyPassword(myPassword);  // Completează câmpul de parolă
        clickLoginButton();  // Face clic pe butonul de autentificare
    }

    // Obține prenumele utilizatorului din fișierul de configurare
    public String getFirstName() {
        return configLoader.getProperty("firstName");  // Returnează prenumele utilizatorului din fișierul de configurare
    }

    // Obține numele de familie al utilizatorului din fișierul de configurare
    public String getLastName() {
        return configLoader.getProperty("lastName");  // Returnează numele de familie al utilizatorului din fișierul de configurare
    }

    // Obține textul titlului de eroare afișat pe pagină
    public String getErrorTitle() {
        return elements.errorTitle().getText();  // Returnează textul titlului de eroare afișat
    }

    // Obține textul de eroare afișat pe pagină
    public String getErrorText() {
        return elements.errorText().getText();  // Returnează textul de eroare afișat
    }
}