package Mykiot;

import AdminPageObjects.AdminHomePageObject;
import AdminPageObjects.AdminLoginPageObject;
import AdminPageObjects.AdminProductPageObject;
import AdminPageObjects.AdminProductDetailPageObject;
import AdminPageUIs.*;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static commons.GlobalConstants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class adminCreateProduct extends BaseTest {
    WebDriver driver;
    private String imagePath;
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject adminHomePage;
    private AdminProductPageObject adminProductPage;
    private AdminProductDetailPageObject adminProductDetailPageObject;
    private String account, password, brandName, productCategoryName,
            productGroupName, productName, sellingPrice, importPrice, productDescription,
            quantityProduct, variantValue, variantName, variantQuantity,strProductBarcode,
            strVariantBarcode,productStatus,sellOnlineStatus,sellOnlineStatusAfterSwitchOff,
            productStatusAfterSwitchOff;
    private long randomProductBarcode, randomVariantBarcode, min, max;
    @BeforeClass
    public void beforeClass() {
        account = "0856174003";
        password = "01";
        browserName = "chrome";
        productName = "Lemon Juice";
        sellingPrice = "15000";
        importPrice = "10000";
        quantityProduct = "1000";
        variantName = "color";
        variantValue = "black";
        variantQuantity = "1000";
        productStatus = "Đang bán";
        productStatusAfterSwitchOff = "Không đang bán";
        sellOnlineStatus = "Đang bán";
        sellOnlineStatusAfterSwitchOff = "Không đang bán";
        //CREATE RANDOM BARCODE
        Random random = new Random();
        min = 1000000000000L; // Minimum 13-digit number
        max = 9999999999999L; // Maximum 13-digit number
        randomProductBarcode = Math.abs(random.nextLong()) % (max - min + 1) + min;
        strProductBarcode = Long.toString(randomProductBarcode);
        randomVariantBarcode = Math.abs(random.nextLong()) % (max - min + 1) + min;
        strVariantBarcode = Long.toString(randomVariantBarcode);
        //CREATE PRODUCT DESCRIPTION & UPLOAD PRODUCT IMAGE
        productDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi finibus magna sed pulvinar dictum.";
        imagePath = PROJECT_PATH + "\\uploadFiles\\NewProductImage.png";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        adminHomePage = loginPage.loginWebsite(account, password);
    }
    public void goToHomePage() {
        adminHomePage.openPageUrl(driver, ADMIN_LOGIN);
    }
    @Test
    public void TC_01_Create_Product_Without_Input() {
        goToHomePage();
        adminProductPage = adminHomePage.clickToManageProduct();
        adminProductPage.waitForLoadingIconInvisible(driver);
        adminProductPage.clickToCreateProductButton();
        assertEquals(adminProductPage.getProductStatus(), productStatus);
        assertEquals(adminProductPage.getSellOnlineStatus(), sellOnlineStatus);
        adminProductPage.checkSellOnlineStatusToggleButton();
        assertEquals(adminProductPage.getSellOnlineStatusAfterSwitchOff(),sellOnlineStatusAfterSwitchOff);
        adminProductPage.clickProductStatusToggleButton();
        assertEquals(adminProductPage.getProductStatusAfterSwitchOff(),productStatusAfterSwitchOff);
        adminProductPage.clickProductStatusToggleButton();
        adminProductPage.checkSellOnlineStatusToggleButton();
        adminProductPage.clickSaveButton();
        assertTrue(adminProductPage.checkWarningMessageIsDisplayed());
        adminProductPage.cliclCloseWarningPopup();
    }
    @Test
    public void TC_02_Create_Product_Input_Only_Product_Name() {
        goToHomePage();
        adminProductPage = adminHomePage.clickToManageProduct();
        adminProductPage.waitForLoadingIconInvisible(driver);
        adminProductPage.clickToCreateProductButton();
        adminProductPage.insertProductName(productName);
        //DEFAULT PRODUCT STATUS & SELLING ONLINE SHOULD BE "ON"
        assertEquals(adminProductPage.getProductStatus(), productStatus);
        assertEquals(adminProductPage.getSellOnlineStatus(), sellOnlineStatus);
        adminProductPage.checkSellOnlineStatusToggleButton();
        assertEquals(adminProductPage.getSellOnlineStatusAfterSwitchOff(),sellOnlineStatusAfterSwitchOff);
        adminProductPage.clickProductStatusToggleButton();
        assertEquals(adminProductPage.getProductStatusAfterSwitchOff(),productStatusAfterSwitchOff);
        adminProductPage.clickProductStatusToggleButton();
        adminProductPage.checkSellOnlineStatusToggleButton();
        adminProductDetailPageObject = adminProductPage.clickSaveButton();
        assertEquals(adminProductDetailPageObject.getProductName(), productName);
    }
    @Test
    public void TC_03_Create_Product_Without_Variant() {
        goToHomePage();
        adminProductPage = adminHomePage.clickToManageProduct();
        adminProductPage.waitForLoadingIconInvisible(driver);
        adminProductPage.clickToCreateProductButton();
        //CHECK PRODUCT STATUS
        assertEquals(adminProductPage.getProductStatus(), productStatus);
        assertEquals(adminProductPage.getSellOnlineStatus(), sellOnlineStatus);
        adminProductPage.checkSellOnlineStatusToggleButton();
        assertEquals(adminProductPage.getSellOnlineStatusAfterSwitchOff(),sellOnlineStatusAfterSwitchOff);
        adminProductPage.clickProductStatusToggleButton();
        assertEquals(adminProductPage.getProductStatusAfterSwitchOff(),productStatusAfterSwitchOff);
        adminProductPage.clickProductStatusToggleButton();
        adminProductPage.checkSellOnlineStatusToggleButton();
        //INSERT PRODUCT INFORMATION
        adminProductPage.insertBarCode(randomProductBarcode);
        adminProductPage.insertProductName(productName);
        adminProductPage.insertSellingPrice(sellingPrice);
        adminProductPage.insertImportPrice(importPrice);
        adminProductPage.insertQuantity(quantityProduct);
        adminProductPage.insertProductDescription(productDescription);
        adminProductPage.inputImg(imagePath);
        //CLICK & SELECT BRAND
        adminProductPage.scrollToElement(driver, AdminProductUI.PRODUCT_IMAGE_TITLE);
        adminProductPage.clickBrandNameDropDown();
        adminProductPage.selectBrandName();
        brandName = adminProductPage.getBrandNameText();
        //CLICK & SELECT PRODUCT CATEGORY
        adminProductPage.clickProductCategoryDropDown();
        adminProductPage.selectProductCategoryName();
        productCategoryName = adminProductPage.getProductCategoryNameText();
        //CLICK & SELECT PRODUCT GROUP
        adminProductPage.clickProductGroupDropDown();
        adminProductPage.selectProductGroupDropDown();
        productGroupName = adminProductPage.getProductGroupNameText();
        adminProductDetailPageObject = adminProductPage.clickSaveButton();
        //COMPARE INPUT INFORMATION
        assertEquals(adminProductDetailPageObject.getProductName(), productName);
        assertEquals(adminProductDetailPageObject.getImportPrice(), "10.000 đ");
        assertEquals(adminProductDetailPageObject.getSellingPrice(), "15.000 đ");
        assertEquals(adminProductDetailPageObject.getBrandName(), brandName);
        assertEquals(adminProductDetailPageObject.getProductCategoryName(), productCategoryName);
        assertEquals(adminProductDetailPageObject.getProductGroupName(), productGroupName);
        assertEquals(adminProductDetailPageObject.getProductBarcode(), strProductBarcode);
        assertEquals(adminProductDetailPageObject.getProductDescription(), productDescription);
    }
    @Test
    public void TC_04_Create_Product_With_Variant() {
        goToHomePage();
        adminProductPage = adminHomePage.clickToManageProduct();
        adminProductPage.waitForLoadingIconInvisible(driver);
        adminProductPage.clickToCreateProductButton();
        //INSERT PRODUCT INFORMATION
        adminProductPage.insertBarCode(randomProductBarcode);
        adminProductPage.insertProductName(productName);
        adminProductPage.insertSellingPrice(sellingPrice);
        adminProductPage.insertImportPrice(importPrice);
        //CHECK PRODUCT STATUS
        assertEquals(adminProductPage.getProductStatus(), productStatus);
        assertEquals(adminProductPage.getSellOnlineStatus(), sellOnlineStatus);
        adminProductPage.checkSellOnlineStatusToggleButton();
        assertEquals(adminProductPage.getSellOnlineStatusAfterSwitchOff(),sellOnlineStatusAfterSwitchOff);
        adminProductPage.clickProductStatusToggleButton();
        assertEquals(adminProductPage.getProductStatusAfterSwitchOff(),productStatusAfterSwitchOff);
        adminProductPage.clickProductStatusToggleButton();
        adminProductPage.checkSellOnlineStatusToggleButton();
        //CLICK ADD PROPERTIES
        adminProductPage.clickAddProperties();
        adminProductPage.insertVariantName(variantName);
        adminProductPage.insertVariantValue(variantValue);
        adminProductPage.insertProductDescription(productDescription);
        adminProductPage.inputImg(imagePath);
        //ADD VARIANT BARCODE & QUANTITY
        adminProductPage.insertVariantBarcode(randomVariantBarcode);
        adminProductPage.insertVariantQuantity(variantQuantity);
        adminProductPage.insertQuantity(quantityProduct);
        //CLICK & SELECT BRAND
        adminProductPage.scrollToElement(driver, AdminProductUI.PRODUCT_IMAGE_TITLE);
        adminProductPage.clickBrandNameDropDown();
        adminProductPage.selectBrandName();
        brandName = adminProductPage.getBrandNameText();
        //CLICK & SELECT PRODUCT CATEGORY
        adminProductPage.clickProductCategoryDropDown();
        adminProductPage.selectProductCategoryName();
        productCategoryName = adminProductPage.getProductCategoryNameText();
        //CLICK & SELECT PRODUCT GROUP
        adminProductPage.clickProductGroupDropDown();
        adminProductPage.selectProductGroupDropDown();
        productGroupName = adminProductPage.getProductGroupNameText();
        adminProductDetailPageObject = adminProductPage.clickSaveButton();
        //COMPARE INPUT INFORMATION
        assertEquals(adminProductDetailPageObject.getProductName(), productName);
        assertEquals(adminProductDetailPageObject.getImportPrice(), "10.000 đ");
        assertEquals(adminProductDetailPageObject.getSellingPrice(), "15.000 đ");
        assertEquals(adminProductDetailPageObject.getBrandName(), brandName);
        assertEquals(adminProductDetailPageObject.getProductCategoryName(), productCategoryName);
        assertEquals(adminProductDetailPageObject.getProductGroupName(), productGroupName);
        assertEquals(adminProductDetailPageObject.getProductBarcode(), strProductBarcode);
        assertEquals(adminProductDetailPageObject.getProductDescription(), productDescription);
        assertEquals(adminProductDetailPageObject.getVariantName(), variantName);
        assertEquals(adminProductDetailPageObject.getVariantValue(), variantValue);
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}

