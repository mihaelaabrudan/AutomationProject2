package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionHistoryElementsHA {
    private WebDriver driver;  // Obiectul WebDriver utilizat pentru a interacționa cu elementele paginii web

    // Constructor care inițializează driverul pentru utilizare în această clasă
    public TransactionHistoryElementsHA(WebDriver driver) {
        this.driver = driver;  // Stochează obiectul WebDriver pentru a-l folosi în metodele acestei clase
    }

    // Găsește și returnează link-ul pentru vizualizarea tuturor conturilor
    public WebElement accountsOverviewLink() {
        // Folosește un selector de tip linkText pentru a localiza link-ul cu textul "Accounts Overview"
        return driver.findElement(By.linkText("Accounts Overview"));
    }

    // Găsește și returnează link-ul unui cont specific, bazat pe ID-ul contului
    public WebElement accountLink(String accountId) {
        // Folosește un selector XPath pentru a localiza link-ul pentru un cont specific, bazat pe ID-ul acestuia
        return driver.findElement(By.xpath("//a[@href='activity.htm?id=" + accountId + "']"));
    }

    // Găsește și returnează link-ul pentru o tranzacție specifică, bazat pe ID-ul tranzacției
    public WebElement transactionLink(String transactionId) {
        // Folosește un selector XPath pentru a localiza link-ul pentru o tranzacție specifică, bazat pe ID-ul acesteia
        return driver.findElement(By.xpath("//a[@href='transaction.htm?id=" + transactionId + "']"));
    }

    // Găsește și returnează descrierea tranzacției, căutând după textul specific "Bill Payment to Alexandra Pop"
    public WebElement transactionDescription() {
        // Folosește un selector XPath pentru a localiza elementul <td> care conține textul "Bill Payment to Alexandra Pop"
        return driver.findElement(By.xpath("//td[text()='Bill Payment to Alexandra Pop']"));
    }

    // Găsește și returnează suma tranzacției, căutând după textul specific "$2.00"
    public WebElement transactionAmount() {
        // Folosește un selector XPath pentru a localiza elementul <td> care conține textul "$2.00"
        return driver.findElement(By.xpath("//td[text()='$2.00']"));
    }
}