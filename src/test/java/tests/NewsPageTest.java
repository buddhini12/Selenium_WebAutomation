package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NewsPage;

public class NewsPageTest extends BaseTest {

    NewsPage newsPage;

    @BeforeMethod
    public void navigateToBuzzPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz");
        newsPage = new NewsPage(driver);
    }

    @Test(priority = 1)
    public void testSharePhoto() {
        newsPage.clickSharePhotoButton();
        newsPage.uploadMedia(System.getProperty("user.dir") + "src/main/resources/testFiles/pexels-enginakyurt-1642228.jpg");
        newsPage.clickSubmit();

        Assert.assertTrue(newsPage.isPostSuccessful(), "Photo sharing failed!");
        System.out.println("Photo shared successfully.");
    }

    @Test(priority = 2)
    public void testShareVideo() {
        newsPage.clickShareVideoButton();
        newsPage.uploadMedia(System.getProperty("user.dir") + "src/main/resources/testFiles/855282-hd_1280_720_25fps.mp4");
        newsPage.clickSubmit();

        Assert.assertTrue(newsPage.isPostSuccessful(), "Video sharing failed!");
        System.out.println("Video shared successfully.");
    }
}
