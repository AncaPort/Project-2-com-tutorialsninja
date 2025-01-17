package laptopsandnotebooks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * ● Create package laptopsandnotebooks
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNotebooksTest extends Utility {

    @Before
    public void setUp() {
        multiBrowser(baseUrl);
    }

    /**
     * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
     * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
     * 1.2 Click on “Show All Laptops & Notebooks”
     * 1.3 Select Sort By "Price (High > Low)"
     * 1.4 Verify the Product price will arrange in High to Low order
     */
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on Currency Dropdown and click
        mouseHoverAndClickToElement(By.xpath("//span[normalize-space()='Currency']"));
        mouseHoverAndClickToElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        mouseHoverAndClickToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // 1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //Select Sort By position "Price high to low"
        selectByValueFromDropDown(By.id("input-sort"), "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        Thread.sleep(2000);
        List<WebElement> price = driver.findElements(By.id("input-sort"));
        for (WebElement price1 : price) {
            System.out.println(price1.getText());
        }
    }

    /**
     * 2. Test name verifyThatUserPlaceOrderSuccessfully()
     * * 2.1 Mouse hover on Laptops & Notebooks Tab and click
     * * 2.2 Click on “Show All Laptops & Notebooks”
     * * 2.3 Select Sort By "Price (High > Low)"
     * * 2.4 Select Product “MacBook”
     * * 2.5 Verify the text “MacBook”
     * * 2.6 Click on ‘Add To Cart’ button
     * * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
     * * 2.8 Click on link “shopping cart” display into success message
     * * 2.9 Verify the text "Shopping Cart"
     * * 2.10 Verify the Product name "MacBook"
     * * 2.11 Change Quantity "2"
     * * 2.12 Click on “Update” Tab
     * * 2.13 Verify the message “Success: You have modified your shopping cart!”
     * * 2.14 Verify the Total £737.45
     * * 2.15 Click on “Checkout” button
     * * 2.16 Verify the text “Checkout”
     * * 2.17 Verify the Text “New Customer”
     * * 2.18 Click on “Guest Checkout” radio button
     * * 2.19 Click on “Continue” tab
     * * 2.20 Fill the mandatory fields
     * * 2.21 Click on “Continue” Button
     * * 2.22 Add Comments About your order into text area
     * * 2.23 Check the Terms & Conditions check box
     * * 2.24 Click on “Continue” button
     * * 2.25 Verify the message “Warning: Payment method required!”
     */

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on Currency Dropdown and click
        mouseHoverAndClickToElement(By.xpath("//span[normalize-space()='Currency']"));
        //Mouse hover on £Pound Sterling and click
        mouseHoverAndClickToElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClickToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //Select Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.id("input-sort"), "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        //Select Product “Sony VAIO”
        clickOnElement(By.linkText("Sony VAIO"));
        //Verify the text “Sony VAIO”
        Assert.assertEquals("Sony VAIO", getTextFromElement(By.xpath("//h1[contains(text(),'Sony VAIO')]")));
        //Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));
        //Verify the message “Success: You have added Sony VAIO to your shopping cart!”
        Assert.assertEquals("Success: You have added Sony VAIO to your shopping cart!", getTextFromElement(By.xpath("//div[contains(text(),'Success')]")).substring(0, 56));
        //Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));
        //Verify the text "Shopping Cart"
        Assert.assertEquals("Shopping Cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).substring(0, 13));
        //Verify the Product name "Sony VAIO"
        Assert.assertEquals("Sony VAIO", getTextFromElement(By.linkText("Sony VAIO")));
        //Change Quantity "2"
        driver.findElement(By.xpath("//input[@class='form-control']")).clear();
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");
        //Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
        //Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals("Success: You have modified your shopping cart!", getTextFromElement(By.xpath("//div[contains(text(),'Success')]")).substring(0, 46));
        //Verify the Total £737.45
        Assert.assertEquals("£1,472.45", getTextFromElement(By.xpath("//tbody//tr//td[6]")));
        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        //Verify the text “Checkout”
        Assert.assertEquals("Checkout", getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']")));
        //Verify the Text “New Customer”
        Assert.assertEquals("New Customer", getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']")));
        //Click on “Guest Checkout” radio button
        mouseHoverAndClickToElement(By.xpath("//input[@value='guest']"));
        //Click on “Continue” tab
        clickOnElement(By.id("button-account"));
        //Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Shital");
        sendTextToElement(By.id("input-payment-lastname"), "Sanghani");
        sendTextToElement(By.id("input-payment-email"), "shital00@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "07645526212");
        sendTextToElement(By.id("input-payment-address-1"), "12 buckingham road");
        sendTextToElement(By.id("input-payment-city"), "London");
        sendTextToElement(By.id("input-payment-postcode"), "HA14EU");
        selectByValueFromDropDown(By.id("input-payment-zone"), "3524");
        //Click on “Continue” Button
        clickOnElement(By.id("button-guest"));
        //Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "I want a macbook");
        //Click on “Continue” button
        clickOnElement(By.id("button-shipping-method"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.id("button-payment-method"));
        //Verify the message “Warning: Payment method required!”
        clickOnElement(By.id("button-confirm"));
    }
}
