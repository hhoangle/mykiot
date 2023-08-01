package NPT.NptPageObjects;
import NPT.NptPageObjects.NptPageUIs.NptCategoryPageUI;
import NPT.NptPageObjects.NptPageUIs.NptProductGroupUI;
import NPT.NptPageObjects.NptPageUIs.NptProductCategoryDetailPageUI;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NptProductGroupPageObject extends BasePage{
    private WebDriver driver;
    private int selectTime = 3;
    public NptProductGroupPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateProductGroup() {
        clickToElement(driver, NptProductGroupUI.CREATE_PRODUCT_GROUP_BUTTON);
    }

    public NptProductGroupDetailPageObject clickSaveButton() {
        clickToElement(driver, NptProductGroupUI.SAVE_BUTTON);
        return new NptProductGroupDetailPageObject(driver);
    }

    public String getWarningMessage() {
        return getElementText(driver, NptProductGroupUI.WARNING_MESSAGE);
    }

    public void clickCloseWarningPopup() {
        clickToElement(driver, NptProductGroupUI.CLOSE_WARNING_POPUP_BUTTON);
    }

    public void insertProductGroupName(String productGroupName) {
        sendKeyToElement(driver, NptProductGroupUI.PRODUCT_GROUP_NAME_FIELD,productGroupName);
    }

    public void selectProductCategory() {
        clickToElement(driver, NptProductGroupUI.PRODUCT_CATEGORY_DROPDOWN);
        clickToElement(driver, NptProductGroupUI.PRODUCT_CATEGORY_NAME);
    }

    public void insertProductGroupDescription(String productGroupDescription) {
        sendKeyToElement(driver, NptProductGroupUI.PRODUCT_GROUP_DESCRIPTION_FIELD,productGroupDescription);
    }

    public void clickAddProduct() {
        clickToElement(driver, NptProductGroupUI.ADD_PRODUCT_BUTTON);
    }

    public void selectThreeFirstProduct() {
        List<String> productList = new ArrayList<>();
        List<String> selectedProduct = new ArrayList<>();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        List<WebElement> selectedProductText = driver.findElements(By.xpath("//div[@class='ml-4']/p[@class='font-medium']"));
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
        }
        clickToElement(driver, NptCategoryPageUI.CONFIRM_SELECT_PRODUCT_BUTTON);
        List<WebElement> secondScreenItems = driver.findElements(By.xpath("//div[@class='ml-4']//p[@class='font-medium mb-2']"));
        for (WebElement element : secondScreenItems) {
            selectedProduct.add(element.getText());
        }
        Assert.assertEquals(productList,selectedProduct);
    }
}
