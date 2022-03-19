package de.mediservbank.stepdefinitions;

import de.mediservbank.pages.InfomaterialAnfodernPage;
import de.mediservbank.utilities.BrowserUtils;
import de.mediservbank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InfomaterialAnfodern_stepDefs {

    InfomaterialAnfodernPage infoAnfodern = new InfomaterialAnfodernPage();
    @Given("As a user I am on {string} page")
    public void as_a_user_I_am_on_page(String tabName) {
        infoAnfodern.navigateToTab(tabName);
    }

    @Then("the user should see the {string} tab")
    public void the_user_should_see_the_tab(String tabName) {
        Assert.assertTrue("the tab should be visible",infoAnfodern.tabsWebElement(tabName).isDisplayed());
    }

    @Then("the user should see {string} as title")
    public void theUserShouldSeeAsTitle(String title) {
        Assert.assertTrue("title should have text", Driver.get().getTitle().contains(title));
    }

    @And("the headline of page should be {string}")
    public void theHeadlineOfPageShouldBe(String expectedHeadText) {
        Assert.assertEquals("the title of page should be same",expectedHeadText, infoAnfodern.infoAnfHeadTxt.getText());
    }

    @Then("the all Themen should be visible and selectable")
    public void theAllThemenShouldBeVisibleAndSelectable(List<String> expectedThemen) {
        Assert.assertEquals(expectedThemen, infoAnfodern.actualThemenLabel());
        infoAnfodern.themenCheckbox();
    }


    @And("the user should able to select {string} thema")
    public void theUserShouldAbleToSelectThema(String requestThema) {
        Assert.assertTrue("the requested thema should be selected",infoAnfodern.selectThemaCheckBox(requestThema));
    }

    @Then("the all professions in dropdown should be selectable")
    public void theAllProfessionsInDropdownShouldBeSelectable(List<String> expectedProfessions) {
        Assert.assertEquals("profession dropdown should be equal",expectedProfessions, BrowserUtils.getListOfDropdown(infoAnfodern.professionDropdown));
    }

    @And("the select of profession from user should be required")
    public void theSelectOfProfessionFromUserShouldBeRequired() {
        Assert.assertTrue(Boolean.parseBoolean(infoAnfodern.professionDropdown.getAttribute("aria-required")));
    }

    @And("the user should able to select {string} option from profession")
    public void theUserShouldAbleToSelectOptionFromProfession(String ddownOption) {
        BrowserUtils.selectDropdownOptionsByValue(infoAnfodern.professionDropdown, ddownOption);
    }

    @Then("the all option in Aufmerksam dropdown should be selectable")
    public void theAllOptionInAufmerksamDropdownShouldBeSelectable(List<String> expectedAufmerksam) {
        Assert.assertEquals("Aufmerksam dropdown should be equal",expectedAufmerksam, BrowserUtils.getListOfDropdown(infoAnfodern.aufmerksamDdown));
    }


    @And("the select of Aufmerksam option from user should be required")
    public void theSelectOfAufmerksamOptionFromUserShouldBeRequired() {
        Assert.assertTrue(Boolean.parseBoolean(infoAnfodern.aufmerksamDdown.getAttribute("aria-required")));
    }

    @And("the user should able to select {string} option from Aufmerksam")
    public void theUserShouldAbleToSelectOptionFromAufmerksam(String ddownOption) {
        BrowserUtils.selectDropdownOptionsByValue(infoAnfodern.aufmerksamDdown, ddownOption);
        BrowserUtils.waitFor(3);
    }

    @Then("the all mandatory inputs should have asterisk signs")
    public void theAllMandatoryInputsShouldHaveAsteriskSigns() {
        for (WebElement each : infoAnfodern.requiredAsteriskSigns ) {
            Assert.assertTrue(each.getText().contains("*"));
        }
    }

    @And("the all mandatory input labels should be visible")
    public void theAllMandatoryInputLabelsShouldBeVisible(List<String> expectedMandatoryInputs) {
        Assert.assertEquals(BrowserUtils.getElementsText(infoAnfodern.mandatoryInputLabels), expectedMandatoryInputs);
    }

    @And("the all asterisk signed labels input should be require data from user")
    public void theAllAsteriskSignedLabelsInputShouldBeRequireDataFromUser() {
        for (WebElement element : infoAnfodern.mandatoryInputs ) {
            Assert.assertTrue(Boolean.parseBoolean(element.getAttribute("aria-required")));
        }
    }


    @Then("User should be able to accept the following checkboxes")
    public void userShouldBeAbleToAcceptTheFollowingCheckboxes(List<String> expectedCheckboxes) {
        infoAnfodern.termsAndConditionValidation(expectedCheckboxes);
    }

    @Then("the user should see {string} {string} in blue color")
    public void theUserShouldSeeInBlueColor(String expectedBtn, String expectedColor) {
        BrowserUtils.scrollToElement(infoAnfodern.submitBtn);
        Assert.assertEquals(expectedBtn, infoAnfodern.submitBtn.getAttribute("value"));
        Assert.assertEquals(expectedColor, BrowserUtils.getColor(infoAnfodern.submitBtn, "background-color"));
    }

    @And("the button should be enable")
    public void theButtonShouldBeEnable() {
        Assert.assertTrue(infoAnfodern.submitBtn.isEnabled());
    }
}
