package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriver {

    WebDriver driver;
    public WebDriver setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sameer\\IdeaProjects\\playLocal\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demoqa.com/");
        return driver;
    }
}
