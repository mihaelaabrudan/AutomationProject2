package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateContactInfoElementsHA {
    private WebDriver driver;  // Obiectul WebDriver utilizat pentru a interacționa cu elementele paginii web

    // Constructor care inițializează driverul pentru utilizare în această clasă
    public UpdateContactInfoElementsHA(WebDriver driver) {
        this.driver = driver;  // Stochează obiectul WebDriver pentru a-l folosi în metodele acestei clase
    }

    // Găsește și returnează link-ul pentru secțiunea "Update Contact Info"
    public WebElement updateContactInfoLink() {
        // Folosește un selector de tip linkText pentru a localiza link-ul cu textul "Update Contact Info"
        return driver.findElement(By.linkText("Update Contact Info"));
    }

    // Găsește și returnează câmpul pentru introducerea noului număr de telefon
    public WebElement phoneNumberField() {
        // Folosește un selector de tip id pentru a localiza câmpul de introducere a numărului de telefon
        return driver.findElement(By.id("customer.phoneNumber"));
    }

    // Găsește și returnează butonul pentru actualizarea profilului
    public WebElement updateProfileButton() {
        // Folosește un selector CSS pentru a localiza butonul cu tipul 'button' și valoarea 'Update Profile'
        return driver.findElement(By.cssSelector("input[type='button'].button[value='Update Profile']"));
    }

    // Găsește și returnează titlul care indică faptul că profilul a fost actualizat
    public WebElement profileUpdatedTitle() {
        // Folosește un selector XPath pentru a localiza elementul <h1> care confirmă actualizarea profilului
        return driver.findElement(By.xpath("//*[@id='updateProfileResult']/h1"));
    }
}