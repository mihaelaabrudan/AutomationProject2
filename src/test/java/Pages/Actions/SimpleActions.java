package Pages.Actions;

import Pages.WebElements.SimpleElements;
import org.openqa.selenium.WebDriver;

public class SimpleActions {
    private SimpleElements elements; //fac legatura intre clasa SimpleElements si SimpleActions

    public SimpleActions(WebDriver driver){
       this.elements = new SimpleElements(driver);
    }


    public String getLoginText(){
       return elements.logInText().getText();
    }


}
