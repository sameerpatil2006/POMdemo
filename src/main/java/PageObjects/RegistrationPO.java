package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.support.Color;

public class RegistrationPO <W extends WebElement> extends CommonPO {

    @FindBy(id = "name_3_firstname")
    public W regName;

    @FindBy(id = "name_3_lastname")
    public W regLastName;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")
    public W status;

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

    @FindBy(className = "piereg_login_error")
    public W loginError;

    @FindBy(className = "legend")
    public W error;

    @FindBy(id = "piereg_passwordStrength")
    public W strength;

    public RegistrationPO(WebDriver driver) {
        super(driver);
    }

    public void verifyMsg(Registration registration, String msg, String testType) {

        String errorMsg = null;
        regName.sendKeys(registration.name);
        regLastName.sendKeys(registration.lastName);
        status.click();
        hobbies.click();
        regCountry.sendKeys(registration.country);
        regMonth.sendKeys(registration.dob.get(0).toString());
        regDay.sendKeys(registration.dob.get(1).toString());
        regYear.sendKeys(registration.dob.get(2).toString());
        regPhone.sendKeys(registration.number);
        usrName.sendKeys(registration.usrNm);
        emailId.sendKeys(registration.email);
        decription.sendKeys(registration.desc);
        regPassword.sendKeys(registration.password);
        regConfirmPwd.sendKeys(registration.confmPassword);

        submit.click();

        switch (testType){
            case "positive" :
                errorMsg = message.getText();
                break;

            case "negative" :
                errorMsg = error.getText();
                break;

            case "loginError" :
                errorMsg = loginError.getText();
                break;
        }
        Assert.assertEquals(errorMsg,msg);
    }



    public void verifyStrengthButton(Registration registration, String msg, String color) throws Exception{

        String label = null, backgroundColor, colorCode;
        regPassword.sendKeys(registration.password);
        regConfirmPwd.sendKeys(registration.confmPassword);
        label = strength.getText();
        backgroundColor = strength.getCssValue("background-color");
        colorCode = Color.fromString(backgroundColor).asHex();
        Assert.assertEquals(label, msg);
        Assert.assertEquals(colorCode,color);
    }

    /*public void verifyColor(Registration registration, String type) throws Exception{

        String color = null;
        regPassword.sendKeys(registration.password);
        regConfirmPwd.sendKeys(registration.confmPassword);

        switch (type){
            case "weak" :
                color = "";
                break;
            case "strong" :
                color = "";
                break;
            case "medium" :
                color = "";
                break;
        }
        String colorValue = strength.getCssValue("background-color");
        String colorCode = Color.fromString(colorValue).asHex();

        Assert.assertEquals(label, msg);
    }*/
}

 /*regLastName.sendKeys(regList.get(1));
        if(regList.get(2).equalsIgnoreCase("Single")){
            status.click();
        }
        hobbies.click();
        regCountry.sendKeys(regList.get(3));
        regMonth.sendKeys(.get(4));
        regDay.sendKeys(regList.get(5));
        regYear.sendKeys(regList.get(6));
        regPhone.sendKeys(regList.get(9));
        usrName.sendKeys(regList.get(10));
        emailId.sendKeys(regList.get(11));
        dp.sendKeys("C:\\Users\\Sameer\\Desktop\\testing.jpg");
        decription.sendKeys(regList.get(7));
        regPassword.sendKeys(regList.get(12));
        regConfirmPwd.sendKeys(regList.get(13));
*/
        //submit.click();
     /*   for (int i = 0; i < regList.size(); i++) {
            if (regList.get(i).equalsIgnoreCase("")) {
                flag = true;
                break;
            }
        }
        if(flag == true){
            Assert.assertEquals(error.getText(), msg);
        }
        else {
            Assert.assertEquals(message.getText(), msg);
        }*/