package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class StepsDefinitions extends Base {

    @Given("i am on the login page")
    public void i_am_on_the_login_page() {
        homePage.clickLoginButton();
    }

    @And("i enter email (.*)$")
    public void i_enter_email(String email){
        loginPage.enterEmail(email);
    }
}





