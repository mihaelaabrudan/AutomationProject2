package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterElementsHA {
    private WebDriver driver = null;  // Obiect WebDriver utilizat pentru a interacționa cu pagina web

    // Constructor care inițializează driverul pentru utilizare în această clasă
    public RegisterElementsHA(WebDriver driver){
        this.driver = driver;  // Stochează obiectul WebDriver pentru a-l folosi în metodele acestei clase
    }

    // Găsește și returnează elementul care conține textul de înscriere
    public WebElement signUpText(){
        // Folosește un selector XPath pentru a localiza elementul <h1> care conține textul de înscriere
        return driver.findElement(By.xpath("//h1"));
    }

    // Găsește și returnează butonul pentru înregistrare
    public WebElement registerButton(){
        // Folosește un selector de tip linkText pentru a localiza butonul cu textul "Register"
        return driver.findElement(By.linkText("Register"));
    }

    // Găsește și returnează câmpul pentru numele de familie
    public WebElement firstname(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru numele de familie al clientului
        return driver.findElement(By.id("customer.firstName"));
    }

    // Găsește și returnează câmpul pentru prenumele clientului
    public WebElement lastname(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru prenumele clientului
        return driver.findElement(By.id("customer.lastName"));
    }

    // Găsește și returnează câmpul pentru adresa clientului
    public WebElement address(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru adresa clientului
        return driver.findElement(By.id("customer.address.street"));
    }

    // Găsește și returnează câmpul pentru orașul clientului
    public WebElement city(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru orașul clientului
        return driver.findElement(By.id("customer.address.city"));
    }

    // Găsește și returnează câmpul pentru statul clientului
    public WebElement state(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru statul clientului
        return driver.findElement(By.id("customer.address.state"));
    }

    // Găsește și returnează câmpul pentru codul poștal al clientului
    public WebElement zipCode(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru codul poștal al clientului
        return driver.findElement(By.id("customer.address.zipCode"));
    }

    // Găsește și returnează câmpul pentru numărul de telefon al clientului
    public WebElement phoneNumber(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru numărul de telefon al clientului
        return driver.findElement(By.id("customer.phoneNumber"));
    }

    // Găsește și returnează câmpul pentru numărul de asigurare socială (SSN) al clientului
    public WebElement ssn(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru SSN-ul clientului
        return driver.findElement(By.id("customer.ssn"));
    }

    // Găsește și returnează câmpul pentru numele de utilizator ales de client
    public WebElement username(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru numele de utilizator al clientului
        return driver.findElement(By.id("customer.username"));
    }

    // Găsește și returnează câmpul pentru parola aleasă de client
    public WebElement password(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru parola clientului
        return driver.findElement(By.id("customer.password"));
    }

    // Găsește și returnează câmpul pentru confirmarea parolei
    public WebElement confirm(){
        // Folosește un selector de tip ID pentru a localiza câmpul pentru confirmarea parolei
        return driver.findElement(By.id("repeatedPassword"));
    }

    // Găsește și returnează butonul pentru trimiterea formularului de înregistrare
    public WebElement submit(){
        // Folosește un selector CSS pentru a localiza butonul cu valoarea "Register" pentru trimiterea formularului
        return driver.findElement(By.cssSelector("input[type='submit'].button[value='Register']"));
    }

    // Găsește și returnează elementul care conține textul de conectare (de obicei același cu `signUpText()`)
    public WebElement loginText(){
        // Folosește un selector XPath pentru a localiza elementul <h1> care conține textul de conectare
        return driver.findElement(By.xpath("//h1"));
    }
}