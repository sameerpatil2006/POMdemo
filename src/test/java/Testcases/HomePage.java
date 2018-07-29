package Testcases;

import Utility.JSONProvider;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.CommonPO;


public class HomePage extends CommonSetup {

    protected CommonPO<WebElement> common;

    @BeforeClass
    public void classSetup(){
        getData("C:\\Users\\Sameer\\IdeaProjects\\DemoQA\\src\\test\\java\\Testcases\\HomePage.json");
        common = new CommonPO<>(driver);
        common.invokeRegistration();
    }

    @Test(dataProvider="getJSON_Data", dataProviderClass = JSONProvider.class)
    public void homePageLabel(String rowID, JSONObject data){
        String page = data.get("Label").toString();
        common.verifyPageText(page);
    }

    @AfterClass
    public void classTearDown() throws Exception{
    }
}
