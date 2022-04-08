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
public class VandensSkaiciuokle {

    @BeforeClass

    public void testDemo() {
        Driver.initialize();
        openLink("https://sportuojantys.lt/skaiciuokles/vandens-skaiciuokle");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@aria-label='dismiss cookie message']")).click();
    }

    @Test
    public void enterYorWeightToInputField() {
        // Irasome duomenis
        String input = "60";
        pages.VandensSkaiciuokle.enterYorWeightToInputField(input);

        pages.VandensSkaiciuokle.clickButtonToCount1();

        String expectedOutput1 = "2.10";
        String actualOutput1;

        actualOutput1 = pages.VandensSkaiciuokle.getAfterButtonCountClickText1();

        Assert.assertEquals(actualOutput1, expectedOutput1);

    }

    @AfterClass
    public void quit() {
        Driver.quit();
    }

}

