package Mykiot;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import NPT.NptPageObjects.NptPageUIs.NptLoginUI;
import reportConfig.ExtentTestManager;

import static commons.GlobalConstants.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class nptLogin extends BaseTest {
    WebDriver driver;
    private String account, password, accountInvalid, passwordInvalid;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject homePage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        homePage = new NptHomePageObject(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        account = "098452645538";
        accountInvalid = "090000000000";
        password = "123456789";
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
        assertEquals(loginPage.errorText(), "Sai số điện thoại hoặc mật khẩu");
        loginPage.clickToClosePopup();
        loginPage.clearValueInElementByDeleteKey(driver, NptLoginUI.ACCOUNT_FIELD);
        loginPage.clearValueInElementByDeleteKey(driver, NptLoginUI.PASSWORD_FIELD);
    }

    @Test
    public void TC_04_Login_With_Valid_Account(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with valid account");
        loginPage.loginWebsite(account, password);
        assertEquals(loginPage.welcomeText(), "Xin chào,");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
