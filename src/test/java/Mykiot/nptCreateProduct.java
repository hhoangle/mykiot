package Mykiot;

import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import NPT.NptPageObjects.NptProductPageObject;
import NPT.NptPageObjects.NptProductDetailPageObject;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Random;
import static commons.GlobalConstants.*;

public class nptCreateProduct extends BaseTest {
    WebDriver driver;
    private String imagePath, productName, barCode, sellingPrice, importPrice, productQuantity,
            brandName, productCategoryName, productGroupName, productDescription, defaultVariantName,
            variantValue, variantQuantity, defaultVariantBarcode, defaultVariantSellPrice,defaultVariantImportPrice,defaultVariantQuantity,
            productStatus, productStatusAfterSwitchOff, sellOnlineStatusAfterSwitchOff, sellOnlineStatus,
            quantityProduct, ramdomProductBarCode, strProductBarcode, strVariantBarcode,
            firstPropertyName, firstPropertyValue;
    private long min, max, randomProductBarcode, randomVariantBarcode;

    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptProductPageObject nptProductPage;
    private NptProductDetailPageObject nptProductDetailPageObject;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
        imagePath = PROJECT_PATH + "\\uploadFiles\\NewProductImage.png";
        productName = "Lemon Juice";
        sellingPrice = "15000";
        importPrice = "10000";
        productQuantity = "1000";
        defaultVariantName = "color";
        variantValue = "black";
        variantQuantity = "1000";
        productStatus = "Đang bán";
        productStatusAfterSwitchOff = "Không đang bán";
        sellOnlineStatus = "Đang bán";
        sellOnlineStatusAfterSwitchOff = "Không đang bán";
        firstPropertyName = "color";
        firstPropertyValue = "Pink";
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

    }

    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }

    @Test
    public void TC_01_Create_Product_Without_Input() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptProductPage.clickToCreateProductButton();
    }

    @Test
    public void TC_02_Create_Product_Without_Variant() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptProductPage.clickToCreateProductButton();
        nptProductPage.inputImg(imagePath);
        nptProductPage.insertBarCode(randomProductBarcode);
        nptProductPage.insertProductName(productName);
        nptProductPage.insertSellingPrice(sellingPrice);
        nptProductPage.insertImportPrice(importPrice);
        nptProductPage.insertQuantity(productQuantity);
        //SELECT BRAND
        nptProductPage.clickOnBrandNameDropdown();
        brandName = nptProductPage.getBrandNameText();
        nptProductPage.selectBrandName();
        //SELECT PRODUCT CATEGORY
        nptProductPage.clickOnProductCategoryDropdown();
        nptProductPage.getProductCategoryText();
        productCategoryName = nptProductPage.getProductCategoryText();
        nptProductPage.selectProductCategory();
        //SELECT PRODUCT GROUP
        nptProductPage.clickOnProductGroupDropdown();
        nptProductPage.getProductGroupText();
        productGroupName = nptProductPage.getProductGroupText();
        nptProductPage.selectProductGroup();
        //SELECT PRODUCT STATUS & SELL ONLINE STATUS
        nptProductPage.clickStatusButton();
        nptProductPage.clickSellOnlineButton();
        nptProductPage.insertProductDescription(productDescription);
        nptProductDetailPageObject = nptProductPage.clickSaveButton();
        assertEquals(nptProductDetailPageObject.getProductName(),productName);
        assertEquals(nptProductDetailPageObject.getBarcode(),strProductBarcode);
        assertEquals(nptProductDetailPageObject.getImportPrice(),"10.000đ");
        assertEquals(nptProductDetailPageObject.getSellingPrice(),"15.000đ");
        assertEquals(nptProductDetailPageObject.getBrandName(),brandName);
        assertEquals(nptProductDetailPageObject.getProductCategoryName(),productCategoryName);
        assertEquals(nptProductDetailPageObject.getProductGroupName(), productGroupName);
        assertEquals(nptProductDetailPageObject.getProductStatus(),"Đang bán");
        assertEquals(nptProductDetailPageObject.getSellOnlineStatus(),"Đang bán");
    }
    @Test
    public void TC_03_Create_Product_With_Variant(){
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptProductPage.clickToCreateProductButton();
        nptProductPage.inputImg(imagePath);
        nptProductPage.insertBarCode(randomProductBarcode);
        nptProductPage.insertProductName(productName);
        nptProductPage.insertSellingPrice(sellingPrice);
        nptProductPage.insertImportPrice(importPrice);
        nptProductPage.insertQuantity(productQuantity);
        //GET DEFAULT VARIANT INFOR THEN COMPARE TO PRODUCT INFOR
        defaultVariantName = nptProductPage.getDefaultVariantName();
        defaultVariantBarcode = nptProductPage.getDefaultVariantBarcode();
        defaultVariantImportPrice = nptProductPage.getDefaultVariantImportPrice();
        defaultVariantSellPrice = nptProductPage.getDefaultVariantSellPrice();
        assertEquals(defaultVariantName,productName);
        assertEquals(defaultVariantBarcode,strProductBarcode);
        assertEquals(defaultVariantImportPrice,"10.000");
        assertEquals(defaultVariantSellPrice,"15.000");
        //ADD PROPERTIES
        nptProductPage.clickAddProperties();
        nptProductPage.insertFirstPropertyName(firstPropertyName);
        nptProductPage.insertFirstPropertyValue(firstPropertyValue);
        assertEquals(nptProductPage.getFirstVariantName(),productName +","+" "+ firstPropertyValue);
        //ADD VARIANT INFO
        nptProductPage.insertFirstVariantBarcode(randomVariantBarcode);
        nptProductPage.insertFirstVariantQuantity(productQuantity);
        nptProductPage.scrollToBottomPage(driver);
        //SELECT BRAND
        nptProductPage.clickOnBrandNameDropdown();
        brandName = nptProductPage.getBrandNameText();
        nptProductPage.selectBrandName();
        //SELECT PRODUCT CATEGORY
        nptProductPage.clickOnProductCategoryDropdown();
        nptProductPage.getProductCategoryText();
        productCategoryName = nptProductPage.getProductCategoryText();
        nptProductPage.selectProductCategory();
        //SELECT PRODUCT GROUP
        nptProductPage.clickOnProductGroupDropdown();
        nptProductPage.getProductGroupText();
        productGroupName = nptProductPage.getProductGroupText();
        nptProductPage.selectProductGroup();
        //SELECT PRODUCT STATUS & SELL ONLINE STATUS
        nptProductPage.clickStatusButton();
        nptProductPage.clickSellOnlineButton();
        nptProductPage.insertProductDescription(productDescription);
        nptProductDetailPageObject = nptProductPage.clickSaveButton();
        nptProductDetailPageObject.waitForLoadingIconInvisible(driver);
        assertEquals(nptProductDetailPageObject.getProductName(),productName);
        assertEquals(nptProductDetailPageObject.getBarcode(),strProductBarcode);
        assertEquals(nptProductDetailPageObject.getImportPrice(),"10.000đ");
        assertEquals(nptProductDetailPageObject.getSellingPrice(),"15.000đ");
        assertEquals(nptProductDetailPageObject.getBrandName(),brandName);
        assertEquals(nptProductDetailPageObject.getProductCategoryName(),productCategoryName);
        assertEquals(nptProductDetailPageObject.getProductGroupName(), productGroupName);
        assertEquals(nptProductDetailPageObject.getProductStatus(),"Đang bán");
        assertEquals(nptProductDetailPageObject.getSellOnlineStatus(),"Đang bán");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
