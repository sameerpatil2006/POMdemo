package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPO <W extends WebElement> {

    @FindBy(id = "name_3_firstname")
    public W regName;

    @FindBy(id = "name_3_lastname")
    public  W regLastName;

    @FindBy(className = "input_fields")
    public  W radioField;


public void test(){
    System.out.println(radioField.getAttribute("value"));
}

}
