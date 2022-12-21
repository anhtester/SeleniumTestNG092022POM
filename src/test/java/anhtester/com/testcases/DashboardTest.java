package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testTotalOnDashboard(){
        loginPage = new LoginPage(driver);

        loginPage.login("admin@example.com", "123456");

        //Viết vội cho nội dung ấy Total (phải để trong DashboardPage)
        By total = By.xpath("(//div[@id='widget-top_stats']//div[@class='top_stats_wrapper'])[2]");
        System.out.println(driver.findElement(total).getText());
    }

}
