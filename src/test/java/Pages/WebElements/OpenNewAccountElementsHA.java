package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenNewAccountElementsHA {
    private WebDriver driver;  // Obiect WebDriver utilizat pentru a interacționa cu pagina web

    // Constructor care inițializează driverul pentru utilizare în această clasă
    public OpenNewAccountElementsHA(WebDriver driver) {
        this.driver = driver;  // Stochează obiectul WebDriver pentru a-l folosi în metodele acestei clase
    }

    // Găsește și returnează linkul pentru deschiderea unui cont nou
    public WebElement openAccountLink() {
        // Folosește un selector de tip linkText pentru a localiza linkul "Open New Account"
        return driver.findElement(By.linkText("Open New Account"));
    }

    // Găsește și returnează dropdown-ul pentru selectarea tipului de cont
    public WebElement accountTypeDropdown() {
        // Folosește un selector de tip ID pentru a localiza dropdown-ul cu ID-ul "type"
        return driver.findElement(By.id("type"));
    }

    // Găsește și returnează dropdown-ul pentru selectarea contului sursă
    public WebElement fromAccountIdDropdown() {
        // Folosește un selector de tip ID pentru a localiza dropdown-ul cu ID-ul "fromAccountId"
        return driver.findElement(By.id("fromAccountId"));
    }

    // Găsește și returnează butonul pentru deschiderea unui nou cont
    public WebElement openAccountButton() {
        // Folosește un selector CSS pentru a localiza butonul cu valoarea "Open New Account"
        return driver.findElement(By.cssSelector("input.button[value='Open New Account']"));
    }

    // Găsește și returnează titlul care indică faptul că un cont a fost deschis
    public WebElement accountOpenedTitle() {
        // Folosește un selector XPath pentru a localiza antetul paginii care confirmă deschiderea unui cont
        return driver.findElement(By.xpath("//*[@id='openAccountResult']/h1"));
    }

    // Găsește și returnează mesajul care confirmă că un cont a fost deschis
    public WebElement accountOpenedMessage() {
        // Folosește un selector XPath pentru a localiza paragraful care conține mesajul de confirmare
        return driver.findElement(By.xpath("//p[contains(text(), 'Congratulations, your account is now open.')]"));
    }

    // Găsește și returnează elementul care conține ID-ul noului cont deschis
    public WebElement newAccountId() {
        // Folosește un selector de tip ID pentru a localiza elementul cu ID-ul "newAccountId"
        return driver.findElement(By.id("newAccountId"));
    }

    // Găsește și returnează linkul pentru vizualizarea generală a conturilor
    public WebElement accountsOverviewLink() {
        // Folosește un selector de tip linkText pentru a localiza linkul "Accounts Overview"
        return driver.findElement(By.linkText("Accounts Overview"));
    }

    // Găsește și returnează linkul pentru vizualizarea activității unui cont specific, folosind ID-ul contului
    public WebElement getAccountOverviewLink(String accountId) {
        // Folosește un selector XPath pentru a construi și localiza linkul pentru activitatea unui cont specific
        return driver.findElement(By.xpath("//a[@href='activity.htm?id=" + accountId + "']"));
    }
}