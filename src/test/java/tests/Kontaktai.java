package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.*;
import utils.Driver;
import utils.TestListener;

import java.time.Duration;

import static pages.Common.openLink;
import static utils.Driver.driver;

@Listeners(TestListener.class)
public class Kontaktai {

    @BeforeMethod
    public void testDemo() {
        Driver.initialize();
        openLink("https://sportuojantys.lt/kontaktai");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@aria-label='dismiss cookie message']")).click();
    }

    @Test
    public void enterDataIntoContactField() {

        String name = "Vardas";
        pages.Kontaktai.enterName(name);

        String email = "vardas@gmail.com";
        pages.Kontaktai.enterEmail(email);

        String message = "Klausimas";
        pages.Kontaktai.enterMessage(message);

        pages.Kontaktai.clickButtonSubmit();

        String expectedOutput = "Greitu metu susisieksime su jumis!";
        String actualOutput;

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='dismiss cookie message']")));
        //driver.findElement(By.xpath("//*[@class='wpforms-confirmation-container-full wpforms-confirmation-scroll']"));

        actualOutput = pages.Kontaktai.getAfterClickButtonText1();

        Assert.assertEquals(actualOutput, expectedOutput);

    }

    @Test
    public void doNotEnterDataIntoEmailField() {

        String name = "Vardas";
        pages.Kontaktai.enterName(name);

        String message = "Klausimas";
        pages.Kontaktai.enterMessage(message);

        pages.Kontaktai.clickButtonSubmit();

        String expectedOutput1 = "Užpildykite laukelį";
        String actualOutput1;

        actualOutput1 = pages.Kontaktai.getErrorTextAfterButton();

        Assert.assertEquals(actualOutput1, expectedOutput1);
    }

    @AfterMethod
    public void quit() {
        Driver.quit();
    }

}
