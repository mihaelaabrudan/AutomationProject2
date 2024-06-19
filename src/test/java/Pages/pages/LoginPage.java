package Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("userEmail");
    private By passwordField = By.id("userPassword");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setemail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);

    }

    public void setPassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);

    }

    public void submitButton() {
        // Găsește butonul de submit folosind id-ul său
        WebElement submitbutton = driver.findElement(By.id("submitButton"));

        // Verifică dacă butonul este activat (nu are atributul disabled)
        if (submitbutton.isEnabled()) {
            // Apasă butonul de submit
            submitbutton.click();
        }


    }





}
