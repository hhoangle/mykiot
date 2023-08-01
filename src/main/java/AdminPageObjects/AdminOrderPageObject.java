package AdminPageObjects;
import AdminPageUIs.AdminOrderUI;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminOrderPageObject extends BasePage {
    private WebDriver driver;
    public AdminOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSaveButtonEnabled() {
        return isElementEnable(driver, AdminOrderUI.SAVE_ORDER_BUTTON);
    }

    public void selectCounterparty() {
        clickToElement(driver, AdminOrderUI.ADD_COUNTERPARTY_BUTTON);
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, AdminOrderUI.COUNTERPARTY_NAME);
        clickToElement(driver, AdminOrderUI.CONFIRM_COUNTERPARTY_BUTTON);
    }

    public void clickToAddProduct() {
        clickToElement(driver, AdminOrderUI.ADD_PRODUCT_BUTTON);
        waitForElementInvisible(driver, AdminOrderUI.LOADER_ICON);
        clickToElement(driver, AdminOrderUI.PRODUCT_DROPDOWN_BUTTON);
        clickToElement(driver, AdminOrderUI.PRODUCT_OPTION);
        clickToElement(driver, AdminOrderUI.CONFIRM_SELECT_PRODUCT_BUTTON);
    }
}
