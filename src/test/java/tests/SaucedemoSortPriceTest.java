package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoHomePage;
import pages.SauceDemoLoginPage;
import utils.TestBase;

public class SaucedemoSortPriceTest extends TestBase {

    @Test(groups = {"regression", "saucedemo", "sortByPrice"})
    public void sortPriceLowToHigh(){
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.saucedemoLogin("sauceNormalUser");

        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
        Select select = new Select(sauceDemoHomePage.sortDropdown);
        select.selectByValue("lohi");

        for (int i=0 ; i<sauceDemoHomePage.itemPrices.size()-1 ; i++){
            double doublePrice1 = Double.parseDouble(sauceDemoHomePage.itemPrices.get(i).getText().substring(1));
            double doublePrice2 = Double.parseDouble(sauceDemoHomePage.itemPrices.get(i+1).getText().substring(1));
            System.out.println(doublePrice1+" is less than or equal to "+doublePrice2);
            Assert.assertTrue(doublePrice1<=doublePrice2);
        }
    }
}
