package stepDef;

import base.BrowserSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.LoginPage;

// Login steps comes from login.feature
public class loginSteps extends BrowserSetup {

    LoginPage login = new LoginPage(driver);

    @Given("I am at Capital one bank home page")
    public void iAmAtCapitalOneBankHomePage() {login.homePageAssert();}
    @And("I enter valid email")
    public void iEnterValidEmail() {
        login.enterEmail(Hook.email);
    }
    @And("I enter invalid password")
    public void iEnterInvalidPassword() {
        login.enterPassword(Hook.password);
    }
    @When("I click login button")
    public void iClickLoginButton() {
        login.signinButtonClick();
    }
    @Then("I am not able to login successfully")
    public void iAmNotAbleToLoginSuccessfully() {login.notAbleLogin();}
    @Then("I able to fetch the error message")
    public void iAbleToFetchTheErrorMessage() {login.getErrorText();}
    @Then("I clicked on Okay button to return to Signin")
    public void iClickedOnOkayButtonToReturnToSignin() {login.clickOkayButton();}
    @Then("I am at Signin page")
    public void iAmAtSigninPage() {login.getSigninTitle();}
}