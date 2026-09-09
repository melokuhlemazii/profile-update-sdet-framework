package StepDefinitions;

import io.cucumber.java.en.Given;

public class StepsDefinitions extends Base {

    @Given("i am on the login page")
    public void i_am_on_the_login_page() {
        homePage.clickLoginButton();
    }
}





