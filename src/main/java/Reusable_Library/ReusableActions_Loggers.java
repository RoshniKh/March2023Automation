package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableActions_Loggers {
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

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click action

    public static void isConditionTrue(boolean bool, ExtentTest logger){
        if (bool == true) {
            logger.log(LogStatus.PASS, "Boolean condition is : " + bool);
        } else {
            logger.log(LogStatus.FAIL, "Boolean condition is : " + bool);

        }
    }//end of isConditionTrue method

    public static String getText(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String returnText = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            returnText = element.getText();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text: " + elementName + " reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
        return returnText;
    }//end of getText method
    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
            System.out.println("Unable to capture text: " + elementName + " reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of send keys action

    public static void selectByText(WebDriver driver, String xpath, String userinput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            WebElement sortBy = driver.findElement(By.xpath(xpath));
            Select dropDown = new Select(sortBy);
            dropDown.selectByVisibleText(userinput);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " +  " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }

    }//end of selectByText


    public static void scrollByPixels(WebDriver driver, int xPixels, int yPixels, ExtentTest logger) {
        try {

            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollBy(" + xPixels + ", " + yPixels + ")");
            logger.log(LogStatus.PASS, "Successfully clicked on " );
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to switch to tab index " + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " );


        } catch (Exception e) {
            System.out.println("An unexpected error occurred while switching tabs: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " );
        }

    } // end of scrollByPixels method

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName ) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Actions mouseActions = new Actions(driver);
            mouseActions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " +  " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }

    }//end of mouseHover method


    public static void clickByIndex(WebDriver driver, String xpath, int userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {

            WebElement i = driver.findElements(By.xpath(xpath)).get(userInput);
            i.click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " +  " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of ClickByIndex method

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit action

    public static void switchToTabByIndex(WebDriver driver, int tabIndex, ExtentTest logger) {
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
            logger.log(LogStatus.PASS, "Successfully clicked on " );
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " +  " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " );

        }
    }//end of switch to tab by index

    public static void switchToPreviousTab(WebDriver driver,ExtentTest logger, String elementName ) {
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            int currentTabIndex = tabs.indexOf(driver.getWindowHandle());
            int previousTabIndex = currentTabIndex - 1;
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
            if (previousTabIndex >= 0) {
                driver.switchTo().window(tabs.get(previousTabIndex));
            } else {
                System.out.println("Unable to switch to previous tab. This is the first tab.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while switching to previous tab: " + e.getMessage());
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of switchToPreviousTab

    public static void switchToOpenedTab(WebDriver driver, String tabTitle,ExtentTest logger, String elementName) {
        try {
            String currentTab = driver.getWindowHandle();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
            for (String tab : driver.getWindowHandles()) {
                driver.switchTo().window(tab);
                if (driver.getTitle().equalsIgnoreCase(tabTitle)) {
                    return;
                }
            }
            driver.switchTo().window(currentTab);
            System.out.println("Unable to find tab with title: " + tabTitle);
        } catch (Exception e) {
            System.out.println("An error occurred while switching to tab with title " + tabTitle + ": " + e.getMessage());
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);

        }
    }//switchToOpenedTab

    public static String captureText(WebDriver driver, String xpath,ExtentTest logger, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
            return element.getText();
        } catch (Exception e) {
            System.out.println("An error occurred while capturing text from element " + elementName + ": " + e.getMessage());
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
            return null;
        }
    }//end of captureText

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    public static void verifyTitle(WebDriver driver, String expectedTitle, ExtentTest logger, String elementName) {
        try {
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                logger.log(LogStatus.PASS, "Page title verified: " + actualTitle);
            } else {
                logger.log(LogStatus.FAIL, "Page title verification failed. Expected title: " + expectedTitle + ", Actual title: " + actualTitle);
                getScreenShot(driver, elementName, logger);
            }
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "An exception occurred while verifying page title: " + e.getMessage());
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void sendKeysMethod(WebDriver driver, String locator, String userInput, ExtentTest logger, String elementName) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            element.clear();
            element.sendKeys(userInput);
            logger.log(LogStatus.INFO, "Entered '" + userInput + "' in " + elementName + " field");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to enter '" + userInput + "' in " + elementName + " field" + e);
            getScreenShot(driver,elementName,logger);

        }
    }//end of sendKeysMethod

    public static WebElement waitForVisibility(WebDriver driver, String locator, int timeout,ExtentTest logger, String elementName) {
        WebElement element = null;
        try {
            System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            System.out.println("Element is visible on the page");
        } catch (Exception e) {
            System.out.println("Element is not visible on the page");
            logger.log(LogStatus.FAIL, "Unable to enter '" +  "' in " + elementName + " field" + e);
            getScreenShot(driver,elementName,logger);
        }
        return element;
    }//end of waitForVisibility

    public static WebElement waitForElement(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            logger.log(LogStatus.INFO, "Entered '" +  "' in " + elementName + " field");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to enter '" +  "' in " + elementName + " field" + e);
            getScreenShot(driver, elementName, logger);
        }
        return element;
    }//end of waitForElement

}// end of class