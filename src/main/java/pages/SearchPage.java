package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//label[text()='Username']/following::input[contains(@class, 'oxd-input')][1]")
    WebElement usernameSearchBox;

    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'oxd-button') and contains(., 'Search')]")
    WebElement searchButton;


    @FindBy(xpath = "//*[@id='app']//form//button[1]")
    WebElement resetButton;


    // Actions

    public void searchUser(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameSearchBox));
        usernameSearchBox.clear();
        usernameSearchBox.sendKeys(username);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        // Optional: Wait for search results table to be refreshed
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='oxd-table-body']")));
    }

    public void resetSearch() {
        // Wait until the Reset button is visible and clickable
        wait.until(ExpectedConditions.visibilityOf(resetButton));
        wait.until(ExpectedConditions.elementToBeClickable(resetButton)).click();

        // Ensure the search box is cleared after reset
        wait.until(ExpectedConditions.attributeToBe(usernameSearchBox, "value", ""));
    }

    //   // Optional: Wait for input to be cleared
    //       Verifying user found in search results
    public boolean isUserFound(String username) {
        try {
            WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='oxd-table-body']//div[text()='" + username + "']")));
            return user.isDisplayed();
        } catch (Exception e) {
            return false; // Return false if the user is not found
        }
    }

    // Verifying if the search box is cleared after reset
    public boolean isSearchBoxCleared() {
        wait.until(ExpectedConditions.visibilityOf(usernameSearchBox));
        return usernameSearchBox.getAttribute("value").isEmpty();
    }
}










