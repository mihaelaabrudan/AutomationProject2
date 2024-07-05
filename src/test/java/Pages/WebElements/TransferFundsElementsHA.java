package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFundsElementsHA {
    private WebDriver driver;  // Obiectul WebDriver utilizat pentru a interacționa cu elementele paginii web

    // Constructor care inițializează driverul pentru utilizare în această clasă
    public TransferFundsElementsHA(WebDriver driver) {
        this.driver = driver;  // Stochează obiectul WebDriver pentru a-l folosi în metodele acestei clase
    }

    // Găsește și returnează link-ul pentru secțiunea "Transfer Funds"
    public WebElement transferFundsLink() {
        // Folosește un selector de tip linkText pentru a localiza link-ul cu textul "Transfer Funds"
        return driver.findElement(By.linkText("Transfer Funds"));
    }

    // Găsește și returnează câmpul pentru introducerea sumei de transfer
    public WebElement amountField() {
        // Folosește un selector de tip id pentru a localiza câmpul de introducere a sumei de transfer
        return driver.findElement(By.id("amount"));
    }

    // Găsește și returnează dropdown-ul pentru selectarea contului de proveniență
    public WebElement fromAccountDropdown() {
        // Folosește un selector de tip id pentru a localiza dropdown-ul pentru selectarea contului de proveniență
        return driver.findElement(By.id("fromAccountId"));
    }

    // Găsește și returnează dropdown-ul pentru selectarea contului de destinație
    public WebElement toAccountDropdown() {
        // Folosește un selector de tip id pentru a localiza dropdown-ul pentru selectarea contului de destinație
        return driver.findElement(By.id("toAccountId"));
    }

    // Găsește și returnează butonul pentru efectuarea transferului
    public WebElement transferButton() {
        // Folosește un selector CSS pentru a localiza butonul cu tipul 'submit' și valoarea 'Transfer'
        return driver.findElement(By.cssSelector("input[type='submit'].button[value='Transfer']"));
    }

    // Găsește și returnează titlul care indică finalizarea transferului
    public WebElement transferCompleteTitle() {
        // Folosește un selector XPath pentru a localiza elementul <h1> care indică finalizarea transferului
        // Comentariul sugerează că a existat o alternativă folosind selectorul CSS, dar XPath este folosit aici
        return driver.findElement(By.xpath("//*[@id='showResult']/h1"));
        // return driver.findElement(By.cssSelector("h1.title"));  // Alternativă comentată
    }

    // Găsește și returnează elementul care afișează suma transferată
    public WebElement amountResult() {
        // Folosește un selector de tip id pentru a localiza elementul care afișează suma transferată
        return driver.findElement(By.id("amountResult"));
    }

    // Găsește și returnează elementul care afișează ID-ul contului de proveniență
    public WebElement fromAccountIdResult() {
        // Folosește un selector de tip id pentru a localiza elementul care afișează ID-ul contului de proveniență
        return driver.findElement(By.id("fromAccountIdResult"));
    }

    // Găsește și returnează elementul care afișează ID-ul contului de destinație
    public WebElement toAccountIdResult() {
        // Folosește un selector de tip id pentru a localiza elementul care afișează ID-ul contului de destinație
        return driver.findElement(By.id("toAccountIdResult"));
    }
}