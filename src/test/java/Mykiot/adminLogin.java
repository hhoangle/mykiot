package Mykiot;
import com.aventstack.extentreports.Status;
import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import AdminPageObjects.*;
import AdminPageUIs.*;
import reportConfig.ExtentTestManager;

import static commons.GlobalConstants.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
public class adminLogin extends BaseTest {
    WebDriver driver;
    private String account, password, accountInvalid, passwordInvalid;
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        homePage = new AdminHomePageObject(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        account = "0856174003";
        accountInvalid = "090000000000";
        password = "01";
        passwordInvalid = "1234567899";
    }
    @Test
    public void TC_01_Verify_UI_Before_Test(Method method) {
        loginPage.verifySavePasswordButtonIsUnchecked();
        loginPage.verifyLoginButtonIsDisabled();
    }
    @Test
    public void TC_02_Login_Without_Input_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login Empty Data");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click Account Textbox");
        loginPage.clickToAccountTextbox();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Click Password Textbox");
        loginPage.clickToPasswordTextbox();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click Account Textbox again");
        loginPage.clickToAccountTextbox();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Verify Error Message At Account Textbox");
        assertEquals(loginPage.getErrorMessageAtAccountTextbox(), "Bạn cần điền vào mục này");

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Error Message At Password Textbox");
        assertEquals(loginPage.getErrorMessageAtPassworkTextbox(), "Bạn cần điền vào mục này");
    }

    @Test
    public void TC_03_Login_With_Invalid_account(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with valid account");
        loginPage.loginWebsite(accountInvalid, passwordInvalid);
        assertEquals(loginPage.errorText(), "Sai tên hoặc sai mật khẩu hoặc hệ thống");
        loginPage.clickToClosePopup();
        loginPage.clearValueInElementByDeleteKey(driver, AdminLoginUI.ACCOUNT_FIELD);
        loginPage.clearValueInElementByDeleteKey(driver, AdminLoginUI.PASSWORD_FIELD);
    }

    @Test
    public void TC_04_Login_With_Valid_Account(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with valid account");
        loginPage.loginWebsite(account, password);
        assertEquals(loginPage.welcomeText(), "Đơn hàng");
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
