package ActionIteam6;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;

public class BestBuy {
    public static void main(String[] args) throws InterruptedException {
        //declaring the webdriver from the Reusable Actions
        WebDriver driver = ReusableActions.setUpDriver();
        //Go to Bestbuy homepage
        driver.navigate().to("https://www.bestbuy.com/");
        //Enter macbook on a Search field
        ReusableActions.sendKeysAction(driver, "//*[@id  = 'gh-search-input']", "macbook","Search Field");
        //Click on the search icon next to the search field
        ReusableActions.clickAction(driver, "//*[@class = 'header-search-button']", "Search Icon");
        //From sort by dropdown and select Best Selling
        ReusableActions.selectByText(driver, "//*[@id='sort-by-select']", "Best Selling");
        //Click on the First Macbook link
        ReusableActions.clickByIndex(driver,"//*[@class='product-image ']", 0);
        //sleep
        Thread.sleep(2000);
        //Scroll to Add to Cart
        ReusableActions.scrollByPixels(driver, 0, 1750);
        //Click on Add to Cart
        ReusableActions.clickAction(driver,"//*[contains(@class, 'c-button-lg ')]", "Add to cart");
        //Capture cart SubTotal & print out the amount
        String Amount = ReusableActions.getText(driver,"//*[@class='sub-total v-fw-medium']", "Sub-Total Amount");
        System.out.println(Amount);
        //Hover the mouse over Continue Shopping
        ReusableActions.mouseHover(driver, "//*[@class='c-button-link continue-shopping']");
        //Add a Sleeper to slow things out
        Thread.sleep(2000);
        //Click on Continue Shopping
        ReusableActions.clickAction(driver, "//*[@class='c-button-link continue-shopping']", "Continue Shopping");
    }//end of main
}//end of class
