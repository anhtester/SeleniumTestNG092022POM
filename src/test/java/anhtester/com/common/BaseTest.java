package anhtester.com.common;

import anhtester.com.keywords.WebUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void createBrowser() {
        WebDriverManager.chromedriver().setup();
        System.out.println("Start Chrome browser from BaseTest...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Chờ đợi trang load xong (trong 40s)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @AfterMethod
    public void closeBrowser() {
        WebUI.sleep(2);
        System.out.println("Close browser from BaseTest...");
        driver.quit();
    }
}
