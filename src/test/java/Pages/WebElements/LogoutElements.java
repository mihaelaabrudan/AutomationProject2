package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutElements {
    private WebDriver driver;  // Obiect WebDriver utilizat pentru a interacționa cu pagina web

    // Constructor care inițializează driverul pentru utilizare în această clasă
    public LogoutElements(WebDriver driver) {
        this.driver = driver;  // Stochează obiectul WebDriver pentru a-l folosi în metodele acestei clase
    }

    // Returnează elementul de link pentru deconectare
    public WebElement logoutLink() {
        // Găsește și returnează linkul de deconectare folosind selectorul CSS
        return driver.findElement(By.cssSelector(".navigation__link.logout"));
    }
}