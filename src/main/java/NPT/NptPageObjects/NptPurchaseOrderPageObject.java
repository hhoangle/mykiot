package NPT.NptPageObjects;

import NPT.NptPageObjects.NptPageUIs.*;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class NptPurchaseOrderPageObject extends BasePage {
    private WebDriver driver;

    public NptPurchaseOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public NptCreatePurchaseOrderPageObject clickToCreatePurchaseOrderButton() {
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, NptPurchaseOrderUI.CREATE_PURCHASE_ORDER_BUTTON);
        return new NptCreatePurchaseOrderPageObject(driver);
    }

    public void clickToConfirmedSubTab() {
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, NptPurchaseOrderUI.CONFIRMED_SUB_TAB);
    }

    public void clickToFirstPurchaseOrder() {
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, NptPurchaseOrderUI.FIRST_ORDER_IN_CONFIRMER_SUB_TAB);
    }

    public String getPurchaseOrderStatus() {
        return getElementText(driver, NptPurchaseOrderUI.PURCHASE_ORDER_STATUS);
    }

    public void clickToConfirmOfDelivery() {
        clickToElement(driver, NptPurchaseOrderUI.CONFIRM_OF_DELIVERY_BUTTON);
        waitForLoadingIconInvisible(driver);
    }

    public void clickToDenyDelivery() {
        clickToElement(driver, NptPurchaseOrderUI.DENY_DELIVERY_BUTTON);
    }

    public void clickToConfirmDeny() {
        clickToElement(driver, NptPurchaseOrderUI.CONFIRM_DENY_BUTTON);
        waitForLoadingIconInvisible(driver);
    }

    public String getDenyWarningMessage() {
        return getElementText(driver, NptPurchaseOrderUI.DECLINE_WARNING_POPUP);
    }

    public void clickCloseWarningPopup() {
        clickToElement(driver, NptSalesOrderUI.CLOSE_DECLINE_WARNING_POPUP_BUTTON);
    }

    public void clickToDenyDropdownButton() {
        clickToElement(driver, NptSalesOrderUI.DECLINE_REASON_DROPDOWN);
    }

    public void selectDenyReason() {
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, NptSalesOrderUI.DECLINE_REASON_OPTION);
    }

    public String getDenyReason() {
        return getElementText(driver, NptSalesOrderUI.DECLINE_REASON_OPTION);
    }

    public String getDenyReasonInDetailPage() {
        return getElementText(driver, NptSalesOrderUI.DECLINE_REASON_IN_DETAIL_PAGE);
    }

    public void clickToSubTab(String orderStatus) {
        waitForLoadingIconInvisible(driver);
        waitForAllElementVisible(driver, NptPurchaseOrderUI.DYNAMIC_SUBTAB, orderStatus);
        clickToElement(driver, NptPurchaseOrderUI.DYNAMIC_SUBTAB, orderStatus);
    }

    public boolean isPurchaseOderHaveCorrectStatus(String statusToCheck) {
        waitForLoadingIconInvisible(driver);
        return verifyAllItemsHaveStatus(driver, NptPurchaseOrderUI.STATUS_TAG, statusToCheck);
    }
}
