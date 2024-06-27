package Pages.Actions;

import Pages.WebElements.TrainingLinkElements;
import org.openqa.selenium.WebDriver;

public class TrainingLink {

    private TrainingLinkElements elements;

    public TrainingLink(WebDriver driver) {
        this.elements = new TrainingLinkElements(driver);
    }

    public void clickTraining() {
        elements.trainingLink().click();
    }
}