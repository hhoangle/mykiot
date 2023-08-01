package NPT.NptPageObjects;

import java.util.Random;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import NPT.NptPageObjects.NptPageUIs.NptProductPageUI;

import static NPT.NptPageObjects.NptPageUIs.NptProductPageUI.*;
import static commons.GlobalConstants.SHORT_TIMEOUT;

public class NptProductPageObject extends BasePage {
    public String getFirstVariantName(){
        return getTextByJs(driver, NptProductPageUI.FIRST_VARIANT_NAME);
    };
    private WebDriver driver;
    public NptProductPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public static long generateRandomNumber() {
        Random random = new Random();
        long randomNumber = random.nextLong() % 9000000000000L + 1000000000000L;
        return randomNumber;
    }
    public void clickToCreateProductButton() {
        waitForElementVisible(driver, NptProductPageUI.CREATE_PRODUCT_BUTTON);
        clickToElement(driver, NptProductPageUI.CREATE_PRODUCT_BUTTON);
    }
    public void insertBarCode(long randomNum) {
        waitForElementVisible(driver, NptProductPageUI.BARCODE_FIELD);
        long randomBarcode = generateRandomNumber();
        sendKeyToElement(driver, NptProductPageUI.BARCODE_FIELD, String.valueOf(randomNum));
    }
    public void insertProductName(String productName) {
        sendKeyToElement(driver, NptProductPageUI.PRODUCT_NAME_FIELD,productName);
    }
    public void insertSellingPrice(String sellingPrice) {
        sendKeyToElement(driver, NptProductPageUI.SELLING_PRICE_FIELD, sellingPrice);
    }
    public void insertImportPrice(String importPrice) {
        sendKeyToElement(driver, NptProductPageUI.IMPORT_PRICE_FIELD, importPrice);
    }
    public void insertQuantity(String productQuantity) {
        scrollToElement(driver, NptProductPageUI.QUANTITY_TITLE);
        sendKeyToElement(driver, NptProductPageUI.QUANTITY_FIELD, productQuantity);
    }
    public void clickOnBrandNameDropdown() {
        waitForElementVisible(driver, SELECT_BRAND_DROPDOWN_LIST_PARENT);
        clickToElement(driver,SELECT_BRAND_DROPDOWN_LIST_PARENT);
    }
    public void clickOnProductCategoryDropdown() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementVisible(driver, SELECT_PRODUCT_CATEGORY_LIST_PARENT);
        clickToElement(driver, SELECT_PRODUCT_CATEGORY_LIST_PARENT);
    }
    public void clickOnProductGroupDropdown() {
        waitForElementVisible(driver, SELECT_PRODUCT_GROUP_LIST_PARENT);
        clickToElement(driver,SELECT_PRODUCT_GROUP_LIST_PARENT);
    }
    public void clickStatusButton() {
        sleepInSecond(2);
        waitForElementVisible(driver, ENABLE_STATUS_BUTTON);
        clickToElement(driver, ENABLE_STATUS_BUTTON);
    }
    public void clickSellOnlineButton() {
        waitForElementVisible(driver, SELL_ONLINE_BUTTON);
        clickToElement(driver, SELL_ONLINE_BUTTON);
    }
    public void insertProductDescription(String productDescription) {
        sendKeyToElement(driver, NptProductPageUI.PRODUCT_DESCRIPTION_FIELD,productDescription);
    }
    public NptProductDetailPageObject clickSaveButton() {
        waitForElementClickable(driver, SAVE_BUTTON);
        clickToElement(driver, SAVE_BUTTON);
        return new NptProductDetailPageObject(driver);
    }
    public void inputImg(String imagePath) {
        uploadImage(driver, PRODUCT_IMAGE, imagePath);
    }

    public String getBrandNameText() {
        waitForLoadingIconInvisible(driver);
        sleepInSecond(1);
        waitForElementVisible(driver, NptProductPageUI.BRAND_NAME_TEXT);
        return getElementText(driver, NptProductPageUI.BRAND_NAME_TEXT);

    }
    public String getProductCategoryText() {
        sleepInSecond(1);
        waitForElementVisible(driver, NptProductPageUI.PRODUCT_CATEGORY_NAME_TEXT);
        return getElementText(driver, NptProductPageUI.PRODUCT_CATEGORY_NAME_TEXT);
    }
    public String getProductGroupText() {
        sleepInSecond(1);
        waitForElementVisible(driver, NptProductPageUI.PRODUCT_GROUP_NAME_TEXT);
        return getElementText(driver, NptProductPageUI.PRODUCT_GROUP_NAME_TEXT);
    }
    public void selectBrandName() {
        waitForElementVisible(driver, BRAND_NAME);
        clickToElement(driver, BRAND_NAME);
    }
    public void selectProductCategory() {
        waitForElementVisible(driver, PRODUCT_CATEGORY_NAME);
        clickToElement(driver, PRODUCT_CATEGORY_NAME);
    }
    public void selectProductGroup(){
        waitForElementVisible(driver, PRODUCT_GROUP_NAME);
        clickToElement(driver, PRODUCT_GROUP_NAME);
    }
    public String getDefaultVariantName() {
        sleepInSecond(2);
        return getTextByJs(driver, NptProductPageUI.DEFAULT_VARIANT_NAME);
    }

    public String getDefaultVariantBarcode() {
        return getTextByJs(driver, NptProductPageUI.DEFAULT_VARIANT_BARCODE);
    }

    public String getDefaultVariantImportPrice() {
        return getTextByJs(driver, NptProductPageUI.DEFAULT_VARIANT_IMPORT_PRICE);
    }
    public String getDefaultVariantSellPrice() {
        return getTextByJs(driver, NptProductPageUI.DEFAULT_VARIANT_SELL_PRICE);
    }

    public void clickAddProperties() {
        scrollToElement(driver, NptProductPageUI.MARK_POINT_TO_SCROLL);
        clickToElement(driver, NptProductPageUI.ADD_VARIANT_BUTTON);
    }

    public void insertFirstPropertyName(String firstVariantName) {
        sendKeyToElement(driver, NptProductPageUI.FIRST_PROPERTY_NAME_FIELD,firstVariantName);
    }

    public void insertFirstPropertyValue(String firstVariantValue) {
        sendKeyToElement(driver, NptProductPageUI.FIRST_PROPERTY_VALUE_FIELD,firstVariantValue);
        clickToElement(driver, NptProductPageUI.MARK_POINT_TO_CREATE_VARIANT);
    }
    public void insertFirstVariantBarcode(long randomNum) {
        sendKeyToElement(driver, NptProductPageUI.FIRST_VARIANT_BARCODE_FIELD,String.valueOf(randomNum));
    }

    public void insertFirstVariantQuantity(String productQuantity) {
        sendKeyToElement(driver, NptProductPageUI.FIRST_VARIANT_QUANTITY,productQuantity);
    }

    public NptCategoryPageObject clickToManageCategory() {
        waitForElementVisible(driver, NptProductPageUI.MANAGE_CATEGORY_BUTTON);
        clickToElement(driver, MANAGE_CATEGORY_BUTTON);
        return  new NptCategoryPageObject(driver);
    }
}