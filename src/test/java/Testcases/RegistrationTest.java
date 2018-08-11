package Testcases;

import PageObjects.CommonPO;
import PageObjects.Registration;
import PageObjects.RegistrationPO;
import Utility.JSONProvider;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationTest extends CommonSetup {

    protected CommonPO<WebElement> common;
    protected RegistrationPO<WebElement> registrationPO;

    @BeforeClass
    public void registrationSetup() {
        common = new CommonPO<>(driver);
        registrationPO = new RegistrationPO<>(driver);
        common.invokeRegistration();
        getData("C:\\Users\\Sameer\\IdeaProjects\\DemoQA\\src\\test\\java\\Testcases\\Registration.json");
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod
    public void afterMethod() {
        common.invokeRegistration();
    }

    @Test(dataProvider = "getJSON_Data", dataProviderClass = JSONProvider.class)
    public void registrationForm(String rowID, JSONObject testData) {
        String name = testData.get("name").toString();
        String lastName = testData.get("lastName").toString();
        List<String> maritalStatus = (List<String>) testData.get("maritalStatus");
        List<String> hobby = (List<String>) testData.get("hobby");
        String country = testData.get("country").toString();
        List<Long> dob = (List<Long>) testData.get("dob");
        String number = testData.get("phone").toString();
        String userName = testData.get("userName").toString().replace("[RAND]", RandomStringUtils.randomAlphabetic(8));
        String email = userName + "@gmail.com";
        String desc = testData.get("about").toString();
        String password = testData.get("password").toString();
        String confPwd = testData.get("confPwd").toString();
        String msg = testData.get("msg").toString();
        String testType = testData.get("description").toString();

        if (testType.equalsIgnoreCase("loginError")) {
            email = "sad@gmail.com";
        }
        Registration registration = new Registration.Builder().name(name).lastName(lastName).dob(dob).hobby(hobby).status(maritalStatus).password(password).email(email).confmPassword(confPwd).number(number).country(country).usrNm(userName).desc(desc).build();
        registrationPO.verifyMsg(registration, msg, testType);
    }


    @Test(dataProvider = "getJSON_Data", dataProviderClass = JSONProvider.class)
    public void passwordStrength(String rowID, JSONObject testData) throws Exception {

        String password = testData.get("password").toString();
        String confmPassword = testData.get("confPwd").toString();
        String msg = testData.get("msg").toString();
        String color = testData.get("color").toString();

        Registration registration = new Registration.Builder().password(password).confmPassword(confmPassword).build();
        registrationPO.verifyStrengthButton(registration, msg, color);

    }

    /*@Test(dataProvider = "getJSON_Data", dataProviderClass = JSONProvider.class)
    public void passwordIndicatorColor(String rowID, JSONObject testData) throws Exception {

        String password = testData.get("password").toString();
        String confmPassword = testData.get("confPwd").toString();
        String passwordType = testData.get("passwordType").toString();

        Registration registration = new Registration.Builder().password(password).confmPassword(confmPassword).build();
        registrationPO.verifyColor(registration, passwordType);

    }*/
}



 /* List<String> regList = new ArrayList<String>(){{
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
        }};*/

/*
  "passwordIndicatorColor" : [
    {
      "rowID" : "passwordIndicatorColor.01",
      "description" : "",
      "name": "",
      "lastName": "",
      "maritalStatus": [],
      "hobby": [],
      "country": "",
      "dob": [],
      "phone": "",
      "userName": "",
      "email": "",
      "about": "",
      "password": "Hello123456!",
      "confPwd" : "Hello123",
      "msg": "Mismatch"
    },

    {
      "rowID" : "passwordIndicatorColor.02",
      "description" : "",
      "name": "",
      "lastName": "",
      "maritalStatus": [],
      "hobby": [],
      "country": "",
      "dob": [],
      "phone": "",
      "userName": "",
      "email": "",
      "about": "",
      "password": "",
      "confPwd" : "",
      "msg": "Strength Indicator"
    },

    {
      "rowID" : "passwordIndicatorColor.03",
      "description" : "",
      "name": "",
      "lastName": "",
      "maritalStatus": [],
      "hobby": [],
      "country": "",
      "dob": [],
      "phone": "",
      "userName": "",
      "email": "",
      "about": "",
      "password": "qwerty",
      "confPwd" : "",
      "msg": "Very weak"
    },

    {
      "rowID" : "passwordIndicatorColor.04",
      "description" : "",
      "name": "",
      "lastName": "",
      "maritalStatus": [],
      "hobby": [],
      "country": "",
      "dob": [],
      "phone": "",
      "userName": "",
      "email": "",
      "about": "",
      "password": "QW12er",
      "confPwd" : "",
      "msg": "weak"
    },

    {
      "rowID" : "passwordIndicatorColor.05",
      "description" : "",
      "name": "",
      "lastName": "",
      "maritalStatus": [],
      "hobby": [],
      "country": "",
      "dob": [],
      "phone": "",
      "userName": "",
      "email": "",
      "about": "",
      "password": "QW12er3",
      "confPwd" : "",
      "msg": "medium"
    },

    {
      "rowID" : "passwordIndicatorColor.06",
      "description" : "",
      "name": "",
      "lastName": "",
      "maritalStatus": [],
      "hobby": [],
      "country": "",
      "dob": [],
      "phone": "",
      "userName": "",
      "email": "",
      "about": "",
      "password": "QW12er34t",
      "confPwd" : "",
      "msg": "strong"
    }
*/
