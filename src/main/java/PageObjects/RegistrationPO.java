package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPO <W extends WebElement> extends CommonPO{

    @FindBy(id = "name_3_firstname")
    public W regName;

    @FindBy(id = "name_3_lastname")
    public  W regLastName;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")
    public  W status;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[3]/div/div/input[1]")
    public W hobbies;

    @FindBy(id = "dropdown_7")
    public W regCountry;

    @FindBy(id = "mm_date_8")
    public W regMonth;

    @FindBy(id = "dd_date_8")
    public W regDay;

    @FindBy(id = "yy_date_8")
    public W regYear;

    @FindBy(id = "phone_9")
    public W regPhone;

    @FindBy(id = "username")
    public W usrName;

    @FindBy(id = "email_1")
    public W emailId;

    @FindBy(id = "profile_pic_10")
    public W dp;

    @FindBy(id = "description")
    public W decription;

    @FindBy(id = "password_2")
    public W regPassword;

    @FindBy(id = "confirm_password_password_2")
    public W regConfirmPwd;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[14]/div/input")
    public W submit;

    @FindBy(className = "piereg_message")
    public W message;

    @FindBy(className = "legend")
    public W error;

    public RegistrationPO(WebDriver driver) {
        super(driver);
    }


    public void verifyMsg(String name, String lastName, String maritalStatus, String hobby, String country, String month, String day, String year, String number, String userName, String email, String desc, String password, String msg){
    regName.sendKeys(name);
    regLastName.sendKeys(lastName);
    if(maritalStatus.equalsIgnoreCase("Single")){
        status.click();
    }
    hobbies.click();
    regCountry.sendKeys(country);
    regMonth.sendKeys(month);
    regDay.sendKeys(day);
    regYear.sendKeys(year);
    regPhone.sendKeys(number);
    usrName.sendKeys(userName);
    emailId.sendKeys(email);
    dp.sendKeys("C:\\Users\\Sameer\\Desktop\\testing.jpg");
    decription.sendKeys(desc);
    regPassword.sendKeys(password);
    regConfirmPwd.sendKeys(password);

    submit.click();
    Assert.assertEquals(message.getText(),msg);
}

}
