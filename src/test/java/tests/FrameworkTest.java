package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.RetryFailedTests;
import utils.TestBase;

public class FrameworkTest extends TestBase {

    @Test(groups = {"regression"}, retryAnalyzer = RetryFailedTests.class)
    public void verifyGoogleHomePage(){
        driver.get(ConfigReader.getProperty("googleUrl"));
        Assert.assertEquals(driver.getTitle(), "Google");
    }
}
