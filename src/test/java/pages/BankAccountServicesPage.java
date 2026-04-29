package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BankAccountServicesPage {

    WebDriver driver;

    public BankAccountServicesPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='rightPanel']/h1")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//p/b")
    public WebElement loginWelcomeText;
}
