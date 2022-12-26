package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.CustomersPage;
import anhtester.com.pages.DashboardPage;
import anhtester.com.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testOpenMenuOnDashboard() {
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com", "123456");

        //Kiểm tra trang Dashboard là đúng
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();

        //Kiểm tra menu Customers click vào mở được trang
        dashboardPage.openCustomerPage();
        customersPage = new CustomersPage(driver);
        customersPage.verifyCustomersPage();
    }

    @Test
    public void testFilterWidgetsOnDashboard() {
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com", "123456");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        //Check Filter Widgets on Dashboard
        dashboardPage.verifyFilterStatistics();

    }

}
