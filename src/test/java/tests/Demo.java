package tests;

import org.testng.annotations.Test;

import utils.Driver;

import static pages.Common.openLink;

public class Demo {

    @Test
    public void testDemo() {
        Driver.initialize();
        openLink("https://motyvuotiatletai.lt");
    }

}
