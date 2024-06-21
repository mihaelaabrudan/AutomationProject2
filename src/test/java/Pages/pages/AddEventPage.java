package Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEventPage {
    private WebDriver driver;
    private By eventTitleField = By.id("eventTitle");


    public AddEventPage(WebDriver driver) {

        this.driver = driver;

    }

    /*public void clickMonthView() {
        WebElement monthViewButton = driver.findElement(By.xpath("//button[@title='month view']"));
        monthViewButton.click();
    }

     */


    // Metodă pentru a goli câmpul de text al titlului evenimentului
    public void clearEventTitle() {
        driver.findElement(eventTitleField).clear();
    }

    // Metodă pentru a adăuga titlul evenimentului
    public void setEventTitle(String eventTitle) {
        driver.findElement(eventTitleField).sendKeys(eventTitle);
    }


    // Metodă pentru a apasa butonul de creare a evenimentului
    public void clickCreateEventButton() {
        WebElement createEventButton = driver.findElement(By.id("createEventButton"));
        createEventButton.click();
    }


}