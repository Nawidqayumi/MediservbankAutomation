package de.mediservbank.pages;

import de.mediservbank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class InfomaterialAnfodernPage extends BasePage {


    @FindBy(xpath = "//h1")
    public WebElement infoAnfHeadTxt;

    @FindBy(xpath = "(//*[@id='input_2_24']/li/label)")
    public List<WebElement> themenLabels;

    @FindBy(xpath = "//*[@id='input_2_24']/li/input")
    public List<WebElement> themenCheckbox;

    @FindBy (id = "input_2_27")
    public WebElement professionDropdown;

    @FindBy (id = "input_2_45")
    public WebElement aufmerksamDdown;

    @FindBy(css = "[class='gfield_required gfield_required_asterisk']")
    public List<WebElement> requiredAsteriskSigns;

    @FindBy(xpath = "//input[@aria-required='true']//..//../label")
    public List<WebElement> mandatoryInputLabels;

    @FindBy(css = "input[aria-required='true']")
    public List<WebElement> mandatoryInputs;

    @FindBy (id = "choice_2_16_1")
    public WebElement termsCheckbox;

    @FindBy (css = "[id='field_2_16']>label")
    public WebElement termsLabelText;

    @FindBy (id = "choice_2_23_1")
    public WebElement infoAnfodernCheckbox;

    @FindBy (css = "[id='field_2_23']>label")
    public WebElement infoAnfodernLabelText;

    @FindBy (id = "gform_submit_button_2")
    public WebElement submitBtn;


    public List<String> actualThemenLabel() {
        return BrowserUtils.getElementsText(themenLabels);
    }

    public void themenCheckbox() {
        for (WebElement checkbox : themenCheckbox) {
            BrowserUtils.clickWithJS(checkbox);
            Assert.assertTrue(checkbox.isSelected());
        }
        for (WebElement checkbox : themenCheckbox) {
            BrowserUtils.clickWithJS(checkbox);
            Assert.assertFalse(checkbox.isSelected());
        }
    }

    public boolean selectThemaCheckBox(String themaName) {
        boolean checkboxSelect=false;
        for (WebElement checkbox : themenCheckbox) {
            if (checkbox.getAttribute("value").equals(themaName)) {
                BrowserUtils.clickWithJS(checkbox);
                checkboxSelect =checkbox.isSelected();
                break;
            }
        }
        return checkboxSelect;
    }

    public void termsAndConditionValidation(List<String> expectedLabels){
        BrowserUtils.scrollToElement(termsCheckbox);
        BrowserUtils.waitForClickablility(termsCheckbox, 5);
        Assert.assertFalse(termsCheckbox.isSelected());
        BrowserUtils.clickWithJS(termsCheckbox);
        Assert.assertTrue(termsCheckbox.isSelected());
        Assert.assertEquals(expectedLabels.get(0), termsLabelText.getText());

        Assert.assertFalse(infoAnfodernCheckbox.isSelected());
        infoAnfodernCheckbox.click();
        Assert.assertTrue(infoAnfodernCheckbox.isSelected());
        Assert.assertEquals(expectedLabels.get(1), infoAnfodernLabelText.getText());
    }
}
