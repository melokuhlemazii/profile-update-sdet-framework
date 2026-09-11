package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {
    static WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Access Learning Materials']")
    WebElement loginHeading_xpath;

    @FindBy(id = "login-email")
    WebElement loginEmail_id;

    @FindBy(id = "login-password")
    WebElement loginPassword_id;

    @FindBy(id = "login-submit")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyLoginPageIsDisplayed(){
        // Wait for the email input to be visible which reliably indicates the login page
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loginEmail_id));
        loginEmail_id.isDisplayed();
    }

    public void enterEmail(String email){
        loginEmail_id.sendKeys(email);
    }

    public void enterPassword(String password){
        loginPassword_id.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

}
