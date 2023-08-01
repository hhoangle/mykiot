package Mykiot;

import NPT.NptPageObjects.*;
import NPT.NptPageObjects.NptPageUIs.NptProductGroupDetailUI;
import NPT.NptPageObjects.NptPageUIs.NptProductGroupUI;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;

import static commons.GlobalConstants.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class nptCreateProductGroup extends BaseTest {
    WebDriver driver;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptProductPageObject nptProductPage;
    private NptCategoryPageObject nptCategoryPageObject;
    private NptProductGroupPageObject nptProductGroupPageObject;
    private NptProductGroupDetailPageObject nptProductGroupDetailPageObject;
    private String productGroupName, productGroupDescription, productCategory, warningMessage;
    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
        productGroupName = "Modern Home";
        warningMessage = "Vui lòng nhập đầy đủ thông tin";
        productGroupDescription = "Phasellus feugiat erat a ex fringilla volutpat";
    }
    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Create_Product_Group_Without_Insert_Name() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptProductGroupPageObject = nptCategoryPageObject.clickToProductGroup();
        nptProductGroupPageObject.clickToCreateProductGroup();
        nptProductGroupPageObject.clickSaveButton();
        //IF NOT INSERT PRODUCT GROUP NAME AND CLICK SAVE, THEN WARNING POPUP SHOULD BE DISPLAYED
        assertEquals(nptProductGroupPageObject.getWarningMessage(), warningMessage);
        nptProductGroupPageObject.clickCloseWarningPopup();
    }
    @Test
    public void TC_02_Create_Product_Group_Without_Select_Product() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptProductGroupPageObject = nptCategoryPageObject.clickToProductGroup();
        nptProductGroupPageObject.clickToCreateProductGroup();
        nptProductGroupPageObject.insertProductGroupName(productGroupName);
        //SELECT PRODUCT CATEGORY THEN IT SHOULD BE DISPLAYED IN THE LIST
        nptProductGroupPageObject.selectProductCategory();
        productCategory = nptProductGroupPageObject.getElementText(driver, NptProductGroupUI.SELECTED_PRODUCT_CATEGORY);
        nptProductGroupPageObject.insertProductGroupDescription(productGroupDescription);
        nptProductGroupDetailPageObject = nptProductGroupPageObject.clickSaveButton();
        //AFER SAVED, COMPARE PRODUCT GROUP NAME & ADDED PRODUCT CATEGORY
        assertEquals(nptProductGroupDetailPageObject.getProductGroupNameText(),productGroupName);
        assertEquals(nptProductGroupDetailPageObject.getProductCategoryNameText(),productCategory);
    }
    @Test
    public void TC_03_Create_Product_Group_With_Product(){
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptProductGroupPageObject = nptCategoryPageObject.clickToProductGroup();
        nptProductGroupPageObject.clickToCreateProductGroup();
        nptProductGroupPageObject.insertProductGroupName(productGroupName);
        nptProductGroupPageObject.selectProductCategory();
        productCategory = nptProductGroupPageObject.getElementText(driver, NptProductGroupUI.SELECTED_PRODUCT_CATEGORY);
        nptProductGroupPageObject.insertProductGroupDescription(productGroupDescription);
        //SELECT 3 FIRST PRODUCTS
        nptProductGroupPageObject.clickAddProduct();
        nptProductGroupPageObject.selectThreeFirstProduct();
        nptProductGroupDetailPageObject = nptProductGroupPageObject.clickSaveButton();
        //AFTER SAVED, COMPARE PRODUCT GROUP NAME & ADDED PRODUCT CATEGORY, ADDED PRODUCTS
        assertEquals(nptProductGroupDetailPageObject.getProductGroupNameText(),productGroupName);
        assertEquals(nptProductGroupDetailPageObject.getProductCategoryNameText(),productCategory);
        nptProductGroupDetailPageObject.confirmSelectedProductIsAdded();
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
