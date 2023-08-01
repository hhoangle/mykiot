package AdminPageObjects;

import AdminPageUIs.AdminProductUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

import static AdminPageUIs.AdminProductUI.PRODUCT_IMAGE;

public class AdminProductPageObject extends BasePage {
    private WebDriver driver;

    public AdminProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateProductButton() {
        waitForElementVisible(driver, AdminProductUI.CREATE_PRODUCT_BUTTON);
        clickToElement(driver, AdminProductUI.CREATE_PRODUCT_BUTTON);
    }

    public AdminProductDetailPageObject clickSaveButton() {
        sleepInSecond(1);
        scrollToTopPage(driver);
        waitForElementVisible(driver, AdminProductUI.SAVE_PRODUCT);
        clickToElement(driver, AdminProductUI.SAVE_PRODUCT);
        return new AdminProductDetailPageObject(driver);
    }

    public boolean checkWarningMessageIsDisplayed() {
        waitForElementVisible(driver, AdminProductUI.WARNING_MESSAGE);
        return isElementDisplay(driver, AdminProductUI.WARNING_MESSAGE);
    }

    public void cliclCloseWarningPopup() {
        waitForElementVisible(driver, AdminProductUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, AdminProductUI.CLOSE_POPUP_BUTTON);
    }

    public void insertProductName(String productName) {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_NAME_FIELD);
        sendKeyToElement(driver, AdminProductUI.PRODUCT_NAME_FIELD, productName);
    }

    public void insertBarCode(long randomNum) {
        waitForElementVisible(driver, AdminProductUI.BARCODE_FIELD);
        sendKeyToElement(driver, AdminProductUI.BARCODE_FIELD, String.valueOf(randomNum));
    }

    public void insertSellingPrice(String sellingPrice) {
        sendKeyToElement(driver, AdminProductUI.SELLING_PRICE_FIELD, sellingPrice);
    }

    public void insertImportPrice(String importPrice) {
        sendKeyToElement(driver, AdminProductUI.IMPORT_PRICE_FIELD, importPrice);
    }

    public void insertQuantity(String quantityProduct) {
        scrollToElement(driver, AdminProductUI.QUANTITY_FIELD);
        sendKeyToElement(driver, AdminProductUI.QUANTITY_FIELD, quantityProduct);
    }

    public void inputImg(String imagePath) {
        uploadImage(driver, PRODUCT_IMAGE, imagePath);
    }

    public void insertProductDescription(String productDesciption) {
        sendKeyToElement(driver, AdminProductUI.PRODUCT_DESCRIPTION_FIELD, productDesciption);

    }

    public void clickBrandNameDropDown() {
        sleepInSecond(1);
        clickToElement(driver, AdminProductUI.BRAND_NAME_DROPDOWN);
    }

    public void selectBrandName() {
        sleepInSecond(1);
        clickToElement(driver, AdminProductUI.BRAND_NAME);
    }

    public void clickAddInfo() {
        waitForElementVisible(driver, AdminProductUI.ADD_INFO_TEXT);
        clickToElement(driver, AdminProductUI.ADD_INFO_TEXT);
    }

    public String getBrandNameText() {
        waitForElementVisible(driver, AdminProductUI.BRAND_NAME_TEXT);
        return getElementText(driver, AdminProductUI.BRAND_NAME_TEXT);
    }

    public void clickProductCategoryDropDown() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_CATEGORY_DROPDOWN);
        clickToElement(driver, AdminProductUI.PRODUCT_CATEGORY_DROPDOWN);
    }

    public void selectProductCategoryName() {
        sleepInSecond(1);
        clickToElement(driver, AdminProductUI.PRODUCT_CATEGORY_NAME);
    }

    public String getProductCategoryNameText() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_CATEGORY_NAME_TEXT);
        return getElementText(driver, AdminProductUI.PRODUCT_CATEGORY_NAME_TEXT);
    }

    public void clickProductGroupDropDown() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_GROUP_DROPDOWN);
        clickToElement(driver, AdminProductUI.PRODUCT_GROUP_DROPDOWN);
    }

    public void selectProductGroupDropDown() {
        sleepInSecond(1);
        clickToElement(driver, AdminProductUI.PRODUCT_GROUP_NAME);

    }

    public String getProductGroupNameText() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_GROUP_NAME_TEXT);
        return getElementText(driver, AdminProductUI.PRODUCT_GROUP_NAME_TEXT);
    }

    public String getDefaultVariantName() {
        waitForElementVisible(driver, AdminProductUI.VARIANT_NAME);
        return getElementText(driver, AdminProductUI.VARIANT_NAME);
    }

    public void clickAddProperties() {
        waitForElementVisible(driver, AdminProductUI.ADD_VARIANT_BUTTON);
        clickToElement(driver, AdminProductUI.ADD_VARIANT_BUTTON);
    }

    public void insertVariantName(String variantName) {
        sendKeyToElement(driver, AdminProductUI.VARIANT_NAME_FIELD,variantName);
    }
    public void insertVariantValue(String variantValue){
        sendKeyToElement(driver, AdminProductUI.VARIANT_VALUE_FIELD,variantValue);
    }

    public void insertVariantBarcode(long randomNum) {
        sendKeyToElement(driver, AdminProductUI.VARIANT_BARCODE_FIELD,String.valueOf(randomNum));
    }

    public void insertVariantQuantity(String variantQuantity) {
        waitForElementVisible(driver, AdminProductUI.VARIANT_QUANTITY_FIELD);
        sendKeyToElement(driver, AdminProductUI.VARIANT_QUANTITY_FIELD, variantQuantity);
    }

    public void clickProductStatusToggleButton() {
        clickToElement(driver, AdminProductUI.PRODUCT_STATUS_TOGGLE_BUTTON);
    }
    public String getProductStatus() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_STATUS);
        return getElementText(driver, AdminProductUI.PRODUCT_STATUS);
    }

    public String getSellOnlineStatus() {
        waitForElementVisible(driver, AdminProductUI.SELL_ONLINE_STATUS);
        return getElementText(driver, AdminProductUI.SELL_ONLINE_STATUS);
    }

    public String getSellOnlineStatusAfterSwitchOff() {
        waitForElementVisible(driver, AdminProductUI.SELL_ONLINE_STATUS_AFTER_SWITCH_OFF);
        return getElementText(driver, AdminProductUI.SELL_ONLINE_STATUS_AFTER_SWITCH_OFF);
    }

    public String getProductStatusAfterSwitchOff() {
        waitForElementVisible(driver, AdminProductUI.PRODUCT_STATUS_AFTER_SWITCH_OFF);
        return getElementText(driver, AdminProductUI.PRODUCT_STATUS_AFTER_SWITCH_OFF);
    }

    public void checkSellOnlineStatusToggleButton() {
        clickToElement(driver, AdminProductUI.SELL_ONLINE_STATUS_TOGGLE_BUTTON);
    }
}
