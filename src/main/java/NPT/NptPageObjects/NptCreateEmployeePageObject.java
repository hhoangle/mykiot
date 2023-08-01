package NPT.NptPageObjects;
import NPT.NptPageObjects.NptPageUIs.NptCreateEmployeeUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class NptCreateEmployeePageObject extends BasePage {
    private WebDriver driver;
    public NptCreateEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateEmployeeButton() {
        waitForLoadingIconInvisible(driver);
        clickToElement(driver, NptCreateEmployeeUI.CREATE_EMPLOYEE_BUTTON);
    }

    public void insertEmployeeInfor(String inputValue, String inputNameField) {
        sendKeyToElement(driver, NptCreateEmployeeUI.INPUT_FIELD, inputValue,inputNameField);
    }

    public void selectPosition() {
        clickToElement(driver, NptCreateEmployeeUI.POSITION_DROPDOWN);
        sleepInSecond(1);
        clickToElement(driver, NptCreateEmployeeUI.POSITION_OPTION);
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

    public void clickSaveButton() {
        clickToElement(driver, NptCreateEmployeeUI.SAVE_BUTTON);
    }

    public String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("09");
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10);
            phoneNumber.append(digit);
        }
        return phoneNumber.toString();
    }

    public boolean isSaveButtonEnabled() {
        return isElementEnable(driver, NptCreateEmployeeUI.SAVE_BUTTON);
    }

    public String getErrorMessage(String addressErrorMessage) {
        return getElementText(driver, NptCreateEmployeeUI.WARNING_TEXT,addressErrorMessage);
    }
}
