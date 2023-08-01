package Mykiot;

import AdminPageObjects.AdminHomePageObject;
import AdminPageObjects.AdminLoginPageObject;
import AdminPageObjects.AdminOrderPageObject;
import AdminPageUIs.*;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static commons.GlobalConstants.*;

import static commons.GlobalConstants.ADMIN_LOGIN;
import static org.testng.Assert.*;

public class adminCreateOrder extends BaseTest {
    WebDriver driver;
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject adminHomePage;
    private AdminOrderPageObject adminOrderPageObject;
    private String account,password;
    @BeforeClass
    public void beforeClass(){
        account = "0856174003";
        password = "01";
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        adminHomePage = loginPage.loginWebsite(account, password);
    }
    public void goToHomePage() {
        adminHomePage.openPageUrl(driver, ADMIN_LOGIN);
    }
    @Test
    public void TC_01_Not_Insert_Anything(){
        goToHomePage();
        adminOrderPageObject = adminHomePage.clickToCreateOrder();
        Assert.assertFalse(adminOrderPageObject.isSaveButtonEnabled());
    }
    @Test
    public void TC_02_Select_Only_Counterparty(){
        goToHomePage();
        adminOrderPageObject = adminHomePage.clickToCreateOrder();
        adminOrderPageObject.selectCounterparty();
        Assert.assertFalse(adminOrderPageObject.isSaveButtonEnabled());
    }
    @Test
    public void TC_03_Select_Only_Product(){
        goToHomePage();
        adminOrderPageObject = adminHomePage.clickToCreateOrder();
        adminOrderPageObject.clickToAddProduct();
        Assert.assertFalse(adminOrderPageObject.isSaveButtonEnabled());
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}