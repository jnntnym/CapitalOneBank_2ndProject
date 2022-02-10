package stepDef;

import base.BrowserSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

public class Hook extends BrowserSetup {
    public static String email;
    public static String password;
    public static String url;
    public static String envData= System.getProperty("env");            // -Denv Terminal
    public static String driverType = System.getProperty("browser");    // -Dbrowser  Terminal

    @Before
    public void startTest(){
        // default driver                            // Don't change any order
        if (Strings.isNullOrEmpty(driverType)){
            driverType="ch";
        }
        // default envData
        if(Strings.isNullOrEmpty(envData)){
            envData="qa";
        }
        // Choose the envData, which we want to
        driver = setupBrowser(driverType);           // Calling method from base class -BrowserSetup
        switch (envData){
            case "qa":
                url ="https://www.capitalone.com/";
                email="abc1@gmail.com";
                password="abc123";
                break;
            case "stg":
                url ="https://www.capitalone.com/";
                email="abc2@gmail.com";
                password="abc456";
                break;
            case "prod":
                url ="https://www.capitalone.com/";
                email="abc3@gmail.com";
                password="abc789";
                break;
        }
        driver.get(url);
    }
    @After
    public void endTest(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // embed it in the report.
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } catch(Exception e){
            System.out.println("Try block not working properly; Test Report not generated");
        }
        finally {
          //  driver.quit();
        }
    }
}

