package anhtester.com.pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddNewCustomerPage {

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client";
    private String PAGE_TEXT = "Customer Details";

    private By tabCustomerDetail = By.xpath("//a[@aria-controls='contact_info']");
    private By company = By.xpath("//input[@id='company']");
    private By vat = By.xpath("//input[@id='vat']");
    private By phoneNumber = By.xpath("//input[@id='phonenumber']");
    private By website = By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    private By inputGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']");
    private By currency = By.xpath("//button[@data-id='default_currency']");
    private By language = By.xpath("//button[@data-id='default_language']");
    private By address = By.xpath("//textarea[@id='address']");
    private By city = By.xpath("//input[@id='city']");
    private By state = By.xpath("//input[@id='state']");
    private By zipcode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//label[@for='country']/following-sibling::div");
    private By inputCountry = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    private WebDriver driver;

    public AddNewCustomerPage(WebDriver _driver) {
        driver = _driver;
    }

    public void AddDataNewCustomer(String CUSTOMER_NAME) {
        WebUI.waitForPageLoaded(driver);
        driver.findElement(company).sendKeys(CUSTOMER_NAME);
        driver.findElement(vat).sendKeys("10");
        driver.findElement(phoneNumber).sendKeys("0123456789");
        driver.findElement(website).sendKeys("https://anhtester.com");
        driver.findElement(dropdownGroups).click();
        driver.findElement(inputGroups).sendKeys("Gold", Keys.ENTER);
        driver.findElement(dropdownGroups).click();
        driver.findElement(address).sendKeys("Vietnam");
        driver.findElement(city).sendKeys("Can Tho");
        driver.findElement(state).sendKeys("Can Tho");
        driver.findElement(zipcode).sendKeys("92000");
        driver.findElement(dropdownCountry).click();
        driver.findElement(inputCountry).sendKeys("Vietnam", Keys.ENTER);
        driver.findElement(buttonSave).click();
        WebUI.waitForPageLoaded(driver);
    }

}
