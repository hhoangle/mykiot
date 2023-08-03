package Mykiot;

import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import NPT.NptPageObjects.NptMykiotProduct;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;

import static commons.GlobalConstants.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class nptMykiotProduct extends BaseTest {
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptMykiotProduct nptMykiotProduct;
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
    }
    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Add_Product_To_Cart(){
        goToHomePage();
        nptMykiotProduct = nptHomePage.clickToMykiotProduct();
        nptMykiotProduct.selectMykiotProduct();
        nptMykiotProduct.clickCartButton();
        nptMykiotProduct.addToCart();
        nptMykiotProduct.clickConfirmAddToCard();
    }
}
