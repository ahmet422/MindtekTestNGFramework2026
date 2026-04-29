package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod(groups = {"testbase"})
    public void setup(){
        driver = Driver.getDriver();
    }

    @AfterMethod(groups = {"testbase"})
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
