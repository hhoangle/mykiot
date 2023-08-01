package Mykiot;
import NPT.NptPageObjects.*;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import static commons.GlobalConstants.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class nptCreateBrand extends BaseTest {
    WebDriver driver;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptProductPageObject nptProductPage;
    private NptCategoryPageObject nptCategoryPageObject;
    private NptBrandDetailPageObject nptBrandDetailPageObject;
    private String imagePath, brandName,warningMessage,classification,branDescription,newBrandName,newBrandDescription;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
        brandName = "Famous Brand";
        newBrandName = "The New Brand";
        imagePath = PROJECT_PATH + "\\uploadFiles\\NewProductImage.png";
        warningMessage = "Vui lòng nhập đầy đủ thông tin";
        classification = "Nhà phát triển";
        branDescription = "Cras at imperdiet eros, eget congue tortor.";
        newBrandDescription = "Curabitur sit amet sem non mi ornare volutpat";
    }
    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Create_Brand_Without_Input() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptCategoryPageObject.clickCreateBrandButton();
        nptCategoryPageObject.clickSaveButton();
        assertEquals(nptCategoryPageObject.getWarningMessage(),warningMessage);
        nptCategoryPageObject.clickCloseWarningPopup();
    }
    @Test
    public void TC_02_Create_Brand_Without_Product(){
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptCategoryPageObject.clickCreateBrandButton();
        nptCategoryPageObject.inputImg(imagePath);
        nptCategoryPageObject.insertBrandName(brandName);
        nptCategoryPageObject.insertBrandDescription(branDescription);
        nptBrandDetailPageObject = nptCategoryPageObject.clickSaveButton();
        assertEquals(nptBrandDetailPageObject.getBrandNameInDetailPage(),brandName);
        assertEquals(nptBrandDetailPageObject.getClassification(),classification);
        assertEquals(nptBrandDetailPageObject.getBrandNameDescription(),branDescription);
    }
    @Test
    public void TC_03_Create_Brand_With_Product(){
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptCategoryPageObject.clickCreateBrandButton();
        nptCategoryPageObject.inputImg(imagePath);
        nptCategoryPageObject.insertBrandName(brandName);
        nptCategoryPageObject.insertBrandDescription(branDescription);
        nptCategoryPageObject.clickAddProductToBrand();
        //SELECT 3 FIRST PRODUCTS, SELECTED ONE SHOULD BE APPEARED IN THE LIST
        nptCategoryPageObject.selectThreeFirstProducts();
        nptBrandDetailPageObject = nptCategoryPageObject.clickSaveButton();
        assertEquals(nptBrandDetailPageObject.getBrandNameInDetailPage(),brandName);
        assertEquals(nptBrandDetailPageObject.getClassification(),classification);
        nptBrandDetailPageObject.confirmSelectedProductIsAdded();
    }
    @Test
    public void TC_04_Update_Brand(){
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptCategoryPageObject = nptProductPage.clickToManageCategory();
        nptCategoryPageObject.clickCreateBrandButton();
        nptCategoryPageObject.inputImg(imagePath);
        nptCategoryPageObject.insertBrandName(brandName);
        nptCategoryPageObject.insertBrandDescription(branDescription);
        nptCategoryPageObject.clickAddProductToBrand();
        //SELECT 3 FIRST PRODUCTS, SELECTED ONE SHOULD BE APPEARED IN THE LIST
        nptCategoryPageObject.selectThreeFirstProducts();
        nptBrandDetailPageObject = nptCategoryPageObject.clickSaveButton();
        nptBrandDetailPageObject.clickEditBrandInfo();
        assertEquals(nptBrandDetailPageObject.getCurrentBrandNameInEditPage(),brandName);
        nptBrandDetailPageObject.insertNewBrandName(newBrandName);
        nptBrandDetailPageObject.insertNewBrandDescription(newBrandDescription);
        nptBrandDetailPageObject.clickSaveButton();
        assertEquals(nptBrandDetailPageObject.getBrandNameInDetailPage(),newBrandName);
        assertEquals(nptBrandDetailPageObject.getBrandNameDescription(),newBrandDescription);
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
