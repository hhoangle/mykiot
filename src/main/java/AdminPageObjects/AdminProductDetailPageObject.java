package AdminPageObjects;
import AdminPageUIs.AdminProductUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
public class AdminProductDetailPageObject extends BasePage {
    private WebDriver driver;
    public AdminProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductName() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, AdminProductUI.PRODUCT_NAME_TEXT);
        return getElementText(driver, AdminProductUI.PRODUCT_NAME_TEXT);
    }
    public String getSellingPrice(){
        waitForElementVisible(driver, AdminProductUI.SELLING_PRICE_TEXT);
        return getElementText(driver, AdminProductUI.SELLING_PRICE_TEXT);
    }
    public String getImportPrice(){
        waitForElementVisible(driver, AdminProductUI.IMPORT_PRICE_TEXT);
        return getElementText(driver, AdminProductUI.IMPORT_PRICE_TEXT);
    }

    public String getBrandName() {
        waitForElementVisible(driver, AdminProductUI.BRAND_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, AdminProductUI.BRAND_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductCategoryName() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_CATEGORY_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, AdminProductUI.PRODUCT_CATEGORY_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductGroupName() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_GROUP_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, AdminProductUI.PRODUCT_GROUP_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductBarcode() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_BAR_CODE_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, AdminProductUI.PRODUCT_BAR_CODE_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductDescription() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_DESCRIPTION_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, AdminProductUI.PRODUCT_DESCRIPTION_TEXT_IN_DETAIL_PAGE);
    }

    public String getVariantName() {
        waitForElementVisible(driver, AdminProductUI.VARIANT_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, AdminProductUI.VARIANT_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getVariantValue() {
        waitForElementVisible(driver, AdminProductUI.VARIANT_VALUE_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, AdminProductUI.VARIANT_VALUE_TEXT_IN_DETAIL_PAGE);
    }
}
