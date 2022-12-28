package anhtester.com.pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class LoginPageFactory {

    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";

    //Khai báo object - là đối tượng WebElement
//    @FindBy(xpath = "//input[@id='email']")
//    private WebElement inputEmail;

    @FindAll({@FindBy(id = "email"), @FindBy(xpath = "//input[@type='email']")})
    @CacheLookup()
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;

    @FindBy(xpath = "/h1")
    private WebElement headerPage;

    @FindBys(@FindBy(xpath = "//aside[@id='menu']/ul/li"))
    private List<WebElement> menu;

    //Khai báo hàm xây dựng
    private WebDriver driver;

    public LoginPageFactory(WebDriver _driver) {
        driver = _driver;
        //Gọi hàm initElements của class PageFactory để khởi tạo các WebElement bên trên
        PageFactory.initElements(driver, this);
    }

    //Viết các hàm xử lý

    public void clickOnMenuByName(String menuName) {
        By menu = By.xpath("//span[normalize-space()='" + menuName + "']");
        driver.findElement(menu).click();
    }

    public void clickOnMenuByName2(String menuName) {
//        @FindBy(xpath = "//span[normalize-space()='" + menuName + "']")
//        WebElement headerPage;
//        headerPage.click();

        WebElement headerPage = driver.findElement(By.xpath("//span[normalize-space()='" + menuName + "']"));
        headerPage.click();
    }

    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickOnLoginButton() {
        buttonLogin.click();
    }

    public void login(String email, String password) {
        driver.get(URL);
//        inputEmail.sendKeys(email);
//        inputPassword.sendKeys(password);
//        buttonLogin.click();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        WebUI.sleep(3);

        //Kiểm tra @FindBys => List WebElement
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i).getText());
        }
    }

}
