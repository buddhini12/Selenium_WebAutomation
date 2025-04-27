//package tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class LoginTest extends BaseTest {
//
//    @Test(priority = 1)
//    public void testLogin() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement headerText = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")));
//
//        Assert.assertTrue(headerText.isDisplayed(), "Dashboard header not visible.");
//        System.out.println("Login successful. Dashboard visible.");
//    }
//}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testLogin() {
        // Assume user is already logged in from @BeforeSuite
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")));

        Assert.assertEquals(dashboardHeader.getText(), "Dashboard", "User is not on the Dashboard page.");
        System.out.println("Login verified successfully. Dashboard is visible.");
    }
}
