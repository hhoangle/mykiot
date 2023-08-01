package NPT.NptPageObjects;
import NPT.NptPageObjects.NptPageUIs.NptCategoryPageUI;
import NPT.NptPageObjects.NptPageUIs.NptProductCategoryDetailPageUI;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.BasePage;

public class NptProductCategoryDetailPageObject extends BasePage {
    private WebDriver driver;
    public NptProductCategoryDetailPageObject(WebDriver driver){
        this.driver = driver;
    }public String getProductCategoryName() {
        waitForLoadingIconInvisible(driver);
        return getElementText(driver, NptProductCategoryDetailPageUI.PRODUCT_CATEGORY_NAME_IN_DETAIL_PAGE);
    }

    public String getClassification() {
        return getElementText(driver, NptProductCategoryDetailPageUI.CLASSIFICATION_IN_DETAIL_PAGE);
    }

    public String getProductCategoryDescription() {
        return getElementText(driver, NptProductCategoryDetailPageUI.PRODUCT_CATEGORY_DESCRIPTION_IN_DETAIL_PAGE);
    }

    public void clickToAddProductGroup() {
        sleepInSecond(2);
        clickToElement(driver, NptProductCategoryDetailPageUI.ADD_PRODUCT_GROUP_BUTTON);
    }

    public void insertProductGroupName(String productGroupName) {
        sendKeyToElement(driver, NptProductCategoryDetailPageUI.PRODUCT_GROUP_NAME_FIELD_IN_DETAIL_PAGE,productGroupName);
    }

    public void clickToConfirmCreateProductGroup() {
        clickToElement(driver, NptProductCategoryDetailPageUI.CONFRIM_CREATE_PRODUCT_GROUP_IN_DETAIL_PAGE);
    }

    public String getProductGroupInDetailPage() {
        return getElementText(driver, NptProductCategoryDetailPageUI.PRODUCT_GROUP_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public NptProductCategoryEditPageObject clickToEditProductCategory() {
        clickToElement(driver, NptProductCategoryDetailPageUI.EDIT_PRODUCT_CATEGORY_BUTTON);
        return new NptProductCategoryEditPageObject(driver);
    }
}
