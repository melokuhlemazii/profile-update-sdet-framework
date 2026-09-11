package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinitions extends Base {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        homePage.clickLoginButton();
    }

    @And("I enter email (.*)$")
    public void i_enter_email(String email){
        loginPage.enterEmail(email);
    }

    @And("I enter password (.*)$")
    public void i_enter_password(String password){
        loginPage.enterPassword(password);
    }

    @When("I click login button")
    public void i_click_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("i should be logged in successfully")
    public void i_should_be_logged_successfully(){

    }

}





