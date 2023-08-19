package Mykiot;

import NPT.NptPageObjects.NptDetailGroceryStorePageObject;
import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import NPT.NptPageObjects.NptCreateGroceryStorePageObject;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static commons.GlobalConstants.NPT_LOGIN;

public class nptCreateGroceryStore extends BaseTest {
    WebDriver driver;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptCreateGroceryStorePageObject nptCreateGroceryStorePageObject;
    private NptDetailGroceryStorePageObject nptDetailGroceryStorePageObject;
    private String phoneNumber, storeName, passWord, webSite, storeEmail, representativeName, storeDescription,contactName,
            storeNameField,phoneNumberField,passWordField, websiteField, storeEmailField,representativeNameField,contactNameField,
            storeDescriptionField,storeNameTitle,phoneTitle, warningHint,emailTitle,representativeNameTitle,contactNameTitle,
            storeNameTit,emailHint,phoneNumberTit,websiteTit,passwordTit,emailTit,representativeNameTit;
    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
        phoneNumber = nptHomePage.generateRandomPhoneNumber();
        phoneNumberField = "Nhập số điện thoại";
        storeName = "Cửa hàng tạp hóa số 2" + nptCreateGroceryStorePageObject.getRandomInt();
        storeNameField = "Nhập tên CHTH";
        passWord = "12345678";
        passWordField = "Nhập mật khẩu";
        webSite = nptCreateGroceryStorePageObject.getRandomString();
        websiteField ="Nhập tên link cửa hàng";
        storeEmail = "email@store.com";
        storeEmailField = "Nhập email";
        representativeName = "Nguyen Van B";
        representativeNameField = "Nhập tên người đại diện";
        storeDescription = "Lorem ispum";
        storeDescriptionField = "Nhập mô tả";
        contactName = "Nguyen Van B";
        contactNameField = "Nhập tên người liên hệ";
        storeNameTitle = "Tên cửa hàng";
        phoneTitle = "Số điện thoại";
        warningHint = "Bạn cần điền vào mục này";
        emailHint = "Không đúng định dạng email";
        emailTitle = "Email";
        representativeNameTitle = "Người đại diện";
        contactNameTitle = "Người liên hệ";
        storeNameTit = "Tên CHTH";
        phoneNumberTit = "Số điện thoại";
        passwordTit = "Mật khẩu";
        websiteTit = "Địa chỉ Website";
        emailTit = "Email";
        representativeNameTit = "Người đại diện";
    }

    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Create_Store_With_Valid_Infor(){
        goToHomePage();
        nptCreateGroceryStorePageObject = nptHomePage.clickToManageGroceryStore();
        nptCreateGroceryStorePageObject.clickToCreateGroceryStore();
        //INSERT STORE INFO
        nptCreateGroceryStorePageObject.insertStoreInfor(storeName,storeNameField);
        nptCreateGroceryStorePageObject.insertStoreInfor(phoneNumber,phoneNumberField);
        nptCreateGroceryStorePageObject.insertStoreInfor(passWord,passWordField);
        nptCreateGroceryStorePageObject.insertStoreInfor(webSite, websiteField);
        nptCreateGroceryStorePageObject.insertStoreInfor(storeEmail,storeEmailField);
        nptCreateGroceryStorePageObject.insertStoreInfor(representativeName,representativeNameField);
        nptCreateGroceryStorePageObject.insertStoreInfor(contactName,contactNameField);
        nptCreateGroceryStorePageObject.selectAddress();
        nptCreateGroceryStorePageObject.selectOpenTime();
        nptCreateGroceryStorePageObject.selectBusinessType();
        nptCreateGroceryStorePageObject.insertStoreInfor(storeDescription,storeDescriptionField);
        nptCreateGroceryStorePageObject.selectCloseTime();
        nptCreateGroceryStorePageObject.insertStoreInfor(storeDescription,storeDescriptionField);
        nptDetailGroceryStorePageObject = nptCreateGroceryStorePageObject.clickSaveGroceryStore();
        //AFTER CREATING, INFOR MUST BE SAME AS INPUT
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(storeNameTitle),storeName);
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(phoneTitle),phoneNumber);
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(emailTitle),storeEmail);
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(representativeNameTitle),representativeName);
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(contactNameTitle),contactName);
    }
    @Test
    public void TC_02_Create_Store_Without_Input(){
        goToHomePage();
        nptCreateGroceryStorePageObject = nptHomePage.clickToManageGroceryStore();
        nptCreateGroceryStorePageObject.clickToCreateGroceryStore();
        //NOT INPUT ANYTHING, WARNING MESSAGE SHOULD BE SHOWN
        nptCreateGroceryStorePageObject.clickToInputField(storeNameField);
        nptCreateGroceryStorePageObject.clickToInputField(phoneNumberField);
        nptCreateGroceryStorePageObject.clickToInputField(passWordField);
        nptCreateGroceryStorePageObject.clickToInputField(websiteField);
        nptCreateGroceryStorePageObject.clickToInputField(representativeNameField);
        nptCreateGroceryStorePageObject.clickToInputField(contactNameField);
        //GET WARNING MESSAGE, IF FIELD IS BLANK THEN IT SHOULD BE DISPLAYED
        assertEquals(nptCreateGroceryStorePageObject.getWarningMessage(storeNameTit),warningHint);
        assertEquals(nptCreateGroceryStorePageObject.getWarningMessage(phoneNumberTit),warningHint);
        assertEquals(nptCreateGroceryStorePageObject.getWarningMessage(passwordTit),warningHint);
        assertEquals(nptCreateGroceryStorePageObject.getWarningMessage(websiteTit),warningHint);
        assertEquals(nptCreateGroceryStorePageObject.getWarningMessage(representativeNameTit),warningHint);
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}