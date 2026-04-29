package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BrowserUtils {

    /**
     * This method generates a random username with the firstName parameter.
     * @param firstName
     * @return
     */
    public static String usernameGenerator(String firstName){
        Random random = new Random();
        int randomNum = random.nextInt(99999);
        return firstName+randomNum;
    }

    /**
     * This method takes a screenshot of the browser at the line where it's called.
     * @param fileName
     * @throws IOException
     */
    public static void takeScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);  // taking screenshot
        String path = "src/test/resources/screenshots/"+fileName+".png";                     // path for screenshot
        File file = new File(path);                                                   // creating file in screenshots package
        FileUtils.copyFile(screenshot, file);                                // copying screenshot to file in screenshots package
    }

    /**
     * This method selects an option by value attribute from dropdown.
     * @param element
     * @param value
     */
    public static void selectByValue(WebElement element, String value){
        Select select = new Select(element);     // creating Select object
        select.selectByValue(value);             // selecting by value
    }
}
