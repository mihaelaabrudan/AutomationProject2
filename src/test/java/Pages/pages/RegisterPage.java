package Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterPage {

    private WebDriver driver;

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By phoneNumberField = By.id("phoneNumber");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By cityField = By.id("city");




    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setfirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);

    }

    public void setlastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);

    }

    public void setphoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);

    }

    public void setemail(String email) {
        driver.findElement(emailField).sendKeys(email);

    }


    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);

    }

    public void setcity(String city) {
        driver.findElement(cityField).sendKeys(city);

    }


    /*// Metodă pentru a bifa checkbox-ul cu id-ul "customer"
    public void checkCustomer() {
        // Găsește checkbox-ul folosind id-ul său
        WebElement customerCheckbox = driver.findElement(By.id("customer"));

        // Verifică dacă checkbox-ul nu este deja bifat
        if (!customerCheckbox.isSelected()) {
            // Bifează checkbox-ul
            customerCheckbox.click();
        }
    }
    */

    // Metodă pentru a bifa checkbox-ul cu id-ul "customer"
    public void checkCustomer() {
        WebElement customerCheckbox = driver.findElement(By.id("customer"));
        if (!customerCheckbox.isSelected()) {
            customerCheckbox.click();
        }
    }

    // Metodă pentru a bifa checkbox-ul cu id-ul "trainer"
    public void checkTrainer() {
        WebElement trainerCheckbox = driver.findElement(By.id("trainer"));
        if (!trainerCheckbox.isSelected()) {
            trainerCheckbox.click();
        }
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        if (submitButton.isEnabled()) {
            submitButton.click();
        }
    }
}