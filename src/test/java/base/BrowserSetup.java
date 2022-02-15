package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {

    public static WebDriver driver;                                 // Global or class level static variable is driver

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
            driver = new SafariDriver();
        }else if(driverName.equalsIgnoreCase("sf")){     // ie = internet explorer
            WebDriverManager.iedriver().setup();
            driver = new SafariDriver();
        }
        // Driver actions
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }
}
