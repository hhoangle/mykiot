package NPT.NptPageObjects;

import NPT.NptPageObjects.NptPageUIs.NptProductPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class NptProductDetailPageObject extends BasePage {
    private WebDriver driver;
    public NptProductDetailPageObject(WebDriver driver) {
        this.driver = driver;

    }
    public String getProductName() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, NptProductPageUI.PRODUCT_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.PRODUCT_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getBarcode() {
        waitForElementVisible(driver, NptProductPageUI.BAR_CODE_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.BAR_CODE_TEXT_IN_DETAIL_PAGE);
    }
    public String getSellingPrice(){
        waitForElementVisible(driver, NptProductPageUI.SELLING_PRICE_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.SELLING_PRICE_TEXT_IN_DETAIL_PAGE);
    }
    public String getImportPrice(){
        waitForElementVisible(driver, NptProductPageUI.IMPORT_PRICE_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.IMPORT_PRICE_TEXT_IN_DETAIL_PAGE);
    }
    public String getBrandName() {
        sleepInSecond(2);
        waitForElementVisible(driver, NptProductPageUI.BRAND_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.BRAND_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductCategoryName() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, NptProductPageUI.PRODUCT_CATEGORY_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.PRODUCT_CATEGORY_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductGroupName() {
        waitForElementVisible(driver, NptProductPageUI.PRODUCT_GROUP_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.PRODUCT_GROUP_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductBarcode() {
        waitForElementVisible(driver, NptProductPageUI.PRODUCT_BAR_CODE_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.PRODUCT_BAR_CODE_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductDescription() {
        waitForElementVisible(driver, NptProductPageUI.PRODUCT_DESCRIPTION_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.PRODUCT_DESCRIPTION_TEXT_IN_DETAIL_PAGE);
    }

    public String getProductStatus() {
        waitForElementVisible(driver, NptProductPageUI.PRODUCT_STATUS_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.PRODUCT_STATUS_IN_DETAIL_PAGE);
    }
    public String getSellOnlineStatus(){
        waitForElementVisible(driver, NptProductPageUI.SELL_ONLINE_STATUS_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.SELL_ONLINE_STATUS_IN_DETAIL_PAGE);
    }

   /* public String getVariantName() {
        waitForElementVisible(driver, NptProductPageUI.VARIANT_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.VARIANT_NAME_TEXT_IN_DETAIL_PAGE);
    }

    public String getVariantValue() {
        waitForElementVisible(driver, NptProductPageUI.VARIANT_VALUE_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, NptProductPageUI.VARIANT_VALUE_TEXT_IN_DETAIL_PAGE);
    } */
}
