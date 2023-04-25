package Reusable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableActions {
    public static WebDriver setUpDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of web driver method

    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " reason: " + e);
        }
    }//end of click action

    public static String getText(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String returnText = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            returnText = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text: " + elementName + e);
        }
        return returnText;
    }//end of getText method
    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
        }
    }//end of send keys action
    public static void selectByText(WebDriver driver, String xpath, String userInput) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            WebElement sortBy = driver.findElement(By.xpath(xpath));
            Select dropdown = new Select(sortBy);
            dropdown.selectByVisibleText(userInput);
        } catch (Exception e) {
            System.out.println("Unable to select text: " + userInput + " for reason: " + e);
        }
    }//end of selectByText method
    public static void clickByIndex(WebDriver driver, String xpath, int userInput) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
        WebElement FirstMacbookLink = driver.findElements(By.xpath(xpath)).get(userInput);
        FirstMacbookLink.click();
        } catch (Exception e) {
            System.out.println("Unable to click by text: " + userInput + " for reason: " + e);
        }
    }//end of ClickByIndex method
    public static void scrollByPixels(WebDriver driver, int a, int b) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(" + a + ", " + b + ")");
    }// end of scrollByPixels method
    public static void mouseHover(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
        WebElement ContinueShopping = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Actions mouseActions = new Actions(driver);
        mouseActions.moveToElement(ContinueShopping).perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse hover: " + e);
        }
    }//end of mouseHover method
    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
        }
    }//end of submit action
    public static void switchToTabByIndex (WebDriver driver, int index) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            //store the tabs into an arraylist
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to the new tab
            driver.switchTo().window(tabs.get(index));
        } catch (Exception e) {
            System.out.println("Invalid Tab index: " + index + e);
        }
    }
}//end of class
