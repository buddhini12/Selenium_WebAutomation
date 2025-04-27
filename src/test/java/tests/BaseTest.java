//package tests;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//import pages.LoginPage;
//
//import java.time.Duration;
//
//public class BaseTest {
//    protected WebDriver driver;
//
//    @BeforeClass
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//        // Perform login
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUsername("Admin");
//        loginPage.enterPassword("admin123");
//        loginPage.clickLogin();
//
//        // Wait for dashboard or handle it if needed
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        driver = new ChromeDriver(); // or your driver manager setup
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Do login once for entire suite
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
        }
    }
}
