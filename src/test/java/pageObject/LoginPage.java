package pageObject;

import base.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BrowserSetup {
    // Constructor
    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        BrowserSetup.driver = driver;
    }

    @FindBy(how = How.XPATH, using= "//input[@id='ods-input-0']")
    public WebElement emailLocator;

    @FindBy(how= How.XPATH, using = "//form[@id='account-log-in-new']/div[2]/div[1]/div[2]/div[1]/input")
    public WebElement passwordLocator;

    @FindBy(how = How.XPATH, using = "//button[@id='noAcctSubmit']")
    public WebElement signinButton;

    // Functions
    public void enterEmail(String email) {
        emailLocator.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordLocator.sendKeys(password);
    }
    public void signinButtonClick(){
        signinButton.click();
    }
}
