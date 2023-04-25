package ActionIteam2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {

        //set your web driver manager to indicate what type of browser/driver you are using
        WebDriverManager.chromedriver().setup();

        //define the Web Driver/Browser you want to use for your test
        WebDriver driver = new ChromeDriver();

        //set up array list for cars
        ArrayList<String> Hobbies = new ArrayList<>();
        Hobbies.add("Boxing");
        Hobbies.add("Chess");
        Hobbies.add("Tennis");
        Hobbies.add("Bowling");

        for(int i = 0; i < Hobbies.size(); i++) {
            //navigate to Google Homa Page
            driver.navigate().to("https://www.bing.com");
            //driver.get("https://,,,,");

            //wait for few seconds
            Thread.sleep(2000);

            //search hobbies on the bing search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Hobbies.get(i));

            //hit submit on the bing search button
            driver.findElement(By.xpath("//*[@id='sb_form']")).submit();

            //wait for few seconds for page to load
            Thread.sleep(2000);
            //capture the search results
            String results = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //Using split function we can extract out the search number from the entire text
            String[] arrayResult = results.split(" ");
            System.out.println("Search number for " + Hobbies.get(i) + " is " + arrayResult[1]);
        }//end of loop
        //quit your browser to clear session
        driver.quit();
    }//end of main
}//end of class

