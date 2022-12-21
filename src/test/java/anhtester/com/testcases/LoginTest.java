package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void loginTestSuccess(){
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage(driver);

        //Gọi hàm "login" từ LoginPage để dùng
        loginPage.login("admin@example.com", "123456");
    }

    @Test
    public void loginTestInvalidEmail(){
        loginPage = new LoginPage(driver);
        loginPage.loginInvalidEmail("admin@example.com123", "123456");
    }

}
