package anhtester.com.pages.customers;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomersPage {
    //Các thuộc tính xác thực Customers Page
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";

    //Objects thuộc Customers Page
    private By headerPageCustomers = By.xpath("(//div[@class='panel-body']//h4)[1]");
    private By buttonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']//a[normalize-space()='Contacts']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By tdCustomerName = By.xpath("//table[@id='DataTables_Table_0']//tbody/tr[1]/td[3]/a");

    //Hàm xây dựng
    private WebDriver driver;

    public CustomersPage(WebDriver _driver) {
        driver = _driver;
    }

    //Các hàm xử lý cho chức năng thuộc Customers Page
    public void verifyCustomersPage() {
        Assert.assertEquals(driver.getCurrentUrl(), PAGE_URL, "URL chưa đúng trang Customers.");
        Assert.assertTrue(WebUI.checkElementExist(driver, headerPageCustomers), "Header Page Customers not existing.");
        Assert.assertEquals(driver.findElement(headerPageCustomers).getText(), PAGE_TEXT, "Header Page of Customers page not match.");

    }

    public AddNewCustomerPage clickNewCustomerButton(){
        WebUI.waitForElementVisible(driver, buttonAddCustomer, 10);
        driver.findElement(buttonAddCustomer).click();
        return new AddNewCustomerPage(driver);
    }

    public void searchCustomer(String companyName){
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, inputSearch, 10);
        driver.findElement(inputSearch).sendKeys(companyName);
        WebUI.sleep(2);
    }

    public CustomerDetailPage clickOnFirstRowCustomerName(){
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, tdCustomerName, 10);
        driver.findElement(tdCustomerName).click();

        return new CustomerDetailPage(driver);
    }


}
