package StepDefinitions;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.StartBrowser("chrome",
            "https://ndosisimplifiedautomation.vercel.app/");

    DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    
}
