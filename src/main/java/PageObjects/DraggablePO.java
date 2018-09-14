package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DraggablePO<W extends WebElement> extends CommonPO {

    Actions act = new Actions(driver);
    @FindBy(id = "draggable")
    public W drag;

    @FindBy(id = "draggabl")
    public W dragVertical;

    @FindBy(linkText = "Default functionality")
    public W dragTab1;

    @FindBy(linkText = "Constrain movement")
    public W dragTab2;

    @FindBy(id = "draggabl2")
    public W dragHorizontal;

    @FindBy(linkText = "Events")
    public W events;

    @FindBy(id = "dragevent")
    public W eventDrag;

    @FindBy(css = "#event-stop > span.count")
    public W stop;

    @FindBy(css = "#event-start > span.count")
    public W start;


    @FindBy(linkText = "Events")
    public W dragEvent;

    public DraggablePO(WebDriver driver) {
        super(driver);
    }

    /***
     *
     * @param xSet
     * @param ySet
     */
    public void dragMe(int xSet, int ySet, String type){
        WebElement dragMe = null;
        int left = 0, top = 0;
       switch (type) {
           case "FreeDrag" :
               dragMe = drag;
               act.dragAndDropBy(dragMe,xSet,ySet).build().perform();
               left = Integer.parseInt(dragMe.getCssValue("left").replace("px",""));
               top = Integer.parseInt(dragMe.getCssValue("top").replace("px",""));
               break;
           case "Vertical" :
               dragTab2.click();
               dragMe = dragVertical;
               act.dragAndDropBy(dragMe,xSet,ySet).build().perform();
               top = Integer.parseInt(dragMe.getCssValue("top").replace("px",""));
               break;
           case "Horizontal" :
               dragTab2.click();
               dragMe = dragHorizontal;
               act.dragAndDropBy(dragMe,xSet,ySet).build().perform();
               left = Integer.parseInt(dragMe.getCssValue("left").replace("px",""));
               break;
       }
       Assert.assertEquals(left,xSet);
       Assert.assertEquals(top,ySet);
}

public void verifyEvent(String type, String expected){
        String actual = null;
        dragEvent.click();

        switch (type){
            case "beforeStart" :
                actual = start.getText();
                expected = "0";
                break;
            case "afterStart" :
                act.dragAndDropBy(eventDrag,50,400).build().perform();
                actual = start.getText();
                expected = "1";
                break;
            case "beforeStop" :
                driver.navigate().refresh();
                dragEvent.click();
                actual = stop.getText();
                expected = "0";
                break;
            case "afterStop" :
                act.dragAndDropBy(eventDrag,50,400).build().perform();
                actual = stop.getText();
                expected = "1";
                break;

        }

        Assert.assertEquals(actual,expected);

}
}

