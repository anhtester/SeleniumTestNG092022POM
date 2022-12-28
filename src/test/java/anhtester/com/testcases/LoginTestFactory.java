package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.LoginPageFactory;
import org.testng.annotations.Test;

public class LoginTestFactory extends BaseTest {

    LoginPageFactory loginPageFactory;

    @Test
    public void testLoginSuccess() {
        loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.login("admin@example.com", "123456");
    }
}
