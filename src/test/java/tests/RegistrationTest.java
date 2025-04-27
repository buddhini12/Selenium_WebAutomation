//package tests;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.RegistrationPage;
//
//public class RegistrationTest extends BaseTest {
//    RegistrationPage registrationPage;
//
package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    private RegistrationPage registrationPage;

    @BeforeMethod
    public void goToRegistrationPage() {
        // Navigate directly to the registration page after login is handled in BaseTest
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");
        registrationPage = new RegistrationPage(driver);
    }

    @Test(priority = 2)
    public void testRegistration() {
        registrationPage.enterEmpName("John", "John Doe");
        registrationPage.enterUserName("DoeTest123");
        registrationPage.enterPassword("doe1234");
        registrationPage.confirmPassword("doe1234");
        registrationPage.selectUserRole("Admin");
        registrationPage.selectStatus("Enabled");
        registrationPage.saveUser();

        System.out.println("User registration test completed.");
    }
}
