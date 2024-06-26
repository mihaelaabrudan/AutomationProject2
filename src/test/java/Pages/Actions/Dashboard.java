package Actions;

import WebElements.DashboardElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    private DashboardElements elements = null;

    public Dashboard(WebDriver driver){
        elements = new DashboardElements(driver);
    }

    public String getUserEmailFromDashBoard(){
        return  elements.userNameDisplay().getText();
    }
}
