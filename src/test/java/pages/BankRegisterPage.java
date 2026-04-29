package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BankRegisterPage {

    WebDriver driver;

    public BankRegisterPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer.firstName")
    public WebElement firstNameInput;

    @FindBy(id = "customer.lastName")
    public WebElement lastNameInput;

    @FindBy(id = "customer.address.street")
    public WebElement addressInput;

    @FindBy(id = "customer.address.city")
    public WebElement cityInput;

    @FindBy(id = "customer.address.state")
    public WebElement stateInput;

    @FindBy(id = "customer.address.zipCode")
    public WebElement zipInput;

    @FindBy(id = "customer.phoneNumber")
    public WebElement phoneInput;

    @FindBy(id = "customer.ssn")
    public WebElement ssnInput;

    @FindBy(id = "customer.username")
    public WebElement usernameInput;

    @FindBy(id = "customer.password")
    public WebElement passwordInput;

    @FindBy(id = "repeatedPassword")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerBtn;
}
