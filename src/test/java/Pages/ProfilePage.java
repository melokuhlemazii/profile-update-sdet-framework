package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProfilePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div/div[1]/div[9]/button[1]")
    WebElement editProfile;

    @FindBy(id = "profilePicture")
    WebElement fileInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveChanges;

    public ProfilePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickEditProfile(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(editProfile));
        editProfile.click();
    }

    public void uploadNewProfilePicture(String fileName) {
        Path imagesDirectory = Path.of("src", "test", "resources", "images")
                .toAbsolutePath()
                .normalize();
        Path imagePath = imagesDirectory.resolve(fileName).normalize();
        if (!imagePath.startsWith(imagesDirectory) || !Files.isRegularFile(imagePath)) {
            throw new IllegalArgumentException("Profile picture not found in test resources: " + imagePath);
        }
        if (!"file".equalsIgnoreCase(fileInput.getAttribute("type"))) {
            throw new IllegalStateException("The profile picture element is not a file input");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].removeAttribute('hidden');"
                        + "arguments[0].style.display='block';"
                        + "arguments[0].style.visibility='visible';",
                fileInput);
        fileInput.sendKeys(imagePath.toString());
    }

    public void saveChanges(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(saveChanges));
        saveChanges.click();
    }

    public String getUploadSuccessMessage(int timeoutSeconds){
        WebElement alert = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.cssSelector(".alert-success, .toast-success, .ant-notification-notice-message, .alert.alert-success")));
        return alert.getText();
    }

    public boolean isUploadSuccessMessageContains(String expected, int timeoutSeconds){
        String msg = getUploadSuccessMessage(timeoutSeconds);
        return msg != null && msg.contains(expected);
    }

}
