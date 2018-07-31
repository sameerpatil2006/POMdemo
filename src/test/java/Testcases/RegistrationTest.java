package Testcases;

import PageObjects.CommonPO;
import PageObjects.RegistrationPO;
import Utility.JSONProvider;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RegistrationTest extends CommonSetup {

    protected CommonPO<WebElement> common;
    protected RegistrationPO<WebElement> registrationPO;

    @BeforeClass
    public void registrationSetup(){
        common = new CommonPO<>(driver);
        registrationPO = new RegistrationPO<>(driver);
        common.invokeRegistration();
        getData("C:\\Users\\Sameer\\IdeaProjects\\DemoQA\\src\\test\\java\\Testcases\\Registration.json");
    }

    @BeforeMethod
    public void beforeMethod(){
    }

    @AfterMethod
    public void afterMethod(){
        common.invokeRegistration();
    }

    @Test(dataProvider = "getJSON_Data", dataProviderClass = JSONProvider.class)
    public void registrationForm(String rowID, JSONObject testData){
        String name = testData.get("name").toString();
        String lastName = testData.get("lastName").toString();
        String maritalStatus = testData.get("maritalStatus").toString();
        String hobby = testData.get("hobby").toString();
        String country = testData.get("country").toString();
        JSONArray dob = (JSONArray) testData.get("dob");
        String month = dob.get(0).toString();
        String day =  dob.get(1).toString();
        String year = dob.get(2).toString();
        String number = testData.get("phone").toString();
        String userName = testData.get("userName").toString().replace("[RAND]",RandomStringUtils.randomAlphabetic(8));
        String email = userName + "@gmail.com" ;
        String desc = testData.get("about").toString();
        String password = testData.get("password").toString();
        String confPwd = testData.get("confPwd").toString();
        String msg = testData.get("msg").toString();

        List<String> regList = new ArrayList<String>(){{
            add(name);
            add(lastName);
            add(maritalStatus);
            add(country);
            add(month);
            add(day);
            add(year);
            add(desc);
            add(hobby);
            add(number);
            add(userName);
            add(email);
            add(password);
            add(confPwd);
        }};
        registrationPO.verifyMsg(regList,msg);
    }
}
