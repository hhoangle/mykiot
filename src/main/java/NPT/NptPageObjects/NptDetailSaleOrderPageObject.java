package NPT.NptPageObjects;

import NPT.NptPageObjects.NptPageUIs.NptSalesOrderUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class NptDetailSaleOrderPageObject extends BasePage{
    private WebDriver driver;
    public NptDetailSaleOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getSaleOrderStatus() {
        return getElementText(driver, NptSalesOrderUI.SALE_ORDER_STATUS);
    }

    public void clickToViewInvoice() {
        clickToElement(driver, NptSalesOrderUI.VIEW_INVOICE_BUTTON);
    }

    public String getOrderCode() {
        return getElementText(driver, NptSalesOrderUI.ORDER_CODE);
    }

    public String getOrderCodeInInvoice() {
        sleepInSecond(1);
        return getElementText(driver, NptSalesOrderUI.ORDER_CODE_IN_INVOICE);
    }

    public void clickToConfirmOrder() {
        clickToElement(driver, NptSalesOrderUI.CONFIRM_WAITING_ORDER_BUTTON);
        waitForLoadingIconInvisible(driver);
    }

    public void clickToDeclineOrderButton() {
        clickToElement(driver, NptSalesOrderUI.DECLINE_WAITING_ORDER_BUTTON);
    }

    public void clickToDeclineDropdownButton() {
        clickToElement(driver, NptSalesOrderUI.DECLINE_REASON_DROPDOWN);
    }

    public String getDeclineReason() {
        return getElementText(driver, NptSalesOrderUI.DECLINE_REASON_OPTION);
    }

    public void selectDeclineReason() {
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, NptSalesOrderUI.DECLINE_REASON_OPTION);
    }

    public String getDeclineReasonInDetailPage() {
        return getElementText(driver, NptSalesOrderUI.DECLINE_REASON_IN_DETAIL_PAGE);
    }

    public void clickConfirmDecline() {
        clickToElement(driver, NptSalesOrderUI.CONFIRM_DECLINE_BUTTON);
        waitForLoadingIconInvisible(driver);
    }

    public String getDeclineWarningMessage() {
        return getElementText(driver, NptSalesOrderUI.DECLINE_WARNING_POPUP);
    }

    public void clickCloseWarningPopup() {
        clickToElement(driver, NptSalesOrderUI.CLOSE_DECLINE_WARNING_POPUP_BUTTON);
    }
}
