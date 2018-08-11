package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
}
