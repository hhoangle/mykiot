package Mykiot;

import NPT.NptPageObjects.NptDetailGroceryStorePageObject;
import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import NPT.NptPageObjects.NptCreateGroceryStorePageObject;
import NPT.NptPageObjects.NptPageUIs.NptDetailGroceryPageUI;
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
            storeNameField,phoneNumberField,passWordField, website_field, storeEmailField,representativeNameField,contactNameField,
            storeDescriptionField,storeNameTitle,phoneTitle, webSiteTitle,emailTitle,representativeNameTitle,contactNameTitle;

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
        website_field ="Nhập tên link cửa hàng";
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
        webSiteTitle = "Website";
        emailTitle = "Email";
        representativeNameTitle = "Người đại diện";
        contactNameTitle = "Người liên hệ";
    }
    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Create_Store(){
        goToHomePage();
        nptCreateGroceryStorePageObject = nptHomePage.clickToManageGroceryStore();
        nptCreateGroceryStorePageObject.clickToCreateGroceryStore();
        nptCreateGroceryStorePageObject.insertStoreInfor(storeName,storeNameField);
        nptCreateGroceryStorePageObject.insertStoreInfor(phoneNumber,phoneNumberField);
        nptCreateGroceryStorePageObject.insertStoreInfor(passWord,passWordField);
        nptCreateGroceryStorePageObject.insertStoreInfor(webSite,website_field);
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
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(driver,NptDetailGroceryPageUI.STORE_NAME_IN_DETAIL_PAGE,storeNameTitle),storeName);
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(driver,NptDetailGroceryPageUI.STORE_NAME_IN_DETAIL_PAGE,phoneTitle),phoneNumber);
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(driver,NptDetailGroceryPageUI.STORE_NAME_IN_DETAIL_PAGE,emailTitle),storeEmail);
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(driver,NptDetailGroceryPageUI.STORE_NAME_IN_DETAIL_PAGE,representativeNameTitle),representativeName);
        assertEquals(nptDetailGroceryStorePageObject.getInforInDetailPage(driver,NptDetailGroceryPageUI.STORE_NAME_IN_DETAIL_PAGE,contactNameTitle),contactName);
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
