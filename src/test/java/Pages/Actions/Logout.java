package Pages.Actions;

import Pages.WebElements.LogoutElements;
import org.openqa.selenium.WebDriver;

public class Logout {

    private LogoutElements elements;  // Obiect care conține elementele web pentru pagina de deconectare

    // Constructor care inițializează elementele de deconectare
    public Logout(WebDriver driver) {
        this.elements = new LogoutElements(driver);  // Inițializează obiectul LogoutElements pentru a accesa elementele de deconectare
    }

    // Face clic pe linkul de deconectare pentru a închide sesiunea utilizatorului
    public void clickLogout() {
        elements.logoutLink().click();  // Face clic pe elementul de link de deconectare pentru a închide sesiunea
    }
}