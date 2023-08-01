package AdminPageObjects;

import AdminPageUIs.*;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminHomePageObject extends BasePage {
    private WebDriver driver;

    public AdminHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AdminProductPageObject clickToManageProduct() {
        waitForElementVisible(driver, AdminProductUI.MANAGE_PRODUCT);
        clickToElement(driver, AdminProductUI.MANAGE_PRODUCT);
        return new AdminProductPageObject(driver);
    }

    public AdminOrderPageObject clickToCreateOrder() {
        waitForElementVisible(driver, AdminOrderUI.CREATE_ORDER_BUTTON);
        clickToElement(driver, AdminOrderUI.CREATE_ORDER_BUTTON);
        return new AdminOrderPageObject(driver);
    }
}
