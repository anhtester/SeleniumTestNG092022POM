package anhtester.com.pages.customers;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerDetailPage extends AddNewCustomerPage {

    //Object in Customer Detail page
    //Không phải khai báo lại Object vì đã kế thừa từ AddNewCustomerPage
    //Không bị duplicated
    //Tiết kiệm thời gian
    //Lỡ có thay đổi thì chỉ cần sửa ở 1 nơi => AddNewCustomerPage

    private WebDriver driver;

    public CustomerDetailPage(WebDriver _driver) {
        super(_driver);
        driver = _driver;
    }

    public void checkCustomerDetail(String customerName) {
        WebUI.waitForPageLoaded(driver);
        System.out.println(driver.findElement(company).getAttribute("value"));
        System.out.println(driver.findElement(vat).getAttribute("value"));
        System.out.println(driver.findElement(phoneNumber).getAttribute("value"));

        //Kiểm tra thì phải dùng Assert
        //Phải dùng Equals chứ không nên dùng Contains vì giá trị phải đúng chính xác
        Assert.assertEquals(driver.findElement(company).getAttribute("value"), customerName, "Company Name not match.");
        Assert.assertEquals(driver.findElement(vat).getAttribute("value"), "10", "VAT not match.");
        Assert.assertEquals(driver.findElement(phoneNumber).getAttribute("value"), "0123456789", "Phone Number not match.");

    }

}
