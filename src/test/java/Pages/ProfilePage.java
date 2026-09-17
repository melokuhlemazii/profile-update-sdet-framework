package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProfilePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div/div[1]/div[9]/button[1]")
    WebElement editProfile;

    @FindBy(xpath = "//label[@for='profilePicture']")
    WebElement choosePhoto;

    public ProfilePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickEditProfile(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(editProfile));
        editProfile.click();
    }

    public void choosePhoto(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(choosePhoto));
        choosePhoto.click();
    }

}
