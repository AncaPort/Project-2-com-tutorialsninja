package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * ● Create the package name desktops
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Total "£74.73"
 */
public class DesktopsTest extends Utility {
    @Before
    public void setUp() {
        multiBrowser(baseUrl);
    }

    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    //1.1 Mouse hover on Desktops Tab.and click
    //1.2 Click on “Show All Desktops”
    //1.3 Select Sort By position "Name: Z to A"
    //1.4 Verify the Product will arrange in Descending order.
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverAndClickToElement(By.xpath("//a[normalize-space()='Desktops']"));
        // 1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        // 1.3 Select Sort By position "Name: Z to A"
        selectByValueFromDropDown(By.id("input-sort"), "https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC");
        // 1.4 Verify the Product will arrange in Descending order.
        verifyExpectedAndActual(By.xpath("//option[contains(text(),'Name (Z - A)')]"), "Name (Z - A)");
    }

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
// * 2.1 Mouse hover on Currency Dropdown and click
// * 2.2 Mouse hover on £Pound Sterling and click
// * 2.3 Mouse hover on Desktops Tab.
// * 2.4 Click on “Show All Desktops”
// * 2.5 Select Sort By position "Name: A to Z"
// * 2.6 Select product “HP LP3065”
// * 2.7 Verify the Text "HP LP3065"
// * 2.8 Select Delivery Date "2023-11-27"
// * 2.9.Enter Qty "1” using Select class.
// * 2.10 Click on “Add to Cart” button
// * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
// * 2.12 Click on link “shopping cart” display into success message
// * 2.13 Verify the text "Shopping Cart"
// * 2.14 Verify the Product name "HP LP3065"
// * 2.15 Verify the Delivery Date "2023-11-27"
// * 2.16 Verify the Model "Product21"
// * 2.17 Verify the Total "£74.73"
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Currency Dropdown and click
        mouseHoverAndClickToElement(By.xpath("//span[normalize-space()='Currency']"));
        //  2.2 Mouse hover on £Pound Sterling and click
        mouseHoverAndClickToElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        // * 2.3 Mouse hover on Desktops Tab.
        mouseHoverAndClickToElement(By.xpath("//a[normalize-space()='Desktops']"));
        // * 2.4 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //* 2.5 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.id("input-sort"), "https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=ASC");
        //2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        // 2.7 Verify the Text "HP LP3065"
        Assert.assertEquals("HP LP3065", getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']")));
        //2.8 Select Delivery Date "2023-11-27"
        String year = "2023";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); // Open the calendar
        while (true) {
            String monthAndYear = getTextFromElement(By.xpath("//div[@class='datepicker-days']//thead//tr[1]"));
            String[] a = monthAndYear.split(" ");
            String mon = a[1];
            String yer = a[2];
            if (mon.equals(month) && yer.equals(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        // Select the Date
        List<WebElement> allDates = driver.findElements(By.xpath("//td[contains(@class,'day')]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }
        //Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
        //Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Assert.assertEquals("Success: You have added HP LP3065 to your shopping cart!", getTextFromElement(By.xpath("//div[contains(text(),'Success')]")).substring(0, 56));
        //Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));
        //Verify the text "Shopping Cart"
        Assert.assertEquals("Shopping Cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).substring(0, 13));
        //Verify the Product name "HP LP3065"
        Assert.assertEquals("HP LP3065", getTextFromElement(By.linkText("HP LP3065")));
        //Verify the Delivery Date "2023-11-27"
        Assert.assertEquals("2023-11-27", getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']")).substring(14, 24));
        //Verify the Model "Product21"
        Assert.assertEquals("Product 21", getTextFromElement(By.xpath("//td[normalize-space()='Product 21']")));
        //Verify the Total "£74.73"
        Assert.assertEquals("£74.73", getTextFromElement(By.xpath("(//td[contains(text(),'£74.73')])[4]")));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
