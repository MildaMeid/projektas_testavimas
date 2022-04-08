package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.Driver;
import utils.TestListener;
import java.time.Duration;
import static pages.Common.*;
import static utils.Driver.driver;

@Listeners(TestListener.class)
public class Skaiciuokles {

    @BeforeClass

    public void testDemo() {
        Driver.initialize();
        openLink("https://sportuojantys.lt/skaiciuokles/kmi-skaiciuokle");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOf(popup));
        driver.findElement(By.xpath("//*[@aria-label='dismiss cookie message']")).click();
    }

    @Test
    public void enterWeightIntoField() {
            // Irasome duomenis
        String input1 = "60";
        pages.Skaiciuokles.enterWeightToInputField(input1);

        String input2 = "164";
        pages.Skaiciuokles.enterHeighToInputField(input2);

        pages.Skaiciuokles.clickButtonToCount();

        String expectedOutput = "22.31";
        String actualOutput;

        actualOutput = pages.Skaiciuokles.getAfterButtonToCountClickText();

        Assert.assertEquals(actualOutput, expectedOutput);

        }

    @AfterClass
    public void quit() {
        Driver.quit();
    }

}




