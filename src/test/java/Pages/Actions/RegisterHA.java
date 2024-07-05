package Pages.Actions;

import Pages.WebElements.RegisterElementsHA;
import org.openqa.selenium.WebDriver;
import utile.ConfigLoader;

public class RegisterHA {

    private RegisterElementsHA elementss = null;  // Obiect care conține elementele web pentru înregistrare
    private ConfigLoader configLoader;  // Obiect pentru încărcarea proprietăților de configurare

    // Constructor care inițializează elementele de înregistrare
    public RegisterHA(WebDriver driver) {
        elementss = new RegisterElementsHA(driver);  // Inițializează obiectul RegisterElementsHA pentru a accesa elementele de pe pagina de înregistrare
    }

    // Obține textul de pe pagina de înscriere
    public String getSignUpText() {
        return elementss.signUpText().getText();  // Returnează textul elementului de înscriere
    }

    // Face clic pe butonul de înregistrare
    public void clickRegisterButton() {
        elementss.registerButton().click();  // Face clic pe butonul de înregistrare
    }

    // Setează numele de familie în câmpul de înregistrare
    public void setfirstname(String firstname) {
        elementss.firstname().sendKeys(firstname);  // Introduce numele de familie în câmpul corespunzător
    }

    // Setează prenumele în câmpul de înregistrare
    public void setlastname(String lastname) {
        elementss.lastname().sendKeys(lastname);  // Introduce prenumele în câmpul corespunzător
    }

    // Setează adresa în câmpul de înregistrare
    public void setaddress(String address) {
        elementss.address().sendKeys(address);  // Introduce adresa în câmpul corespunzător
    }

    // Setează orașul în câmpul de înregistrare
    public void setcity(String city) {
        elementss.city().sendKeys(city);  // Introduce orașul în câmpul corespunzător
    }

    // Setează statul în câmpul de înregistrare
    public void setstate(String state) {
        elementss.state().sendKeys(state);  // Introduce statul în câmpul corespunzător
    }

    // Setează codul poștal în câmpul de înregistrare
    public void setzipCode(String zipCode) {
        elementss.zipCode().sendKeys(zipCode);  // Introduce codul poștal în câmpul corespunzător
    }

    // Setează numărul de telefon în câmpul de înregistrare
    public void setphoneNumber(String phoneNumber) {
        elementss.phoneNumber().sendKeys(phoneNumber);  // Introduce numărul de telefon în câmpul corespunzător
    }

    // Setează SSN (Numărul de Securitate Socială) în câmpul de înregistrare
    public void setssn(String ssn) {
        elementss.ssn().sendKeys(ssn);  // Introduce SSN-ul în câmpul corespunzător
    }

    // Setează numele de utilizator în câmpul de înregistrare
    public void setusername(String username) {
        elementss.username().sendKeys(username);  // Introduce numele de utilizator în câmpul corespunzător
    }

    // Setează parola în câmpul de înregistrare
    public void setpassword(String password) {
        elementss.password().sendKeys(password);  // Introduce parola în câmpul corespunzător
    }

    // Setează confirmarea parolei în câmpul de înregistrare
    public void setconfirm(String confirm) {
        elementss.confirm().sendKeys(confirm);  // Introduce confirmarea parolei în câmpul corespunzător
    }

    // Trimite formularul de înregistrare
    public void submit() {
        elementss.submit().click();  // Face clic pe butonul de trimitere a formularului
    }

    // Obține textul de pe pagina de autentificare
    public String getLoginText() {
        return elementss.loginText().getText();  // Returnează textul elementului de autentificare
    }

    // Înregistrează un utilizator folosind datele încărcate din fișierul de proprietăți
    public void registerUser(boolean isTrainer) {
        // Încarcă proprietățile utilizatorului din fișierul de configurare
        configLoader = new ConfigLoader("src/test/resources/propietati/dateUser2.properties");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zipCode = configLoader.getProperty("zipCode");
        String phoneNumber = configLoader.getProperty("phoneNumber");
        String ssn = configLoader.getProperty("ssn");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String confirm = configLoader.getProperty("confirm");

        // Completează formularul de înregistrare cu datele din fișierul de proprietăți
        setfirstname(firstName);
        setlastname(lastName);
        setaddress(address);
        setcity(city);
        setstate(state);
        setzipCode(zipCode);
        setphoneNumber(phoneNumber);
        setssn(ssn);
        setusername(username);
        setpassword(password);
        setconfirm(confirm);
        submit();  // Trimite formularul completat
    }
}