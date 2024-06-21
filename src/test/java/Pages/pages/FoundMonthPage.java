package Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FoundMonthPage {

    private WebDriver driver;

    public FoundMonthPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAugust2024() {
        WebElement toolbarTitle = driver.findElement(By.cssSelector("h2.fc-toolbar-title"));
        return toolbarTitle.getText().equals("August 2024");
    }
}