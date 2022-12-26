package anhtester.com.pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomersPage {
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers";

    private By headerPageCustomers = By.xpath("//div[@class='panel-body']//h4[contains(.,'" + PAGE_TEXT + "')]");

    //Hàm xây dựng
    private WebDriver driver;

    public CustomersPage(WebDriver _driver) {
        driver = _driver;
    }

    public void verifyCustomersPage() {
        Assert.assertEquals(driver.getCurrentUrl(), PAGE_URL, "URL chưa đúng trang Customers.");
        Assert.assertTrue(WebUI.checkElementExist(driver, headerPageCustomers), "Header Page Customers not existing.");
        Assert.assertEquals(driver.findElement(headerPageCustomers).getText(), "Customers Report", "Header Page of Customers page not match.");

    }


}
