package ActionItem7;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class fideliscare {
    //declare global webdriver variable
    WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {
        //declare the webdriver and define it from the reusable actions
        driver = ReusableActions.setUpDriver();
    }//end of before class

    @Test
    public void searchForDentalCoverage() throws InterruptedException {
        //go to FidelisCare page
        driver.navigate().to("https://www.fideliscare.org");
        //Click on the search element
        ReusableActions.clickAction(driver, "//*[@class='tool dropdown search']", "Search Icon");
        //enter a Get Dental Coverage on the search field
        Thread.sleep(2000);
        ReusableActions.sendKeysAction(driver, "//*[@class='form-control search-input']", "Get Dental Coverage", "SearchField");
        Thread.sleep(2000);
        //Click on search icon
        ReusableActions.clickAction(driver, "//*[@class='btn btn-primary btn-search']", "click Search");
        //Capture Search results
        String results = driver.findElement(By.xpath("//*[@id='resInfo-0']")).getText();
        //Using split function we can extract out the search number from the entire text
        String[] arrayResult = results.split(" ");
        System.out.println("Search result number is: " + arrayResult[1]);
        Thread.sleep(2000);
        //Click on Get General Coverage first link
        ReusableActions.clickAction(driver, "//*[text() ='Get Dental Coverage']", "click Get Dental Coverage first link");
        Thread.sleep(2000);
    }//end of test case 1

    @Test(dependsOnMethods = "searchForDentalCoverage")
    public void switchToTabToContactMePage() throws InterruptedException {
        //switch to new tab
        ReusableActions.switchToTabByIndex(driver, 1);
        Thread.sleep(2000);
        //Scroll to contact me
        ReusableActions.scrollByPixels(driver, 0, 750);
        Thread.sleep(2000);
        //Clicking on First name field
        ReusableActions.clickAction(driver, "//*[@id='firstName']", "Clicking First Name");
        //Enter First Name
        ReusableActions.sendKeysAction(driver, "//*[@id='firstName']", "Roshni", "FirstName");
        //Clicking on Last name field
        ReusableActions.clickAction(driver, "//*[@id='lastName']", "Clicking Last Name");
        //Enter Last Name
        ReusableActions.sendKeysAction(driver, "//*[@id='lastName']", "Khader", "LasttName");
        //Clicking on Zipcode field
        ReusableActions.clickAction(driver, "//*[@id='zipCode']", "Clicking Zipcode");
        //Enter Zipcode
        ReusableActions.sendKeysAction(driver, "//*[@id='zipCode']", "11102", "Zipcode");
        //Clicking County Dropdown
        ReusableActions.clickAction(driver, "//*[@id='county']", "Click County");
        //select county
        ReusableActions.selectByText(driver, "//*[@id='county']", "Queens");
        //Clicking on Phone Number
        ReusableActions.clickAction(driver, "//*[@id='phoneNumber']", "Clicking Zipcode");
        //Enter Phone Number
        ReusableActions.sendKeysAction(driver, "//*[@id='phoneNumber']", "9295287121", "Phone Number");
        //Clicking on Email
        ReusableActions.clickAction(driver, "//*[@id='email']", "Clicking on Email");
        //Enter Email
        ReusableActions.sendKeysAction(driver, "//*[@id='email']", "Triage@gmail.com", "Email");
        //Click on Contact me Checkbox
        ReusableActions.clickAction(driver, "//*[@for='contactMe']", "Clicking on Checkbox");
        //Click on Contact Me button to submit
        ReusableActions.clickAction(driver, "//*[@type='submit']", "Clicking on Contact Me Button");
        //capturing the Thank you message
        String thank = ReusableActions.getText(driver, "//*[contains(text(), 'Thank you for your submission')]", "Thank you message");
        System.out.println(thank);
        //close the tab
        driver.close();
        //Thread.sleep(2000);
    }//end of test case 2
    @Test(dependsOnMethods = {"searchForDentalCoverage", "switchToTabToContactMePage"})
    public void memberOnlinePortal() {
        //switch to default tab
        ReusableActions.switchToTabByIndex(driver, 0);
        //Click on Login
        ReusableActions.clickAction(driver, "//*[@class='dropdown-toggle']", "Clicking on Login");
        //Click on Member Online Portal
        ReusableActions.clickAction(driver, "//*[@target='_blank']", "Clicking Member Online Portal");
        //switch to new tab
        ReusableActions.switchToTabByIndex(driver, 1);
        //capture the Helpful Hints
        String helpfulHints = ReusableActions.getText(driver, "//*[@class= 'tipsContentText']", "Helpful Hints");
        System.out.println(helpfulHints);
        //close the tab
        driver.close();
    }//end of test case 3
    @AfterSuite
    public void quitDriverSession() {
        driver.quit();
    }//end of after suite
}//end of class
