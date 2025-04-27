package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // Constructor calls BasePage constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement loginButton;

    // Actions
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")));
    }
}
