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

    @FindBy(linkText = "Draggable")
    public W draggableLink;

    @FindBy(linkText = "Droppable")
    public W droppableLink;

    @FindBy(linkText = "Resizable")
    public W resizableLink;

    @FindBy(linkText = "Selectable")
    public W selectableLink;

    @FindBy(linkText = "Sortable")
    public W sortableLink;

    @FindBy(linkText = "Accordion")
    public W accordionLink;

    @FindBy(linkText = "Autocomplete")
    public W autocompleteLink;

    @FindBy(linkText = "Datepicker")
    public W datepickerLink;

    @FindBy(linkText = "Menu")
    public W menuLink;

    @FindBy(linkText = "Slider")
    public W sliderLink;

    @FindBy(linkText = "Tabs")
    public W tabsLink;

    @FindBy(linkText = "Tooltip")
    public W tooltipLink;

    @FindBy(linkText = "Frames and windows")
    public W framesLink;


    /**
     * click on registration
     */
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

    public void verifyUrl(String urlType) throws Exception{
        String currentUrl = null;
        String urlPrefix = "http://demoqa.com/";
        switch (urlType){
            case "registration" :
                registrationLink.click();
                currentUrl = driver.getCurrentUrl();
                break;
            case "draggable" :
                draggableLink.click();
                currentUrl = driver.getCurrentUrl();
                break;
            case "droppable" :
                droppableLink.click();
                currentUrl = driver.getCurrentUrl();
                break;
            case "resizable" :
                resizableLink.click();
                currentUrl = driver.getCurrentUrl();
                break;

            case "selectable" :
                selectableLink.click();
                currentUrl = driver.getCurrentUrl();
                break;
            case "sortable" :
                sortableLink.click();
                currentUrl = driver.getCurrentUrl();
                break;

            case "accordion" :
                accordionLink.click();
                currentUrl = driver.getCurrentUrl();
                break;
            case "autocomplete" :
                autocompleteLink.click();
                currentUrl = driver.getCurrentUrl();
                break;

            case "datepicker" :
                datepickerLink.click();
                currentUrl = driver.getCurrentUrl();
                break;
            case "menu" :
                menuLink.click();
                currentUrl = driver.getCurrentUrl();
                break;

            case "slider" :
                sliderLink.click();
                currentUrl = driver.getCurrentUrl();
                break;

            case "tabs" :
                tabsLink.click();
                currentUrl = driver.getCurrentUrl();
                break;

            case "tooltip" :
                tooltipLink.click();
                currentUrl = driver.getCurrentUrl();
                break;

            case "frames-and-windows" :
                framesLink.click();
                currentUrl = driver.getCurrentUrl();
                break;
        }
        Assert.assertEquals(currentUrl, urlPrefix + urlType + "/");
    }


    public void goTo(String pageName){
        switch (pageName){
            case "registration" :
                registrationLink.click();
                break;

            case "draggable" :
                draggableLink.click();
                break;

            case "droppable" :
                droppableLink.click();
                break;
        }

    }
}
