package NPT.NptPageObjects;
import NPT.NptPageObjects.NptPageUIs.NptCategoryPageUI;
import NPT.NptPageObjects.NptPageUIs.NptProductCategoryDetailPageUI;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class NptProductCategoryPageObject extends BasePage {
    private WebDriver driver;
    public NptProductCategoryPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCategory() {
        clickToElement(driver, NptCategoryPageUI.CATEGORY_BUTTON);
    }

    public void clickCreateProductCategory() {
        clickToElement(driver, NptCategoryPageUI.CREATE_CATEGORY_BUTTON);
    }

    public void insertProductCategoryName(String productCategoryName) {
        sendKeyToElement(driver, NptCategoryPageUI.PRODUCT_CATEGORY_NAME_FIELD, productCategoryName);
    }

    public NptProductCategoryDetailPageObject clickSaveButton() {
        clickToElement(driver, NptCategoryPageUI.SAVE_PRODUCT_CATEGORY_BUTTON);
        return new NptProductCategoryDetailPageObject(driver);
    }

    public String getWarningMessage() {
        waitForElementVisible(driver, NptCategoryPageUI.WARNING_MESSAGE);
        return getElementText(driver, NptCategoryPageUI.WARNING_MESSAGE);
    }

    public void clickCloseWarningPopup() {
        clickToElement(driver, NptCategoryPageUI.CLOSE_WARNING_POPUP_BUTTON);
    }
    public void insertProductCategoryDescription(String productCategoryDescription) {
        sendKeyToElement(driver, NptCategoryPageUI.PRODUCT_CATEGORY_DESCRIPTION_FIELD,productCategoryDescription);
    }
}
