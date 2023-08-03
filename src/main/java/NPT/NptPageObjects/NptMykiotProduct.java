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
}