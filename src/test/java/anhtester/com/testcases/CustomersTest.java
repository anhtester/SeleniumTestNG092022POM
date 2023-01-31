package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.AddNewCustomerPage;
import anhtester.com.pages.CustomersPage;
import anhtester.com.pages.DashboardPage;
import anhtester.com.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomersTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    AddNewCustomerPage addCustomerPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("admin@example.com", "123456");
        customersPage = dashboardPage.openCustomerPage();

        customersPage.verifyCustomersPage();
        addCustomerPage = customersPage.clickNewCustomerButton();

        //Addison, Joseph, Adorno, Theodor, Keiko, Bailey, Philip James
        addCustomerPage.AddDataNewCustomer("Creighton");
    }

}
