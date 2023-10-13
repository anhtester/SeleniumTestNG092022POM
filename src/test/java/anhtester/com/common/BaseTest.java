package anhtester.com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

      public WebDriver driver;

      @BeforeMethod
      @Parameters({"browser"})
      public void createDriver(@Optional("chrome") String browser) {
            setupDriver(browser);
      }

      public WebDriver setupDriver(String browserName) {
            switch (browserName.trim().toLowerCase()) {
                  case "chrome":
                        driver = initChromeDriver();
                        break;
                  case "firefox":
                        driver = initFirefoxDriver();
                        break;
                  case "edge":
                        driver = initEdgeDriver();
                        break;
                  default:
                        System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                        driver = initChromeDriver();
            }
            return driver;
      }

      private WebDriver initChromeDriver() {
            System.out.println("Launching Chrome browser...");
            //WebDriverManager.chromedriver().setup(); //Selenium 4.11.0 về sau không cần dùng WDM
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
      }

      private WebDriver initEdgeDriver() {
            System.out.println("Launching Edge browser...");
            //WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            return driver;
      }

      private WebDriver initFirefoxDriver() {
            System.out.println("Launching Firefox browser...");
            //WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
      }

      @AfterMethod
      public void closeDriver() {
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Reset timeout
            if (driver != null) {
                  driver.quit();
            }
      }

}
