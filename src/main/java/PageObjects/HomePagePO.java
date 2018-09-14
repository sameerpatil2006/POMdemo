package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.swing.*;

public class HomePagePO<W extends WebElement> extends CommonPO<W>{

    @FindBy(id = "ui-id-1")
    public W tab1;

    @FindBy(id = "ui-id-2")
    public W tab2;

    @FindBy(id = "ui-id-3")
    public W tab3;

    @FindBy(id = "ui-id-4")
    public W tab4;

    @FindBy(id = "ui-id-5")
    public W tab5;

    @FindBy(id = "tabs-1")
    public W tabContent1;

    @FindBy(id = "tabs-2")
    public W tabContent2;

    @FindBy(id = "tabs-3")
    public W tabContent3;

    @FindBy(id = "tabs-4")
    public W tabContent4;

    @FindBy(id = "tabs-5")
    public W tabContent5;

    @FindBy(xpath = "//*[@id=\"ipt-kb-social-widget-2\"]/ul/li[1]/a")
    public W facebookLink;

    @FindBy(xpath = "//*[@id=\"ipt-kb-social-widget-2\"]/ul/li[2]/a")
    public W twitterLink;

    @FindBy(xpath = "//*[@id=\"ipt-kb-social-widget-2\"]/ul/li[3]/a")
    public W googleLink;

    public HomePagePO(WebDriver driver) {
        super(driver);
    }

    public void verifyHomePageTabs(String tab, String contents){
        String content = null;
        switch (tab){
            case "tab1" :
                tab1.click();
                content = tabContent1.getText();
                break;
            case "tab2" :
                tab2.click();
                content = tabContent2.getText();
                break;
            case "tab3" :
                tab3.click();
                content = tabContent3.getText();
                break;
            case "tab4" :
                tab4.click();
                content = tabContent4.getText();
                break;
            case "tab5" :
                tab5.click();
                content = tabContent5.getText();
                break;

        }
        content = content.replace("\n"," ");
        Assert.assertEquals(content,contents);
    }

    /**
     *
     */
    public void verifyToolTip(String tool, String toolTip){
       // Actions tools = new Actions(driver);
        String tipValue = null;

        switch (tool){
            case "facebook" :
                //tools.moveToElement(facebkTip).build().perform();
                tipValue = facebookLink.getAttribute("title");
                break;
            case  "twitter" :
                //tools.moveToElement(twitterTip).build().perform();
                tipValue = twitterLink.getAttribute("title");
                break;
            case "google" :
                //tools.moveToElement(googleTip).build().perform();
                tipValue = googleLink.getAttribute("title");
                break;
        }

        System.out.println(tipValue);
        Assert.assertEquals(tipValue,toolTip);

    }

}
