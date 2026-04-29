package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BankLoginPage {

    WebDriver driver;                       // Declare the driver

    public BankLoginPage(){                 // Create a constructor
        driver = Driver.getDriver();        // Initialize the driver
        PageFactory.initElements(driver, this);     // Initialize webelements on this page
    }

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginBtn;
}
