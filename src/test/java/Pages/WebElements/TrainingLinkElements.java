package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainingLinkElements {
    private WebDriver driver;

    public TrainingLinkElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement trainingLink() {
        return driver.findElement(By.cssSelector(".navigation__link.trainings"));
    }
}