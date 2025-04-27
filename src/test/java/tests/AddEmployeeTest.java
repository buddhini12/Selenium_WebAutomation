package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddEmployeePage;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void testAddEmployeeSuccessfully() {
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);

        addEmployeePage.navigateToAddEmployeePage();
        addEmployeePage.addEmployeeDetails("Jane", "M", "Smith", 1234);
        addEmployeePage.saveEmployee();

        String message = addEmployeePage.getToastMessage();
        Assert.assertTrue(message.contains("Successfully Saved"), "Toast message not displayed as expected.");
        Assert.assertTrue(addEmployeePage.isRedirectedToEmployeeList(), "Not redirected to Employee List!");
    }
}
