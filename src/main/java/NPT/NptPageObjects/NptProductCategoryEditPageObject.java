package NPT.NptPageObjects;
import NPT.NptPageObjects.NptPageUIs.NptCategoryPageUI;
import NPT.NptPageObjects.NptPageUIs.NptProductCategoryDetailPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
public class NptProductCategoryEditPageObject extends BasePage {
    private WebDriver driver;

    public NptProductCategoryEditPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void insertNewProductCategoryName(String newProductCategoryName) {
        sleepInSecond(2);
        clearValueInElementByDeleteKey(driver, NptProductCategoryDetailPageUI.PRODUCT_CATOGORY_NAME_IN_EDIT_PAGE);
        sendKeyToElement(driver,NptProductCategoryDetailPageUI.PRODUCT_CATOGORY_NAME_IN_EDIT_PAGE,newProductCategoryName);
    }

    public void insertNewProductCategoryDescription(String newProductCategoryDescription) {
        clearValueInElementByDeleteKey(driver, NptProductCategoryDetailPageUI.PRODUCT_CATEGORY_DESCRIPTION_IN_EDIT_PAGE);
        sendKeyToElement(driver,NptProductCategoryDetailPageUI.PRODUCT_CATEGORY_DESCRIPTION_IN_EDIT_PAGE,newProductCategoryDescription);
    }

    public NptProductCategoryDetailPageObject clickSaveButton() {
        clickToElement(driver, NptProductCategoryDetailPageUI.SAVE_BUTTON_IN_EDIT_PAGE);
        return new NptProductCategoryDetailPageObject(driver);
    }
}
