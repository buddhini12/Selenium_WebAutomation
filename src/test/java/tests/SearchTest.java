//package tests;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.LoginPage;
//import pages.SearchPage;
//
//public class SearchTest extends BaseTest {
//
//    private LoginPage loginPage;
//    private SearchPage searchPage;
//
//    @BeforeMethod
//    public void setUpTest() {
//        loginPage = new LoginPage(driver);
//        searchPage = new SearchPage(driver);
//
//        // Login before performing search
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        loginPage.login("Admin", "admin123");
//    }
//
//    @Test(priority = 1)
//    public void testSearchUser() {
//        searchPage.navigateToSystemUsersPage();
//        searchPage.searchUser("Admin");
//
//        boolean isFound = searchPage.isUserFound("Admin");
//        Assert.assertTrue(isFound, "User 'Admin' should be found in the search results.");
//    }
//
//    @Test(priority = 2)
//    public void testResetFunctionality() {
//        searchPage.navigateToSystemUsersPage();
//        searchPage.searchUser("Admin");
//        searchPage.resetSearch();
//
//        boolean isCleared = searchPage.isSearchBoxCleared();
//        Assert.assertTrue(isCleared, "Search box should be empty after clicking reset.");
//    }
//}


package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeMethod
    public void setUpTest() {
        searchPage = new SearchPage(driver);
        // Ensure the test starts from the System Users page, assuming you're already logged in.
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    }

    @Test(priority = 1)
    public void testSearchUser() {
        searchPage.searchUser("Admin");

        boolean isFound = searchPage.isUserFound("Admin");
        Assert.assertTrue(isFound, "User 'Admin' should be found in the search results.");
    }

    @Test(priority = 2)
    public void testResetFunctionality() {
        searchPage.searchUser("Admin");
        searchPage.resetSearch();

        boolean isCleared = searchPage.isSearchBoxCleared();
        Assert.assertTrue(isCleared, "Search box should be empty after clicking reset.");
    }
}
