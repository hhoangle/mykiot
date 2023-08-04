package NPT.NptPageObjects;

import commons.BasePage;
import NPT.NptPageObjects.NptPageUIs.NptMykiotProductUI;
import org.openqa.selenium.WebDriver;

import static commons.GlobalConstants.*;

public class NptMykiotProduct extends BasePage {
    private WebDriver driver;
    public NptMykiotProduct(WebDriver driver) {
        this.driver = driver;
    }

    public void selectMykiotProduct() {
        clickToElement(driver, NptMykiotProductUI.MYKIOT_PRODUCT);
    }

    public void addToCart() {
        sleepInSecond(1);
        for (int i = 0; i < CLICK_INCREASE; i++) {
            clickToElement(driver,NptMykiotProductUI.ADD_PRODUCT_BUTTON);
        }
    }
    public void clickCartButton() {
        clickToElement(driver, NptMykiotProductUI.CART_BUTTON);
    }
    public void clickConfirmAddToCard(){
        clickToElement(driver, NptMykiotProductUI.ADD_TO_CART_BUTTON);
    }

    public void clickToCartDetail() {
        sleepInSecond(2);
        clickToElement(driver, NptMykiotProductUI.CART_DETAIL_BUTTON);
    }

    public void selectCheckbox() {
        clickToElement(driver, NptMykiotProductUI.CART_CHECKBOX);
    }

    public String getAddedAmountItem() {
        return getElementText(driver, NptMykiotProductUI.ADD_AMOUNT_ITEM);
    }

    public void clickToContinue() {
        clickToElement(driver, NptMykiotProductUI.CONTINUE_BUTTON);
    }

    public void clickToConfirmOrder() {
        clickToElement(driver, NptMykiotProductUI.CONFIRM_ORDER_BUTTON);
    }

    public String getUnitPrice() {
        sleepInSecond(3);
        return getElementText(driver, NptMykiotProductUI.UNIT_PRICE);
    }

    public String getUnitPriceInCartPage() {
        sleepInSecond(1);
        return getElementText(driver, NptMykiotProductUI.UNIT_PRICE_IN_CART_PAGE);
    }

    public String getTotalPriceInCartPage() {
        return getElementText(driver, NptMykiotProductUI.TOTAL_PRICE_IN_CART_PAGE);
    }

    public String getTotalPriceInConfirmOrderPage() {
        return getElementText(driver, NptMykiotProductUI.TOTAL_PRICE_IN_CONFIRM_ORDER_PAGE);
    }

    public String getTotalPriceInDetailOrderPage() {
        sleepInSecond(3);
        return getElementText(driver,NptMykiotProductUI.TOTAL_PRICE_IN_DETAIL_ORDER);
    }

    public boolean isContinueButtonDisable() {
       return isButtonEnabled(driver, NptMykiotProductUI.CONTINUE_BUTTON);
    }

    public void removeAddedItem() {
        clickToElement(driver, NptMykiotProductUI.REMOVE_ITEM_BUTTON);
        sleepInSecond(1);
    }

    public String getCartEmptyWarningMessage() {
    return getElementText(driver, NptMykiotProductUI.EMPTY_CART_WARNING_MESSAGE);
    }
}