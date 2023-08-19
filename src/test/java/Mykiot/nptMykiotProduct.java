package Mykiot;

import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import NPT.NptPageObjects.NptMykiotProduct;
import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static commons.GlobalConstants.*;
import static java.lang.String.valueOf;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class                                                                                                                       nptMykiotProduct extends BaseTest {
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptMykiotProduct nptMykiotProduct;
    WebDriver driver;
    private String unitPrice, totalPrice,cartEmptyMessage;
    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
        cartEmptyMessage = "Không có sản phẩm nào trong giỏ hàng cả!";
    }
    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Add_Product_To_Cart_Then_Make_Order(){
        goToHomePage();
        nptMykiotProduct = nptHomePage.clickToMykiotProduct();
        nptMykiotProduct.selectMykiotProduct();
        unitPrice = nptMykiotProduct.getUnitPrice();
        nptMykiotProduct.clickCartButton();
        nptMykiotProduct.addToCart();
        nptMykiotProduct.clickConfirmAddToCard();
        nptMykiotProduct.clickToCartDetail();
        nptMykiotProduct.selectCheckbox();
        assertEquals(nptMykiotProduct.getUnitPriceInCartPage(),unitPrice);
        totalPrice = nptMykiotProduct.getTotalPriceInCartPage();
        assertEquals(nptMykiotProduct.getTotalPriceInCartPage(),totalPrice);
        String addedAmountItem = nptMykiotProduct.getAddedAmountItem();
        assertTrue(addedAmountItem.contains(valueOf(CLICK_INCREASE)));
        nptMykiotProduct.clickToContinue();
        assertEquals(nptMykiotProduct.getTotalPriceInConfirmOrderPage(),totalPrice);
        nptMykiotProduct.clickToConfirmOrder();
        assertEquals(nptMykiotProduct.getTotalPriceInDetailOrderPage(),totalPrice);
    }
    @Test
    public void TC_02_Remove_Item_From_Cart(){
        goToHomePage();
        nptMykiotProduct = nptHomePage.clickToMykiotProduct();
        nptMykiotProduct.selectMykiotProduct();
        unitPrice = nptMykiotProduct.getUnitPrice();
        nptMykiotProduct.clickCartButton();
        nptMykiotProduct.addToCart();
        nptMykiotProduct.clickConfirmAddToCard();
        nptMykiotProduct.clickToCartDetail();
        assertFalse(nptMykiotProduct.isContinueButtonDisable());
        nptMykiotProduct.removeAddedItem();
        assertEquals(nptMykiotProduct.getCartEmptyWarningMessage(),cartEmptyMessage);
    }
}
