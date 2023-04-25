package Actionitem3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ChromOptions {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        //set up array list for cars
        ArrayList<String> Hobbies = new ArrayList<>();
        Hobbies.add("Boxing");
        Hobbies.add("Chess");
        Hobbies.add("Tennis");
        Hobbies.add("Bowing");
        for(int i = 0; i < Hobbies.size(); i++) {
            //navigate to Yahoo Homa Page
            driver.navigate().to("https://www.yahoo.com");
            //wait for few seconds
            Thread.sleep(2000);
            //enter hobbies on search filed
            driver.findElement(By.xpath("//*[@name = 'p']")).sendKeys(Hobbies.get(i));
            //submit on yahoo search button
            driver.findElement(By.xpath("//*[@id='ybar-search']")).submit();
            //wait for few seconds for page to load
            Thread.sleep(2000);
            //capture the search results
            String results = driver.findElement(By.xpath("//*[contains(@class,'fz-14')]")).getText();
            //Using split function we can extract out the search number from the entire text
            String[] arrayResult = results.split(" ");
            System.out.println("Search number for " + Hobbies.get(i) + " is " + arrayResult[1]);
            //defining Javascript Executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 4400)");
            //click on About this page
            driver.findElement(By.xpath("//*[text() = 'About this page']")).click();
            Thread.sleep(2000);
            //print out Yahoo questions text
            String text = driver.findElement(By.xpath("//*[@id ='announcementdiv']")).getText();
            System.out.println("Text is " + text);
            //use arraylist
            ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[@data-ylk='elm:rhdln']")));
            //wait a few seconds
            Thread.sleep(2000);
            String narrowText = driver.findElement(By.xpath("//*[@id='article_container']")).getText();
            System.out.println("The Second Entire message is " +narrowText);
        }//end of loop
        //quit your browser to clear session
        driver.quit();
    }//end of main
}//end of class
