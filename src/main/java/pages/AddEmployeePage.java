package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddEmployeePage {

    WebDriver driver;
    WebDriverWait wait;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    private WebElement pimTab;

    @FindBy(xpath = "//a[contains(text(),'Add Employee')]")
    private WebElement addEmployeeTab;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast')]//p[contains(text(),'Successfully Saved')]")
    private WebElement successToast;

    @FindBy(xpath = "//h6[text()='Employee Information']")
    private WebElement employeeListHeading;

    public void navigateToAddEmployeePage() {
        wait.until(ExpectedConditions.elementToBeClickable(pimTab)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeTab)).click();
    }

    public void addEmployeeDetails(String firstName, String middleName, String lastName, int id) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
        middleNameInput.sendKeys(middleName);
        lastNameInput.sendKeys(lastName);
        employeeIdInput.sendKeys(String.valueOf(id));
    }

    public void saveEmployee() {
        saveButton.click();
    }

    public String getToastMessage() {
        wait.until(ExpectedConditions.visibilityOf(successToast));
        String toastText = successToast.getText();
        System.out.println("Toast message captured: " + toastText);
        return toastText;
    }

    public boolean isRedirectedToEmployeeList() {
        return wait.until(ExpectedConditions.visibilityOf(employeeListHeading)).isDisplayed();
    }
}
