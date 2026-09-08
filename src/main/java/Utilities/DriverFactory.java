package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver StartBrowser(String browserChoice, String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        EdgeOptions edgeOptions = new EdgeOptions();

        if (browserChoice.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver(chromeOptions);
        } else if (browserChoice.equalsIgnoreCase("edge")){
            edgeOptions.addArguments("--headless");
            driver = new EdgeDriver();
        } else {
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

}
