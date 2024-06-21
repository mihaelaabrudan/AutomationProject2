package Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EventPage {

    private WebDriver driver;

    public EventPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteEvent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("viewDeleteEventButton")));
            deleteButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Elementul nu a fost găsit în timpul alocat: " + e.getMessage());
        }
    }
}