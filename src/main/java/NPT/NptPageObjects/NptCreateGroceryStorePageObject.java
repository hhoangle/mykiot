package NPT.NptPageObjects;

import commons.BasePage;
import NPT.NptPageObjects.NptPageUIs.*;
import org.openqa.selenium.WebDriver;

public class NptCreateGroceryStorePageObject extends BasePage {
    private WebDriver driver;
    public NptCreateGroceryStorePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateGroceryStore() {
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, NptCreateGroceryStoreUI.ADD_GROCERY_STORE_BUTTON);
    }
    public void insertStoreInfor(String inputValue, String inputNameField) {
        sendKeyToElement(driver, NptCreateEmployeeUI.INPUT_FIELD, inputValue,inputNameField);
    }

    public void selectAddress() {
        clickToElement(driver, NptCreateEmployeeUI.ADD_ADDRESS_BUTTON);
        sleepInSecond(1);
        waitForElementVisible(driver, NptCreateEmployeeUI.CITY);
        clickToElement(driver, NptCreateEmployeeUI.CITY);
        waitForElementVisible(driver, NptCreateEmployeeUI.DISTRICT);
        clickToElement(driver, NptCreateEmployeeUI.DISTRICT);
        waitForElementVisible(driver, NptCreateEmployeeUI.WARD);
        clickToElement(driver, NptCreateEmployeeUI.WARD);
        waitForElementVisible(driver, NptCreateEmployeeUI.STREET);
        sendKeyToElement(driver, NptCreateEmployeeUI.STREET, "số 11 ngõ 50 đường 123");
        clickToElement(driver, NptCreateEmployeeUI.SAVE_ADDRESS_BUTTON);
    }

    public void selectBusinessType() {
        scrollToElement(driver,NptCreateGroceryStoreUI.BUSINESS_TYPE_DROP_DOWN);
        clickToElement(driver, NptCreateGroceryStoreUI.BUSINESS_TYPE_DROP_DOWN);
        clickToElement(driver, NptCreateGroceryStoreUI.BUSINESS_TYPE_OPTION);
    }

    public void selectOpenTime() {
        scrollToElement(driver, NptCreateGroceryStoreUI.OPEN_TIME_FIELD);
        clickToElement(driver, NptCreateGroceryStoreUI.OPEN_TIME_FIELD);
        clickToElement(driver, NptCreateGroceryStoreUI.OPEN_TIME_DROPDOWN);
        selectItemInCustomDropdown(driver, NptCreateGroceryStoreUI.OPEN_TIME_OPTIONS_LIST,NptCreateGroceryStoreUI.OPEN_TIME_OPTIONS);
    }
    public void selectCloseTime(){
        clickToElement(driver, NptCreateGroceryStoreUI.CLOSE_TIME_FIELD);
        clickToElement(driver, NptCreateGroceryStoreUI.CLOSE_TIME_DROPDOWN);
        selectItemInCustomDropdown(driver, NptCreateGroceryStoreUI.CLOSE_TIME_OPTIONS_LIST,NptCreateGroceryStoreUI.CLOSE_TIME_OPTIONS);
    }

    public NptDetailGroceryStorePageObject clickSaveGroceryStore() {
        clickToElement(driver, NptCreateGroceryStoreUI.SAVE_GROCERY_BUTTON);
        return new NptDetailGroceryStorePageObject(driver);
    }
}
