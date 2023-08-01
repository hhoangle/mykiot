package NPT.NptPageObjects;

import NPT.NptPageObjects.NptPageUIs.NptHomePageUI;
import NPT.NptPageObjects.NptPageUIs.NptProductPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class NptHomePageObject extends BasePage {
    private WebDriver driver;
    public NptHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public NptProductPageObject clickToManageProduct() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementVisible(driver, NptProductPageUI.MANAGE_PRODUCT);
        clickToElement(driver, NptProductPageUI.MANAGE_PRODUCT);
        return new NptProductPageObject(driver);
    }

    public void clickToCreateProductButton() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, NptProductPageUI.CREATE_PRODUCT_BUTTON);
        clickToElement(driver,NptProductPageUI.CREATE_PRODUCT_BUTTON);

    }

    public NptSalesOrderPageObject clickToSaleOrder() {
        clickToElement(driver, NptHomePageUI.SALES_ORDER_BUTTON);
        return new NptSalesOrderPageObject(driver);
    }

    public NptPurchaseOrderPageObject clickToPurchaseOrder() {
        clickToElement(driver, NptHomePageUI.PURCHASE_ORDER_BUTTON);
        return new NptPurchaseOrderPageObject(driver);
    }

    public NptCreateEmployeePageObject clickToManageEmployee() {
        clickToElement(driver, NptHomePageUI.MANAGE_EMPLOYEE_BUTTON);
        return new NptCreateEmployeePageObject(driver);
    }

    public String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("09");
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10);
            phoneNumber.append(digit);
        }
        return phoneNumber.toString();
    }

    public NptCreateGroceryStorePageObject clickToManageGroceryStore() {
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, NptHomePageUI.MANAGE_GROCERY_STORE_BUTTON);
        return new NptCreateGroceryStorePageObject(driver);
    }
}
