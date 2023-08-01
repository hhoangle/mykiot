package NPT.NptPageObjects;

import NPT.NptPageObjects.NptPageUIs.NptBrandDetailPageUI;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NptBrandDetailPageObject extends BasePage {
    private WebDriver driver;
    public NptBrandDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getBrandNameInDetailPage(){
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, NptBrandDetailPageUI.BRAND_NAME_IN_DETAIL_PAGE);
        return getElementText(driver, NptBrandDetailPageUI.BRAND_NAME_IN_DETAIL_PAGE);
    }

    public String getClassification() {
        waitForElementVisible(driver, NptBrandDetailPageUI.CLASSIFICATION_IN_DETAIL_PAGE);
        return getElementText(driver, NptBrandDetailPageUI.CLASSIFICATION_IN_DETAIL_PAGE);
    }

    public void confirmSelectedProductIsAdded() {
        List<String> selectedProduct = new ArrayList<>();
        List<WebElement> secondScreenItems = driver.findElements(By.xpath("//p[@class='font-medium text-black text-base']"));
        for (WebElement element : secondScreenItems) {
            selectedProduct.add(element.getText());
        }
    }

    public void clickEditBrandInfo() {
        clickToElement(driver,NptBrandDetailPageUI.EDIT_BRAND_INFO_BUTTON);
    }

    public String getBrandNameDescription() {
        return getElementText(driver, NptBrandDetailPageUI.BRAND_DESCRIPTION_IN_DETAIL_PAGE);
    }
    public String getCurrentBrandNameInEditPage() {
        return getElementText(driver, NptBrandDetailPageUI.CURRENT_BRAND_NAME_IN_EDIT_PAGE);
    }

    public void insertNewBrandName(String newBrandName) {
        clearValueInElementByDeleteKey(driver, NptBrandDetailPageUI.BRAND_NAME_FIELD_IN_EDIT_PAGE);
        sendKeyToElement(driver, NptBrandDetailPageUI.BRAND_NAME_FIELD_IN_EDIT_PAGE, newBrandName);
    }

    public void insertNewBrandDescription(String newBrandDescription) {
        clearValueInElementByDeleteKey(driver, NptBrandDetailPageUI.BRAND_DESCRIPTION_IN_EDIT_PAGE);
        sendKeyToElement(driver,NptBrandDetailPageUI.BRAND_DESCRIPTION_IN_EDIT_PAGE,newBrandDescription);
    }

    public void clickSaveButton() {
        clickToElement(driver, NptBrandDetailPageUI.SAVE_BUTTON_IN_EDIT_PAGE);
    }
}
