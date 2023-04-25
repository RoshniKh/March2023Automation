package Day8_03282023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_Class_ActionItem {
    public static void main(String[] args) throws InterruptedException {
        //set up Web driver manager
        WebDriverManager.chromedriver().setup();
        //set up chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //set up the driver with options
        WebDriver driver = new ChromeDriver(options);
        //create ArrayList for States
        ArrayList<String> states = new ArrayList<>();
        states.add("Miami");
        states.add("California");
        states.add("New Jersey");

        for (int i = 0; i < states.size(); i++) {
            driver.navigate().to("https://www.hotels.com/");
            try {
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click state search" + e);
                Thread.sleep(2000);
            }//end of loop
            driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(states.get(i));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[contains(@class, 'uitk-action-list-item')]")).click();
            driver.findElement(By.xpath("//*[@id= 'search_button']")).click();
            // //= 'uitk-action-list-item-content
            Thread.sleep(2000);
            try {
                ArrayList<WebElement> state = new ArrayList<>(driver.findElements(By.xpath("//*[@class='is-visually-hidden']")));

               if (i==0 ){
                   state.get(1).click();
               }
                if (i==1 ){
                    state.get(0).click();
                }
                if (i==2 ){
                    state.get(2).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to click results " + e);
            }
            driver.quit();
        }

        }
    }


