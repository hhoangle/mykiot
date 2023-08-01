package NPT.NptPageObjects;

import NPT.NptPageObjects.NptPageUIs.*;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NptCreatePurchaseOrderPageObject extends BasePage {
    private WebDriver driver;
    private int selectTime = 3;

    public NptCreatePurchaseOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToContinueButton() {
        clickToElement(driver, NptPurchaseOrderUI.CONTINUE_BUTTON);
    }

    public String getWarningMessage() {
        return getElementText(driver, NptPurchaseOrderUI.WARNING_MESSAGE_TEXT);
    }

    public void closeWarningPopup() {
        clickToElement(driver, NptPurchaseOrderUI.CLOSE_WARNING_POPUP_BUTTON);
    }

    public void selectThreeFirstProduct() {
        sleepInSecond(2);
        List<String> productList = new ArrayList<>();
        List<String> selectedProduct = new ArrayList<>();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        List<WebElement> selectedProductText = driver.findElements(By.xpath("//p[@class='font-medium text-sm mb-1']"));
        int countToClick = 0;
        int countToGetText = 0;
        for (WebElement checkbox : checkboxes) {
            if (countToClick >= selectTime) {
                break;
            }
            checkbox.click();
            countToClick++;
        }
        for (WebElement productText : selectedProductText) {
            if (countToGetText >= selectTime) {
                break;
            }
            countToGetText++;
            productList.add(productText.getText());
        }clickToElement(driver, NptPurchaseOrderUI.CONTINUE_BUTTON);
        List<WebElement> secondScreenItems = driver.findElements(By.xpath("//div[@class='flex justify-between items-center']/p"));
        for (WebElement element : secondScreenItems) {
            selectedProduct.add(element.getText());
        }
        scrollToBottomPage(driver);
        Assert.assertEquals(productList,selectedProduct);
    }

    public void insertOrderNote(String orderNote) {
        sendKeyToElement(driver, NptPurchaseOrderUI.ORDER_NOTE_FIELD, orderNote);
    }

    public void clickConfirmPurchaseOrder() {
        clickToElement(driver, NptPurchaseOrderUI.CONFIRM_PURCHASE_ORDER);
    }

    public String getPurchaseOrderStatus() {
        return getElementText(driver, NptPurchaseOrderUI.PURCHASE_ORDER_STATUS);
    }
}

