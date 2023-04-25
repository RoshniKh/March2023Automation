package ActionIteam4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatchers {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11425");
        zipcode.add("11428");
        zipcode.add("11102");
        //set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //define the webdriver and pass the options
        WebDriver driver = new ChromeDriver(options);

        for (int i = 0; i < zipcode.size(); i++) {
            try {
                //navigate to weightwatchers home page
                driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
                //wait a few seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to navigate to weightwatchers home page: " + e);
            }
            try {
                //Click on Find a Workshop
                driver.findElement(By.xpath("//span[text() ='Find a Workshop']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on Find a Workshop: " + e);
            }
            try {
                //Click on In person link
                driver.findElement(By.xpath("//*[@class= 'buttonText-3DCCO']")).click();
                //wait a few seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click on In person: " + e);
            }
            try {
                //enter zipcode and clear
                WebElement zipcode1 = driver.findElement(By.xpath("//*[@id  = 'location-search']"));
                //clear the field
                zipcode1.clear();
                //enter the zipcode from the array list
                zipcode1.sendKeys(zipcode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter zipcode: " + e);
            }
            //wait a few seconds
            Thread.sleep(2000);
            try {
                //Click on Submit  arrow
                driver.findElement(By.xpath("//*[@id = 'location-search-cta']")).submit();
            } catch (Exception e) {
                System.out.println("Unable to click on Submit: " + e);
            }
            //wait a few seconds
            Thread.sleep(2000);
            try {
                ArrayList<WebElement> studioLink = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'container-3SE46']")));
                if (i == 0) {
                    studioLink.get(1).click();
                }
                if (i == 1) {
                    studioLink.get(2).click();
                }
                if (i == 2) {
                    studioLink.get(0).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to click on studio links" + e);
            }
            //wait a few seconds
            Thread.sleep(2000);
            try {
                //capturing the entire Address on a variable and printing out the address
                String result = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                System.out.println("The address is" + result);
            } catch (Exception e) {
                System.out.println("Unable to print address" + e);
            }
            try {
                //defining Javascript Executor and scrollling
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("scroll(0, 710)");
            } catch (Exception e) {
                System.out.println("Unable to scroll" + e);
            }
            try {
                //capturing the entire table with days and hours
                String result = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println("The address is " + result);
            } catch (Exception e) {
                System.out.println("Unable to print table" + e);
            }//end of try & catch
        }//end of loop
        driver.quit();
    }//end of main
}//end of class
