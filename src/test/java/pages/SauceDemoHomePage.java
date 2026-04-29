package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SauceDemoHomePage {

    WebDriver driver;

    public SauceDemoHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Products')]")
    public WebElement productsTitle;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement sortDropdown;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> itemPrices;
}
