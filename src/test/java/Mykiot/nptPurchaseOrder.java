package Mykiot;

import NPT.NptPageObjects.*;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;

import static commons.GlobalConstants.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class nptPurchaseOrder extends BaseTest {
    WebDriver driver;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptPurchaseOrderPageObject nptPurchaseOrderPageObject;
    private NptCreatePurchaseOrderPageObject nptCreatePurchaseOrderPageObject;
    private String warningMessage, waitToConfirmOrderStatus, confirmedOrderStatus, completedOrderStatus,
            selectDenyReasonWarning, denyReason, denyReceiveStatus, denyOrderStatus;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        warningMessage = "Vui lòng chọn sản phẩm và số lượng";
        waitToConfirmOrderStatus = "Chờ xác nhận";
        confirmedOrderStatus = "Đã xác nhận";
        completedOrderStatus = "Hoàn thành";
        denyReceiveStatus = "Từ chối";
        denyOrderStatus = "Từ chối nhận";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
    }
    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Create_Purchase_Order_Without_Select_Product() {
        goToHomePage();
        nptPurchaseOrderPageObject = nptHomePage.clickToPurchaseOrder();
        nptCreatePurchaseOrderPageObject = nptPurchaseOrderPageObject.clickToCreatePurchaseOrderButton();
        nptCreatePurchaseOrderPageObject.clickToContinueButton();
        //IF NOT SELECT ANY PRODUCT THEN CLICK CONTINUE, WARNING POPUP SHOULD BE DISPLAYED
        assertEquals(nptCreatePurchaseOrderPageObject.getWarningMessage(), warningMessage);
    }
    @Test
    public void TC_02_Create_Purchase_Order() {
        goToHomePage();
        nptPurchaseOrderPageObject = nptHomePage.clickToPurchaseOrder();
        nptCreatePurchaseOrderPageObject = nptPurchaseOrderPageObject.clickToCreatePurchaseOrderButton();
        //SELECTED ITEMS MUST BE DISPLAYED IN THE CONFIRMATION SCREEN
        nptCreatePurchaseOrderPageObject.selectThreeFirstProduct();
        nptCreatePurchaseOrderPageObject.clickConfirmPurchaseOrder();
        //AFTER CREATED SUCCESSFULLY, PURCHASE ORDER STATUS MUST BE "WAIT TO CONFIRM"
        assertEquals(nptCreatePurchaseOrderPageObject.getPurchaseOrderStatus(), waitToConfirmOrderStatus);
    }
    @Test
    public void TC_03_Confirm_Purchase_Order_From_Supplier() {
        goToHomePage();
        nptPurchaseOrderPageObject = nptHomePage.clickToPurchaseOrder();
        nptPurchaseOrderPageObject.clickToConfirmedSubTab();
        nptPurchaseOrderPageObject.clickToFirstPurchaseOrder();
        assertEquals(nptPurchaseOrderPageObject.getPurchaseOrderStatus(), confirmedOrderStatus);
        nptPurchaseOrderPageObject.clickToConfirmOfDelivery();
        assertEquals(nptPurchaseOrderPageObject.getPurchaseOrderStatus(), completedOrderStatus);
    }
    @Test
    public void TC_04_Deny_Purchase_Order_From_Supplier() {
        goToHomePage();
        nptPurchaseOrderPageObject = nptHomePage.clickToPurchaseOrder();
        nptPurchaseOrderPageObject.clickToSubTab(confirmedOrderStatus);
        nptPurchaseOrderPageObject.clickToFirstPurchaseOrder();
        assertEquals(nptPurchaseOrderPageObject.getPurchaseOrderStatus(), confirmedOrderStatus);
        nptPurchaseOrderPageObject.clickToDenyDelivery();
        nptPurchaseOrderPageObject.clickToConfirmDeny();
        selectDenyReasonWarning = nptPurchaseOrderPageObject.getDenyWarningMessage();
        assertEquals(selectDenyReasonWarning, "Vui lòng chọn lý do từ chối");
        nptPurchaseOrderPageObject.clickCloseWarningPopup();
        nptPurchaseOrderPageObject.clickToDenyDropdownButton();
        nptPurchaseOrderPageObject.selectDenyReason();
        denyReason = nptPurchaseOrderPageObject.getDenyReason();
        nptPurchaseOrderPageObject.clickToConfirmDeny();
        assertEquals(nptPurchaseOrderPageObject.getPurchaseOrderStatus(), denyOrderStatus);
        assertEquals(nptPurchaseOrderPageObject.getDenyReasonInDetailPage(), denyReason);
    }
    @Test
    public void TC_05_Verify_Purchase_Order_Status() {
        goToHomePage();
        nptPurchaseOrderPageObject = nptHomePage.clickToPurchaseOrder();
        //GO TO EACH SUB-TAB, ORDER FROM THE LIST MUST HAVE STATUS SAME AS THEIR SUB-TAB
        //WAIT TO CONFIRM
        nptPurchaseOrderPageObject.clickToSubTab(waitToConfirmOrderStatus);
        assertTrue(nptPurchaseOrderPageObject.isPurchaseOderHaveCorrectStatus(waitToConfirmOrderStatus));
        //CONFIRMED
        nptPurchaseOrderPageObject.clickToSubTab(confirmedOrderStatus);
        assertTrue(nptPurchaseOrderPageObject.isPurchaseOderHaveCorrectStatus(confirmedOrderStatus));
        //COMPLETED
        nptPurchaseOrderPageObject.clickToSubTab(completedOrderStatus);
        assertTrue(nptPurchaseOrderPageObject.isPurchaseOderHaveCorrectStatus(completedOrderStatus));
        //DENY RECEIVING
        nptPurchaseOrderPageObject.clickToSubTab(denyReceiveStatus);
        assertTrue(nptPurchaseOrderPageObject.isPurchaseOderHaveCorrectStatus(denyReceiveStatus));
        //DENIED BY MYKIOT
        nptPurchaseOrderPageObject.clickToSubTab(denyOrderStatus);
        assertTrue(nptPurchaseOrderPageObject.isPurchaseOderHaveCorrectStatus(denyOrderStatus));
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
