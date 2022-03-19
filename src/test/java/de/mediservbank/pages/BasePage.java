package de.mediservbank.pages;

import de.mediservbank.utilities.BrowserUtils;
import de.mediservbank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    /**
     * this method is to navigate to different tabs menu inside mediservbank homepage by inserting tab name inside
     * a try/catch block and click with JS executor
     * @param tabName
     */
    public void navigateToTab(String tabName){
        try{
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(tabsWebElement(tabName));}
        catch (Exception e){ e.printStackTrace(); }
    }

    /**
     * this method returns webelement of each tab inside our homepage
     * @param tabName
     * @return
     */
    public WebElement tabsWebElement (String tabName){
         return Driver.get().findElement(By.xpath("(//*[@class='menu']//*[text()='"+tabName+"']//..)[1]"));
    }



}
