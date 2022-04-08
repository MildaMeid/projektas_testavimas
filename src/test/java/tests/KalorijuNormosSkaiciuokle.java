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

import static pages.Common.openLink;
import static utils.Driver.driver;

@Listeners(TestListener.class)
public class KalorijuNormosSkaiciuokle {

    @BeforeClass

    public void testDemo() {
        Driver.initialize();
        openLink("https://sportuojantys.lt/skaiciuokles/dienos-kaloriju-normos-skaiciuokle");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@aria-label='dismiss cookie message']")).click();
    }

    @Test
    public void enterDataIntoFields() {
        String input1 = "82";
        pages.KalorijuNormosSkaiciuokle.enterWeightToInput(input1);

        String input2 = "180";
        pages.KalorijuNormosSkaiciuokle.enterHeighToInput(input2);

        String input3 = "35";
        pages.KalorijuNormosSkaiciuokle.enterAgeToInput(input3);

        pages.KalorijuNormosSkaiciuokle.clickButtonToCount();

        String expectedOutput = "1830";
        String actualOutput;

        actualOutput = pages.KalorijuNormosSkaiciuokle.getAfterButtonToCountClickText();

        Assert.assertEquals(actualOutput, expectedOutput);
    }

    @AfterClass
    public void quit() {
        Driver.quit();
    }

}
