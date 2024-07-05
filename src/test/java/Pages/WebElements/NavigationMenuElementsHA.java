package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationMenuElementsHA {
    private WebDriver driver;  // Obiect WebDriver utilizat pentru a interacționa cu pagina web

    // Constructor care inițializează driverul pentru utilizare în această clasă
    public NavigationMenuElementsHA(WebDriver driver) {
        this.driver = driver;  // Stochează obiectul WebDriver pentru a-l folosi în metodele acestei clase
    }

    // Găsește și returnează linkul pentru deschiderea unui cont nou
    public WebElement openNewAccountLink() {
        // Folosește un selector XPath pentru a localiza linkul de deschidere a unui cont nou
        return driver.findElement(By.xpath("//a[@href='openaccount.htm']"));
    }

    // Găsește și returnează antetul pentru pagina de deschidere a unui cont
    public WebElement openAccountHeader() {
        // Folosește un selector XPath pentru a localiza antetul paginii de deschidere a unui cont
        return driver.findElement(By.xpath("//*[@id='openAccountForm']/h1"));
    }

    // Găsește și returnează linkul pentru vizualizarea generală a conturilor
    public WebElement accountsOverviewLink() {
        // Folosește un selector XPath pentru a localiza linkul de vizualizare generală a conturilor
        return driver.findElement(By.xpath("//a[@href='overview.htm']"));
    }

    // Găsește și returnează antetul pentru pagina de vizualizare generală a conturilor
    public WebElement accountsOverviewHeader() {
        // Folosește un selector XPath pentru a localiza antetul paginii de vizualizare generală a conturilor
        return driver.findElement(By.xpath("//*[@id='showOverview']/h1"));
    }

    // Găsește și returnează linkul pentru transferul de fonduri
    public WebElement transferFundsLink() {
        // Folosește un selector XPath pentru a localiza linkul de transfer de fonduri
        return driver.findElement(By.xpath("//a[@href='transfer.htm']"));
    }

    // Găsește și returnează antetul pentru pagina de transfer de fonduri
    public WebElement transferFundsHeader() {
        // Folosește un selector XPath pentru a localiza antetul paginii de transfer de fonduri
        return driver.findElement(By.xpath("//*[@id='showForm']/h1"));
    }

    // Găsește și returnează linkul pentru plata facturilor
    public WebElement billPayLink() {
        // Folosește un selector XPath pentru a localiza linkul de plată a facturilor
        return driver.findElement(By.xpath("//a[@href='billpay.htm']"));
    }

    // Găsește și returnează antetul pentru pagina de plată a facturilor
    public WebElement billPayHeader() {
        // Folosește un selector XPath pentru a localiza antetul paginii de plată a facturilor
        return driver.findElement(By.xpath("//*[@id='billpayForm']/h1"));
    }

    // Găsește și returnează linkul pentru găsirea tranzacțiilor
    public WebElement findTransactionsLink() {
        // Folosește un selector XPath pentru a localiza linkul de găsire a tranzacțiilor
        return driver.findElement(By.xpath("//a[@href='findtrans.htm']"));
    }

    // Găsește și returnează antetul pentru pagina de găsire a tranzacțiilor
    public WebElement findTransactionsHeader() {
        // Folosește un selector XPath pentru a localiza antetul paginii de găsire a tranzacțiilor
        return driver.findElement(By.xpath("//*[@id='formContainer']/h1"));
    }

    // Găsește și returnează linkul pentru actualizarea informațiilor de contact
    public WebElement updateContactInfoLink() {
        // Folosește un selector XPath pentru a localiza linkul de actualizare a informațiilor de contact
        return driver.findElement(By.xpath("//a[@href='updateprofile.htm']"));
    }

    // Găsește și returnează antetul pentru pagina de actualizare a informațiilor de contact
    public WebElement updateProfileHeader() {
        // Folosește un selector XPath pentru a localiza antetul paginii de actualizare a informațiilor de contact
        return driver.findElement(By.xpath("//*[@id='updateProfileForm']/h1"));
    }

    // Găsește și returnează linkul pentru cererea unui împrumut
    public WebElement requestLoanLink() {
        // Folosește un selector XPath pentru a localiza linkul de cerere a unui împrumut
        return driver.findElement(By.xpath("//a[@href='requestloan.htm']"));
    }

    // Găsește și returnează antetul pentru pagina de cerere a unui împrumut
    public WebElement requestLoanHeader() {
        // Folosește un selector XPath pentru a localiza antetul paginii de cerere a unui împrumut
        return driver.findElement(By.xpath("//*[@id='requestLoanForm']/h1"));
    }
}