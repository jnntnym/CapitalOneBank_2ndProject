package stepDef;

import base.BrowserSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hook extends BrowserSetup {
    public static String email;
    public static String password;
    public static String url;
    public static String envData= System.getProperty("env");            // -Denv Terminal
    public static String driverType = System.getProperty("browser");    // -Dbrowser  Terminal

    public static Properties prop = new Properties();                   // Create ref variable of property file

    @Before
    public void startTest() throws IOException {
       // Property file load
        InputStream inputFile = new FileInputStream("src/main/java/config/config.properties");
        prop.load(inputFile);

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
                url=prop.getProperty("urlQa");      // From property file
                email=prop.getProperty("emailQa");
                password=prop.getProperty("passwordQa");;
                break;
            case "stg":
                url =prop.getProperty("urlStg");
                email=prop.getProperty("emailStg");
                password=prop.getProperty("passwordStg");
                break;
            case "prod":
                url =prop.getProperty("urlProd");
                email=prop.getProperty("emailProd");
                password=prop.getProperty("passwordProd");
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
            driver.quit();
        }
    }
}

