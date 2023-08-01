package Mykiot;

import NPT.NptPageObjects.*;
import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;

import static commons.GlobalConstants.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class nptCreateProductCategory extends BaseTest {
    WebDriver driver;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptProductPageObject nptProductPage;
    private NptCategoryPageObject nptCategoryPageObject;
    private NptProductCategoryPageObject nptProductCategoryObject;
    private NptProductCategoryDetailPageObject nptProductCategoryDetailPageObject;
    private NptProductCategoryEditPageObject nptProductCategoryEditPageObject;
    private String productCategoryName, warningMessage, classification, productCategoryDescription, productGroupName;
    private String newProductCategoryName,newProductCategoryDescription;
    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
        productCategoryName = "Decoration";
        productGroupName = "Modern Home";
        warningMessage = "Vui lòng nhập đầy đủ thông tin";
        classification = "Nhà phát triển";
        productCategoryDescription = "Phasellus feugiat erat a ex fringilla volutpat";
        newProductCategoryName = BasePage.getRandomString();
        newProductCategoryDescription = BasePage.getRandomString();
    }

    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }

    @Test
    public void TC_01_Create_Product_Category_Without_Insert_Name() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptProductCategoryObject = nptCategoryPageObject.clickToProductCategory();
        nptProductCategoryObject.clickToCategory();
        nptProductCategoryObject.clickCreateProductCategory();
        nptProductCategoryObject.clickSaveButton();
        //IF PRODUCT CATEGORY IS EMPTY THEN CLICK SAVE, WARNING MESSAGE SHOULD BE DISPLAYED
        assertEquals(nptProductCategoryObject.getWarningMessage(), warningMessage);
        nptProductCategoryObject.clickCloseWarningPopup();
    }

    @Test
    public void TC_02_Create_Product_Category_Without_Add_Product_Group() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptProductCategoryObject = nptCategoryPageObject.clickToProductCategory();
        nptProductCategoryObject.clickToCategory();
        nptProductCategoryObject.clickCreateProductCategory();
        nptProductCategoryObject.insertProductCategoryName(productCategoryName);
        nptProductCategoryObject.insertProductCategoryDescription(productCategoryDescription);
        nptProductCategoryDetailPageObject = nptProductCategoryObject.clickSaveButton();
        //AFTER SAVED, PRODUCT CATEGORY INFOR SHOULD BE SAME AS INPUT: NAME, CLASSIFICATION, DESCRIPTION
        assertEquals(nptProductCategoryDetailPageObject.getProductCategoryName(), productCategoryName);
        assertEquals(nptProductCategoryDetailPageObject.getClassification(), classification);
        assertEquals(nptProductCategoryDetailPageObject.getProductCategoryDescription(), productCategoryDescription);
    }

    @Test
    public void TC_03_Create_Product_Category_And_Add_Product_Group() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptProductCategoryObject = nptCategoryPageObject.clickToProductCategory();
        nptProductCategoryObject.clickToCategory();
        nptProductCategoryObject.clickCreateProductCategory();
        nptProductCategoryObject.insertProductCategoryName(productCategoryName);
        nptProductCategoryObject.insertProductCategoryDescription(productCategoryDescription);
        //ADD PRODUCT GROUP AFTER CREATED PRODUCT CATEGORY
        nptProductCategoryDetailPageObject = nptProductCategoryObject.clickSaveButton();
        nptProductCategoryDetailPageObject.clickToAddProductGroup();
        nptProductCategoryDetailPageObject.insertProductGroupName(productGroupName);
        nptProductCategoryDetailPageObject.clickToConfirmCreateProductGroup();
        //AFTER SAVED, PRODUCT CATEGORY INFOR SHOULD BE SAME AS INPUT: PRODUCT GROUP & PRODUCT CATEGORY NAME, CLASSIFICATION, DESCRIPTION
        assertEquals(nptProductCategoryDetailPageObject.getProductGroupInDetailPage(), productGroupName);
        assertEquals(nptProductCategoryDetailPageObject.getProductCategoryName(), productCategoryName);
        assertEquals(nptProductCategoryDetailPageObject.getClassification(), classification);
        assertEquals(nptProductCategoryDetailPageObject.getProductCategoryDescription(), productCategoryDescription);
    }
    @Test
    public void TC_04_Update_Prodcut_Category(){
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptProductCategoryObject = nptCategoryPageObject.clickToProductCategory();
        nptProductCategoryObject.clickToCategory();
        nptProductCategoryObject.clickCreateProductCategory();
        nptProductCategoryObject.insertProductCategoryName(productCategoryName);
        nptProductCategoryObject.insertProductCategoryDescription(productCategoryDescription);
        //ADD PRODUCT GROUP AFTER CREATED PRODUCT CATEGORY
        nptProductCategoryDetailPageObject = nptProductCategoryObject.clickSaveButton();
        nptProductCategoryDetailPageObject.clickToAddProductGroup();
        nptProductCategoryDetailPageObject.insertProductGroupName(productGroupName);
        nptProductCategoryDetailPageObject.clickToConfirmCreateProductGroup();
        //AFTER SAVED, PRODUCT CATEGORY INFOR SHOULD BE SAME AS INPUT: PRODUCT GROUP & PRODUCT CATEGORY NAME, CLASSIFICATION, DESCRIPTION
        assertEquals(nptProductCategoryDetailPageObject.getProductGroupInDetailPage(), productGroupName);
        assertEquals(nptProductCategoryDetailPageObject.getClassification(), classification);
        assertEquals(nptProductCategoryDetailPageObject.getProductCategoryDescription(), productCategoryDescription);
        nptProductCategoryEditPageObject = nptProductCategoryDetailPageObject.clickToEditProductCategory();
        nptProductCategoryEditPageObject.insertNewProductCategoryName(newProductCategoryName);
        nptProductCategoryEditPageObject.insertNewProductCategoryDescription(newProductCategoryName);
        nptProductCategoryDetailPageObject = nptProductCategoryEditPageObject.clickSaveButton();
        assertEquals(nptProductCategoryDetailPageObject.getProductGroupInDetailPage(), productGroupName);
        assertEquals(nptProductCategoryDetailPageObject.getProductCategoryName(), newProductCategoryName);
        assertEquals(nptProductCategoryDetailPageObject.getClassification(), classification);
        assertEquals(nptProductCategoryDetailPageObject.getProductCategoryDescription(), newProductCategoryName);
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}