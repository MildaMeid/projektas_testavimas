package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.List;

public class Common {

  public static void openLink(String link) {
      Driver.driver.get(link);
  }

    public static WebElement getElement(By locator) { return Driver.driver.findElement(locator); }

    public static List<WebElement> getElements(By locator) {
        return Driver.driver.findElements(locator);
    }

    public static void clickElement(By locator) {
        getElement(locator).click();
    }

    public static void sendKeys(By locator, String keys) {
        getElement(locator).sendKeys(keys);
    }

    public static String getText(By locator) {
        return getElement(locator).getText();
    }

    public static void selectOptionByValue(By locator, String value) {
        WebElement element = getElement(locator);
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);
    }

}
