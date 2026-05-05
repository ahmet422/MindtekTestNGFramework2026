package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BankAccountServicesPage;
import pages.BankLoginPage;
import pages.BankRegisterPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

import java.io.IOException;


public class BankSignUpCopyTest extends TestBase {

    String username;
    String password;

    @DataProvider(name = "accountCreationData")
    public static Object[][] accountCreationData(){    // return type -> multi-dimensional array
        return new Object[][] {
                {"John", "Patel", "123 Washington St", "Boston", "MA", "54321", "123-456-7890", "1234567890", BrowserUtils.usernameGenerator("john"), "a1234"},
                //{"Adam", "Lee", "123 Foo Rd", "Chicago", "IL", "60660", "0987654321", "0987654321", BrowserUtils.usernameGenerator("adam"), "a1234"}
        };
    }

    @Test(groups = {"regression", "smoke", "bank", "login"}, dataProvider = "accountCreationData")
    public void bankAccountCreation(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zip,
            String phoneNum,
            String ssn,
            String username,
            String password
    ) throws IOException {
        driver.get(ConfigReader.getProperty("bankUrl"));
        BankLoginPage bankLoginPage = new BankLoginPage();
        bankLoginPage.registerLink.click();
        driver.navigate().refresh();

        BankRegisterPage bankRegisterPage = new BankRegisterPage();
        bankRegisterPage.firstNameInput.sendKeys(firstName);
        bankRegisterPage.lastNameInput.sendKeys(lastName);
        bankRegisterPage.addressInput.sendKeys(address);
        bankRegisterPage.cityInput.sendKeys(city);
        bankRegisterPage.stateInput.sendKeys(state);
        bankRegisterPage.zipInput.sendKeys(zip);
        bankRegisterPage.phoneInput.sendKeys(phoneNum);
        bankRegisterPage.ssnInput.sendKeys(ssn);
        bankRegisterPage.usernameInput.sendKeys(username);
        bankRegisterPage.passwordInput.sendKeys(password);
        bankRegisterPage.confirmPasswordInput.sendKeys(password);
        bankRegisterPage.registerBtn.click();

        System.out.println(username);
        System.out.println(password);
        BankAccountServicesPage bankAccountServicesPage = new BankAccountServicesPage();
        BrowserUtils.takeScreenshot("bankAccountCreation");
        Assert.assertEquals(bankAccountServicesPage.welcomeMessage.getText(), "Welcome "+username);
    }

    @Test(dependsOnMethods = "bankAccountCreation")
    public void bankLogin(){
        driver.get(ConfigReader.getProperty("bankUrl"));
        BankLoginPage bankLoginPage = new BankLoginPage();
        bankLoginPage.usernameInput.sendKeys(ConfigReader.getProperty("bankUsername"));
        bankLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("bankPassword"));
        bankLoginPage.loginBtn.click();
        BankAccountServicesPage bankAccountServicesPage = new BankAccountServicesPage();
        Assert.assertEquals(bankAccountServicesPage.loginWelcomeText.getText(), "Welcome");
    }
}
