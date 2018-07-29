package Testcases;

import Utility.JSONProvider;
import Utility.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonSetup {

    WebDriver driver;

    public void getData(String jsonFile){
        JSONProvider.jsonFile = jsonFile;
    }
    @BeforeSuite
    public void suiteSetup() {
        SeleniumDriver seleniumDriver = new SeleniumDriver();
        driver = seleniumDriver.setDriver();
    }

    @AfterSuite
    public void suiteTearDown(){
        driver.close();
        driver.quit();
    }

}
