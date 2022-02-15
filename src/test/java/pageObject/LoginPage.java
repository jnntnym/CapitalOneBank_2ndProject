package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends loginCredential2 implements LoginCredential {  // reg extends abstract implements interface

    WebDriver driver;
    // BrowserSetup browserSetup = new BrowserSetup();  // No need to instantiation

    // Constructor for
    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        //   BrowserSetup.driver= driver;            // previous, works when extends
        this.driver = driver;
    }
    //Locators
    @FindBy(how = How.XPATH, using= "//input[@id='ods-input-0']")
    public WebElement emailLocator;

    @FindBy(how= How.XPATH, using = "//form[@id='account-log-in-new']/div[2]/div[1]/div[2]/div[1]/input")
    public WebElement passwordLocator;

    @FindBy(how = How.XPATH, using = "//button[@id='noAcctSubmit']")
    public WebElement signinButton;

    @FindBy(how = How.XPATH, using="//h1[@class='ci-page-header']")
    public WebElement getErrorMessage;

    @FindBy (how = How.XPATH, using="//a[@class='ods-button ods-button--progressive']")
    public WebElement okayButton;

    // Functions
    @Override           // from abstract Class
    public void homePageAssert(){}
    public void enterEmail(String email) {
        emailLocator.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordLocator.sendKeys(password);
    }
    @Override           // from Interface Class
    public void signinButtonClick(){
        signinButton.click();
    }
    public void notAbleLogin() {
        System.out.println("User should not be able to login successfully");
        System.out.println("Test report will generate successfully under target folder");
    }
    @Override           // from Interface Class
    public void getErrorText(){
        System.out.println(getErrorMessage.getText());
    }
    public void clickOkayButton(){
        okayButton.click();
        System.out.println("Okay button clicked");
    }
    public void getSigninTitle(){
        System.out.println("Return to page--> "+driver.getTitle());
    }
}