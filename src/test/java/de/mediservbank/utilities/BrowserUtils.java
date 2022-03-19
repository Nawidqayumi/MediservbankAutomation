package de.mediservbank.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class BrowserUtils {


    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * returns the values of dropdown options as a List of String
     * @param dropdownElement
     * @return
     */
    public static List<String> getListOfDropdown(WebElement dropdownElement){
        List<String> listOfDropdown = new ArrayList<>();
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            listOfDropdown.add(option.getAttribute("value"));
        }
        listOfDropdown.remove(0);
        return listOfDropdown;
    }

    /**
     * select an option of dropdown based on it is value
     * @param dropdownElement
     * @param optionsValue
     */
    public static void selectDropdownOptionsByValue(WebElement dropdownElement, String optionsValue){
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByValue(optionsValue);

    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * return the color of element
     * @param element
     * @param cssValue
     * @return
     */

    public static String getColor(WebElement element, String cssValue){
        String backColor = element.getCssValue(cssValue);
        return Color.fromString(backColor).asHex();
    }



}