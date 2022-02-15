package pageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

abstract class loginCredential2 {

    WebDriver driver;

    public void homePageAssert(){
        String actual =driver.getTitle();
        String exp = "Capital One Credit Cards, Bank, and Loans - Personal and Business";
        Assert.assertEquals(actual, exp);
        System.out.println("You are in the right page");
    }
}
