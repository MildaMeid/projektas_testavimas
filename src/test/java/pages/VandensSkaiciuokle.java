package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

public class VandensSkaiciuokle {

    public static void enterYorWeightToInputField(String value) {
        By locator = By.xpath("//*[@aria-label='Jūsų kūno svoris (kg)']");
        Common.sendKeys(locator, value);
    }


    public static void clickButtonToCount1() {
        By locator = By.xpath("//*[contains(@class, 'field calculate-button')]");
        System.out.println(Common.getElement(locator).getAttribute("value"));
        Actions action = new Actions(Driver.driver);
        action.moveToElement(Common.getElement(locator));
        action.click();
        action.perform();
    }

    public static String getAfterButtonCountClickText1() {
        By locator = By.xpath("//*[@id='fieldname1_1']");
        return Common.getElement(locator).getAttribute("value");
    }

}
