package Testcases;

import PageObjects.HomePagePO;
import Utility.JSONProvider;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.CommonPO;


public class HomePage extends CommonSetup {

    protected CommonPO<WebElement> common;
    protected HomePagePO<WebElement> home;

    @BeforeClass
    public void classSetup(){
        getData("C:\\Users\\Sameer\\IdeaProjects\\DemoQA\\src\\test\\java\\Testcases\\HomePage.json");
        common = new CommonPO<>(driver);
        home = new HomePagePO<>(driver);
    }

    @BeforeMethod
    public void methodSetup(){

    }

    @Test(dataProvider="getJSON_Data", dataProviderClass = JSONProvider.class)
    public void homePageLabel(String rowID, JSONObject data){
        String page = data.get("Label").toString();
        common.verifyPageText(page);
    }

    @Test(dataProvider="getJSON_Data", dataProviderClass = JSONProvider.class)
    public void homePageLinks(String rowID, JSONObject data) throws Exception {
        String url = data.get("feature").toString();
        common.verifyUrl(url);
    }

    @Test(dataProvider = "getJSON_Data", dataProviderClass = JSONProvider.class)
    public void homePageTabs(String rowID, JSONObject data) throws Exception{
        String tab = data.get("tab").toString();
        String contents = data.get("contents").toString();
        home.verifyHomePageTabs(tab,contents);

    }

    @AfterClass
    public void classTearDown() throws Exception{
    }
}
