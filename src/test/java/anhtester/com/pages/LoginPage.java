package anhtester.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;

public class LoginPage {

    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";

    //Lưu Object của trang Login
    //Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");

    //Hàm xây dựng để truyền vào driver
    private WebDriver driver;

    public LoginPage(WebDriver _driver){
        driver = _driver;
    }

    //Viết các hàm xử lý cho trang Login
    public void verifyHeaderPage(){
        Assert.assertEquals(driver.findElement(headerPage).getText(), "Login", "FAIL. Header not match.");
    }

    public void verifyErrorMessageDisplay(){
        Assert.assertTrue(driver.findElement(messageErrorEmail).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(driver.findElement(messageErrorEmail).getText(), "Invalid email or password", "FAIL. Content of the Error message not match.");

    }

    public void enterEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickOnLoginButton(){
        driver.findElement(buttonLogin).click();
    }

    public void login(String email, String password){
        driver.get(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
    }

    public void loginInvalidEmail(String email, String password){
        driver.get(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        //Kểm tra message thông báo lỗi khi sai email
        verifyErrorMessageDisplay();
    }

}
