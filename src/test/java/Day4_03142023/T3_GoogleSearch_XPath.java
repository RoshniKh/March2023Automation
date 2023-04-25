package Day4_03142023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch_XPath {
    public static void main(String[] args) throws InterruptedException {

        //set your web driver manager to indicate what type of browser/driver you are using
        WebDriverManager.chromedriver().setup();

        //define the Web Driver/Browser you want to use for your test
        WebDriver driver = new ChromeDriver();

        //navigate to Google Homa Page
        driver.navigate().to("https://www.google.com");
        //driver.get("https://,,,,");

        //wait for few seconds
        Thread.sleep(3000);

        //enter the keyword BMW to the search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("BMW");

        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //wait for few seconds for page to load
        Thread.sleep(0000);

        //capture the search results
        String results =  driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //System.out.println("Result is " + results);
        //Using split function we can extract out the search number from the entire text
        String[] arrayResult = results.split(" ");
        System.out.println("Search number is " + arrayResult[1]);

        //Finally, quit your browser to clear session
        driver.quit();
    }//end of main
}//end of class

