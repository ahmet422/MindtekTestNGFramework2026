package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class BlazedemoLinkTest extends TestBase {

    String fromCity = "Boston";
    String toCity = "Rome";

    @Test(groups = {"regression"})
    public void verifyDestinationOfTheWeek(){
        driver.get(ConfigReader.getProperty("blazedemoUrl"));
        driver.findElement(By.partialLinkText("destination of the week")).click();
        String actualText = driver.findElement(By.xpath("/html/body/div[2]")).getText();
        Assert.assertEquals(actualText, "Destination of the week: Hawaii !");
    }

    @Test(groups = {"regression"})
    public void verifySelectedCities(){
        driver.get(ConfigReader.getProperty("blazedemoUrl"));
        WebElement findFlightsBtn = driver.findElement(By.xpath("//input[@value='Find Flights']"));

        BrowserUtils.selectByValue(driver.findElement(By.name("fromPort")), fromCity);
        BrowserUtils.selectByValue(driver.findElement(By.name("toPort")), toCity);

        findFlightsBtn.click();

        String actualFlightsMessage = driver.findElement(By.tagName("h3")).getText();
        String expectedFlightsMessage = "Flights from "+fromCity+" to "+toCity+":";
        Assert.assertEquals(actualFlightsMessage, expectedFlightsMessage);
    }

    @Test(groups = {"regression"})
    public void verifySelectedFlight(){
        driver.get(ConfigReader.getProperty("blazedemoUrl"));
        Select fromCitySelect = new Select(driver.findElement(By.name("fromPort")));
        Select toCitySelect = new Select(driver.findElement(By.name("toPort")));
        WebElement findFlightsBtn = driver.findElement(By.xpath("//input[@value='Find Flights']"));

        fromCitySelect.selectByValue(fromCity);
        toCitySelect.selectByValue(toCity);
        findFlightsBtn.click();

        WebElement chooseFlightBtn1 = driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[1]"));

        String expectedFlightNum = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        String expectedAirline = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        String expectedPrice = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText();

        chooseFlightBtn1.click();

        String actualAirline = driver.findElement(By.xpath("//p[1]")).getText();
        String actualFlightNum = driver.findElement(By.xpath("//p[2]")).getText();
        String actualPrice = driver.findElement(By.xpath("//p[3]")).getText();

        actualFlightNum = actualFlightNum.substring(actualFlightNum.indexOf(":")+2);
        actualAirline = actualAirline.substring(actualAirline.indexOf(":")+2);
        actualPrice = actualPrice.substring(actualPrice.indexOf(":")+2);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualFlightNum, expectedFlightNum);
        softAssert.assertEquals(actualAirline, expectedAirline);
        softAssert.assertEquals(actualPrice, expectedPrice);
        softAssert.assertAll();
    }
}
