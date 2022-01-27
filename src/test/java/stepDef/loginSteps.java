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
    public void iAmAtCapitalOneBankHomePage() {
        String actual =driver.getTitle();
        String exp = "Capital One Credit Cards, Bank, and Loans - Personal and Business";
        Assert.assertEquals(actual, exp);
        System.out.println("You are in the right page");
    }
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
    public void iAmNotAbleToLoginSuccessfully() {
        System.out.println("User should not be able to login successfully");
        System.out.println("Test report will generate successfully under target folder");
    }

}