package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

public class Kontaktai {

    public static void enterName(String value) {
        By locator = By.xpath("//*[@id='wpforms-24990-field_1']");
        Common.sendKeys(locator, value);
    }

    public static void enterEmail(String value) {
        By locator = By.xpath("//*[@id='wpforms-24990-field_2']");
        Common.sendKeys(locator, value);
    }

    public static void enterMessage(String value) {
        By locator = By.xpath("//*[@id='wpforms-24990-field_3']");
        Common.sendKeys(locator, value);
    }

    public static void clickButtonSubmit() {
        By locator = By.xpath("//*[@id='wpforms-submit-24990']");
        System.out.println(Common.getElement(locator).getAttribute("value"));
        Actions action = new Actions(Driver.driver);
        action.moveToElement(Common.getElement(locator));
        action.click();
        action.perform();
    }

    public static String getAfterClickButtonText1() {
        By locator = By.xpath("//*[@class='wpforms-confirmation-container-full wpforms-confirmation-scroll']");
        // By locator = By.xpath("//*[@id='wpforms-confirmation-24990']");
//        return Common.getElement(locator).getAttribute("value");
        return Common.getText(locator);

    }

    public static String getErrorTextAfterButton() {
        By locator = By.xpath("//*[@id='wpforms-24990-field_2-error']");
        // By locator = By.xpath("//*[@id='wpforms-confirmation-24990']");
        return Common.getText(locator);
//        return Common.getElement(locator).getAttribute("value");

    }
}