package NPT.NptPageObjects;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import NPT.NptPageObjects.NptPageUIs.NptCategoryPageUI;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static NPT.NptPageObjects.NptPageUIs.NptProductPageUI.PRODUCT_IMAGE;

public class NptCategoryPageObject extends BasePage {
    private WebDriver driver;
    private int selectTime = 3;

    public NptCategoryPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateBrandButton() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, NptCategoryPageUI.CREATE_BRAND_BUTTON);
        clickToElement(driver, NptCategoryPageUI.CREATE_BRAND_BUTTON);
    }

    public void inputImg(String imagePath) {
        uploadImage(driver, PRODUCT_IMAGE, imagePath);
    }

    public void insertBrandName(String brandName) {
        waitForElementVisible(driver, NptCategoryPageUI.BRAND_NAME_FIELD);
        sendKeyToElement(driver, NptCategoryPageUI.BRAND_NAME_FIELD, brandName);
    }

    public NptBrandDetailPageObject clickSaveButton() {
        waitForElementVisible(driver, NptCategoryPageUI.SAVE_BRAND_BUTTON);
        clickToElement(driver, NptCategoryPageUI.SAVE_BRAND_BUTTON);
        return new NptBrandDetailPageObject(driver);
    }

    public String getWarningMessage() {
        waitForElementVisible(driver, NptCategoryPageUI.WARNING_MESSAGE);
        return getElementText(driver, NptCategoryPageUI.WARNING_MESSAGE);
    }

    public void clickCloseWarningPopup() {
        clickToElement(driver, NptCategoryPageUI.CLOSE_WARNING_POPUP_BUTTON);
    }

    public void clickAddProductToBrand() {
        clickToElement(driver, NptCategoryPageUI.ADD_PRODUCT_TO_BRAND_BUTTON);
    }

    public void selectThreeFirstProducts() {
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

    public NptProductCategoryPageObject clickToProductCategory() {
        clickToElement(driver, NptCategoryPageUI.BURGER_MENU);
        return new NptProductCategoryPageObject(driver);
    }

    public void insertBrandDescription(String branDescription) {
        sendKeyToElement(driver, NptCategoryPageUI.BRAND_DESCRIPTION_FIELD,branDescription);
    }

    public NptProductGroupPageObject clickToProductGroup() {
        clickToElement(driver,NptCategoryPageUI.BURGER_MENU);
        clickToElement(driver,NptCategoryPageUI.PRODUCT_GROUP_BUTTON);
        return new NptProductGroupPageObject(driver);
    }
}