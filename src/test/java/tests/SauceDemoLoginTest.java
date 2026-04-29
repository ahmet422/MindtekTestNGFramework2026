package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoHomePage;
import pages.SauceDemoLoginPage;
import utils.ConfigReader;
import utils.RetryFailedTests;
import utils.TestBase;

public class SauceDemoLoginTest extends TestBase {

    @Test(priority = 0, groups = {"regression", "smoke", "saucedemo", "login"})
    public void loginPositive(){
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.saucedemoLogin("sauceNormalUser");
        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
        Assert.assertTrue(sauceDemoHomePage.productsTitle.isDisplayed());
    }

    @Test(priority = 1, groups = {"regression", "smoke", "saucedemo", "login"}, retryAnalyzer = RetryFailedTests.class)
    public void loginNegative(){
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.saucedemoLogin("sauceLockedUser");
        Assert.assertEquals(sauceDemoLoginPage.lockedOutMessage.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
