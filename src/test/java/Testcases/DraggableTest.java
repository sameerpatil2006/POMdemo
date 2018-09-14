package Testcases;

import PageObjects.CommonPO;
import PageObjects.DraggablePO;
import Utility.JSONProvider;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DraggableTest extends CommonSetup {
    protected DraggablePO<WebElement> draggable;
    protected CommonPO<WebElement> common;
    protected DraggablePO<WebElement> draggablePO;

    @BeforeTest
    public void beforeTest() {
        common = new CommonPO<>(driver);
        draggable = new DraggablePO<>(driver);
        common.goTo("draggable");
        getData("C:\\Users\\Sameer\\IdeaProjects\\DemoQA\\src\\test\\java\\Testcases\\Draggable.json");
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @Test(dataProvider = "getJSON_Data", dataProviderClass = JSONProvider.class)
    public void dragTest(String rowID, JSONObject data) throws Exception {
        int xSet = Integer.parseInt(data.get("xset").toString());
        int ySet = Integer.parseInt(data.get("yset").toString());
        String type = data.get("type").toString();

        draggable.dragMe(xSet, ySet, type);
    }

    @Test(dataProvider = "getJSON_Data", dataProviderClass = JSONProvider.class)
    public void dragEvent(String rowID, JSONObject data) throws Exception {

        String type = data.get("type").toString();
        String expected = data.get("expected").toString();
        draggable.verifyEvent(type,expected);
    }
}