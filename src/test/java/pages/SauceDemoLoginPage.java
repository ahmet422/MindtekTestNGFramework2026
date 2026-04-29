package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class SauceDemoLoginPage {

    WebDriver driver;

    public SauceDemoLoginPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement lockedOutMessage;

    /**
     * Re-usable login method for Saucedemo application.
     * @param usernameKey
     */
    public void saucedemoLogin(String usernameKey){
        driver.get(ConfigReader.getProperty("saucedemoUrl"));
        usernameInput.sendKeys(ConfigReader.getProperty(usernameKey));
        passwordInput.sendKeys(ConfigReader.getProperty("saucePassword"));
        loginBtn.click();
    }
}
