package Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public RegisterPage clickRegister() {
        // Găsește elementul 'Register' folosind un selector CSS
        WebElement registerLink = driver.findElement(By.cssSelector("a.navigation__link.register[href='/register']"));

        // Click pe elementul 'Register'
        registerLink.click();

        // Returnează o nouă instanță a clasei RegisterPage
        return new RegisterPage(driver);
    }

    public LoginPage clickLogin() {
        // Găsește elementul 'Register' folosind un selector CSS
        WebElement loginLink = driver.findElement(By.cssSelector("a.navigation__link.login[href='/login']"));

        // Click pe elementul 'Register'
        loginLink.click();

        // Returnează o nouă instanță a clasei RegisterPage
        return new LoginPage(driver);

    }

    // Metodă pentru a da click pe data specificată

    public AddEventPage clickCalendarDay() {
        // Găsește elementul
        WebElement dayElement = driver.findElement(By.id("fc-dom-275"));

        // Click pe elementul
        dayElement.click();

        // Returnează o nouă instanță a clasei RegisterPage
        return new AddEventPage(driver);


    }



}