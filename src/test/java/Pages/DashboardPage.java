package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div[1]/h2")
    WebElement dashboardHeading_xpath;

    @FindBy(xpath = "//span[normalize-space()='Menu']")
    WebElement userMenuButton_xpath;

    @FindBy(xpath = "//span[normalize-space()='My Profile']")
    WebElement myProfile_xpath;

    public void verifyDashboardPageIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(dashboardHeading_xpath));
        dashboardHeading_xpath.isDisplayed();
    }

    public void clickUserMenuButton_xpath(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(userMenuButton_xpath));
        userMenuButton_xpath.click();
    }

    public void clickMyProfile(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(myProfile_xpath));
        myProfile_xpath.click();
    }

}
