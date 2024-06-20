package Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.time.Duration;


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

    /*public AddEventPage clickCalendarDay() {
        // Găsește elementul
        // Așteaptă până când elementul este prezent
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // WebElement dayElement1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='fc-daygrid-day-frame fc-scrollgrid-sync-inner']//a[@aria-label='June 30, 2024']")));
        WebElement dayElement2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='fc-daygrid-day-frame fc-scrollgrid-sync-inner']//a[@aria-label='June 24, 2024']")));
       // WebElement dayElement3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='fc-daygrid-day-frame fc-scrollgrid-sync-inner']//a[@aria-label='June 26, 2024']")));
       // WebElement dayElement4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='fc-daygrid-day-frame fc-scrollgrid-sync-inner']//a[@aria-label='June 28, 2024']")));


        // Click pe elementul
       // dayElement1.click();
        dayElement2.click();
        //dayElement3.click();
        //dayElement4.click();

        // Returnează o nouă instanță a clasei RegisterPage
        return new AddEventPage(driver);


    }

     */

    // Metodă pentru a da click pe data specificată
    public AddEventPage clickCalendarDay(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            WebElement dayElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='fc-daygrid-day-frame fc-scrollgrid-sync-inner']//a[@aria-label='" + date + "']")));
            dayElement.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Elementul nu a fost găsit în timpul alocat: " + e.getMessage());
            // Poți arunca o excepție sau poți face o altă acțiune aici
        }

        return new AddEventPage(driver);
    }



}