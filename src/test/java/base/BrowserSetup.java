package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {

    public static WebDriver driver; // Global or class level static variable is driver

    public static WebDriver setupBrowser(String driverName){        // String Return type method
        // Driver choose
        if (driverName.equalsIgnoreCase("ch")){         // ch= chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (driverName.equalsIgnoreCase("ff")){    // ff = firefox
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }else if(driverName.equalsIgnoreCase("ie")){     // ie = internet explorer
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        // Driver actions
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
