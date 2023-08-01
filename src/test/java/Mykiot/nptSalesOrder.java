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

public class nptSalesOrder extends BaseTest {
    WebDriver driver;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptSalesOrderPageObject nptSaleOrderPageObject;
    private NptCreateSaleOrderPageObject nptCreateSaleOrderPageObject;
    private NptDetailSaleOrderPageObject nptDetailSaleOrderPageObject;
    private String warningMessage, confirmedOrderStatus, waitToConfirmOrderStatus,completedOrderStatus,

            declinedOrderStatus, declineReason,selectDeclineReasonWarning, storeDeclineOrderStatus,orderFromNpt,
            orderFromAdmin,orderTypeNpt,orderTypeAdmin;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
        warningMessage = "Vui lòng chọn CHTH";
        confirmedOrderStatus = "Đã xác nhận";
        waitToConfirmOrderStatus = "Chờ phản hồi";
        declinedOrderStatus = "NPT từ chối";
        completedOrderStatus = "Hoàn thành";
        storeDeclineOrderStatus = "CHTH từ chối";
        orderFromNpt = "Đơn của NPT";
        orderFromAdmin = "Đơn từ Mykiot";
        orderTypeNpt = "Trực tiếp";
        orderTypeAdmin = "Điều phối";
    }
    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Create_Sale_Order_Without_Select_Store() {
        goToHomePage();
        nptSaleOrderPageObject = nptHomePage.clickToSaleOrder();
        nptCreateSaleOrderPageObject = nptSaleOrderPageObject.clickToCreateSalesOrder();
        //SELECT 3 FIRST PRODUCTS FROM THE LIST
        nptCreateSaleOrderPageObject.selectThreeFirstProduct();
        nptCreateSaleOrderPageObject.clickToContinueButton();
        //IF STORE IS NOT SELECTED, WARNING MESSAGE SHOULD BE DISPLAYED
        nptCreateSaleOrderPageObject.clickToConfirmButton();
        assertEquals(nptCreateSaleOrderPageObject.getWarningMessage(), warningMessage);
    }
    @Test
    public void TC_02_Create_Sale_Order() {
        goToHomePage();
        nptSaleOrderPageObject = nptHomePage.clickToSaleOrder();
        nptCreateSaleOrderPageObject = nptSaleOrderPageObject.clickToCreateSalesOrder();
        nptCreateSaleOrderPageObject.selectThreeFirstProduct();
        nptCreateSaleOrderPageObject.clickToContinueButton();
        nptCreateSaleOrderPageObject.selectStore();
        nptDetailSaleOrderPageObject = nptCreateSaleOrderPageObject.clickToConfirmButton();
        //AFTER SAVED ORDER, VERIFY ORDER STATUS & ORDER CODE
        assertEquals(nptDetailSaleOrderPageObject.getSaleOrderStatus(), confirmedOrderStatus);
        String orderCode = nptDetailSaleOrderPageObject.getOrderCode();
        nptDetailSaleOrderPageObject.clickToViewInvoice();
        //ORDER CODE IN INVOICE MUST BE SAME AS FROM ORDER DETAIL
        String orderCodeInInvoice = nptDetailSaleOrderPageObject.getOrderCodeInInvoice();
        assertTrue(orderCodeInInvoice.contains(orderCode));
    }
    @Test
    public void TC_03_Confirm_Order() {
        goToHomePage();
        nptSaleOrderPageObject = nptHomePage.clickToSaleOrder();
        nptSaleOrderPageObject.clickToWaitToConfirmTab();
        nptDetailSaleOrderPageObject = nptSaleOrderPageObject.clickToFirstOrder();
        assertEquals(nptDetailSaleOrderPageObject.getSaleOrderStatus(), waitToConfirmOrderStatus);
        nptDetailSaleOrderPageObject.clickToConfirmOrder();
        //AFTER CONFIRM ORDER, ORDER'S STATUS SHOULD BE CHANGED TO "CONFIRMED"
        assertEquals(nptDetailSaleOrderPageObject.getSaleOrderStatus(), confirmedOrderStatus);
    }
    @Test
    public void TC_04_Decline_Order() {
        goToHomePage();
        nptSaleOrderPageObject = nptHomePage.clickToSaleOrder();
        nptSaleOrderPageObject.clickToWaitToConfirmTab();
        nptDetailSaleOrderPageObject = nptSaleOrderPageObject.clickToFirstOrder();
        assertEquals(nptDetailSaleOrderPageObject.getSaleOrderStatus(), waitToConfirmOrderStatus);
        nptDetailSaleOrderPageObject.clickToDeclineOrderButton();
        nptDetailSaleOrderPageObject.clickConfirmDecline();
        //IF NOT SELECT DECLINE RESON, WARNING POPUP SHOULD BE DISPLAYED
        selectDeclineReasonWarning = nptDetailSaleOrderPageObject.getDeclineWarningMessage();
        assertEquals(selectDeclineReasonWarning,"Vui lòng chọn lý do từ chối");
        nptDetailSaleOrderPageObject.clickCloseWarningPopup();
        /*AFTER DECLINED, ORDER STATUS SHOULD BE CHANGED, ALSO DECLINED REASON SHOULD BE DISPLAYED IN
        ORDER DETAIL */
        nptDetailSaleOrderPageObject.clickToDeclineDropdownButton();
        nptDetailSaleOrderPageObject.selectDeclineReason();
        declineReason = nptDetailSaleOrderPageObject.getDeclineReason();
        nptDetailSaleOrderPageObject.clickConfirmDecline();
        assertEquals(nptDetailSaleOrderPageObject.getSaleOrderStatus(), declinedOrderStatus);
        assertEquals(nptDetailSaleOrderPageObject.getDeclineReasonInDetailPage(), declineReason);
    }
    @Test
    public void TC_05_Verify_Sale_Order_Status(){
        goToHomePage();
        nptSaleOrderPageObject = nptHomePage.clickToSaleOrder();
        //GO TO EACH SUB-TAB, ORDER FROM THE LIST MUST HAVE STATUS SAME AS THEIR SUB-TAB
        //WAIT TO CONFIRM
        nptSaleOrderPageObject.clickToSubTab(waitToConfirmOrderStatus);
        assertTrue(nptSaleOrderPageObject.isPurchaseOderHaveCorrectStatus(waitToConfirmOrderStatus));
        //CONFIRMED
        nptSaleOrderPageObject.clickToSubTab(confirmedOrderStatus);
        assertTrue(nptSaleOrderPageObject.isPurchaseOderHaveCorrectStatus(confirmedOrderStatus));
        //COMPLETED
        nptSaleOrderPageObject.clickToSubTab(completedOrderStatus);
        assertTrue(nptSaleOrderPageObject.isPurchaseOderHaveCorrectStatus(completedOrderStatus));
        //DECLINED
        nptSaleOrderPageObject.clickToSubTab(declinedOrderStatus);
        assertTrue(nptSaleOrderPageObject.isPurchaseOderHaveCorrectStatus(declinedOrderStatus));
        //STORE DECLINED
//        nptSaleOrderPageObject.clickToSubTab(storeDeclineOrderStatus);
//        assertTrue(nptSaleOrderPageObject.isPurchaseOderHaveCorrectStatus(storeDeclineOrderStatus));
    }
    @Test
    public void TC_06_Verify_Order_From(){
        goToHomePage();
        nptSaleOrderPageObject = nptHomePage.clickToSaleOrder();
        //GO TO EACH SUB-TAB, ORDER FROM THE LIST MUST HAVE SAME TYPE AS THEIR SUB-TAB
        //VERIFY ORDER FROM NPT MUST HAVE ORDER TYPE IS: "DIRECT"
        nptSaleOrderPageObject.clickToOrderTypeTab(orderFromNpt);
        assertTrue(nptSaleOrderPageObject.isPurchaseOderHaveCorrectType(orderTypeNpt));
        //VERIFY ORDER FROM NPT MUST HAVE ORDER TYPE IS: "RE-DIRECT"
        nptSaleOrderPageObject.clickToOrderTypeTab(orderFromAdmin);
        assertTrue(nptSaleOrderPageObject.isPurchaseOderHaveCorrectType(orderTypeAdmin));
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}