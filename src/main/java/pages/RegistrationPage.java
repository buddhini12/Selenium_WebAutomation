package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    // Constructor
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Text fields
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement empName;

    @FindBy(xpath = "(//input[@autocomplete='off' and contains(@class, 'oxd-input--active')])[1]")
    WebElement userName;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement passwordField;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPasswordField;

    @FindBy(css = "button[type='submit']")
    WebElement saveButton;

    // Custom dropdowns
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
    WebElement userRoleDropdown;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    WebElement statusDropdown;

    // Methods to interact with elements
    public void enterEmpName(String empNameText, String suggestionToSelect) {
        wait.until(ExpectedConditions.elementToBeClickable(empName)).sendKeys(empNameText);

        // Wait and click the matching suggestion
        By suggestionLocator = By.xpath("//div[@role='option']//span[text()='" + suggestionToSelect + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionLocator)).click();
    }

    public void enterUserName(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String pwd) {
        passwordField.sendKeys(pwd);
    }

    public void confirmPassword(String confirmpwd) {
        confirmPasswordField.sendKeys(confirmpwd);
    }

    public void selectUserRole(String role) {
        wait.until(ExpectedConditions.visibilityOf(userRoleDropdown)).click();
        By optionLocator = By.xpath("//div[@role='option']//span[text()='" + role + "']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    public void selectStatus(String status) {
        wait.until(ExpectedConditions.visibilityOf(statusDropdown)).click();
        By optionLocator = By.xpath("//div[@role='option']//span[text()='" + status + "']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    public void saveUser() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
