package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class NewsPage {

    WebDriver driver;
    WebDriverWait wait;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//p[contains(text(),'Add Photos')]/ancestor::div[contains(@class,'oxd-sheet')]" +
            "//button[@type='submit' and contains(., 'Share')]")
    WebElement sharePhotoButton;

    @FindBy(xpath = "//p[contains(text(),'Add Video')]/ancestor::div[contains(@class,'oxd-sheet')]" +
            "//button[@type='submit' and contains(., 'Share')]")
    WebElement shareVideoButton;

    @FindBy(xpath = "//button[contains(text(), 'Share Photos')]")
    WebElement addPhotoButton;

    @FindBy(xpath = "//button[contains(text(), 'Share Photos')]")
    WebElement addVideoButton;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//p[contains(., 'Successfully Posted')]")
    WebElement successToast; // Or the actual element that shows the post success message

    // Actions

    public void clickSharePhotoButton() {
        System.out.println("Waiting for button visibility...");
        wait.until(ExpectedConditions.visibilityOf(sharePhotoButton));
        System.out.println("Button is visible. Waiting for it to be clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(sharePhotoButton)).click();
    }


    public void clickShareVideoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shareVideoButton)).click();
    }

    public void uploadMedia(String filePath) {
        wait.until(ExpectedConditions.visibilityOf(sharePhotoButton)).sendKeys(filePath);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isPostSuccessful() {
        try {
            WebElement toast = wait.until(ExpectedConditions.visibilityOf(successToast));
            return toast.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
