package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonPO <W extends WebElement> {

    WebDriver driver;

    public CommonPO(WebDriver driver){
        {
            this.driver= driver;
            PageFactory.initElements(driver,this);
        }
    }

    @FindBy(linkText = "Home")
    public W home;

    @FindBy(linkText = "About us")
    public W aboutUs;

    @FindBy(linkText = "Services")
    public W services;

    @FindBy(className = "dropdown-toggle")
    public W demoMenu;

    @FindBy(linkText = "Blog")
    public W blog;

    @FindBy(linkText = "Contact")
    public W contact;

    @FindBy(css = "img[src*='Tools-QA-213.png']")
    public W logo;

    @FindBy(className = "entry-title")
    public W titleText;

    @FindBy(linkText = "Registration")
    public W registrationLink;

    public void invokeRegistration(){
        registrationLink.click();
    }
    /**
     *
     * @param text
     */
    public void verifyPageText(String text){

        String label = text;
        String title = null;

        switch (label){
           case "Home":
               title = home.getText();
               break;
           case "About us" :
               title = aboutUs.getText();
               break;
           case "Services" :
               title = services.getText();
               break;
           case "Demo" :
                title = demoMenu.getText();
                break;
           case "Blog" :
                title = blog.getText();
                break;
           case "Contact" :
                title = contact.getText();
                break;
       }
        Assert.assertEquals(title,label);
    }
}
