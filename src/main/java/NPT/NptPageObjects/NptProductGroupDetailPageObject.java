package NPT.NptPageObjects;
import NPT.NptPageObjects.NptPageUIs.NptCategoryPageUI;
import NPT.NptPageObjects.NptPageUIs.NptProductGroupDetailUI;
import NPT.NptPageObjects.NptPageUIs.NptProductGroupUI;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NptProductGroupDetailPageObject extends BasePage {
    private WebDriver driver;

    public NptProductGroupDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductGroupNameText() {
        waitForLoadingIconInvisible(driver);
        return getElementText(driver, NptProductGroupDetailUI.PRODUCT_GROUP_NAME_IN_DETAIL_PAGE);
    }

    public String getProductCategoryNameText() {
        return getElementText(driver, NptProductGroupDetailUI.PRODUCT_CATEGORY_NAME_IN_DETAIL_PAGE);
    }

    public void confirmSelectedProductIsAdded() {
        List<String> selectedProduct = new ArrayList<>();
        List<WebElement> secondScreenItems = driver.findElements(By.xpath("//p[@class='font-medium text-black text-base']"));
        for (WebElement element : secondScreenItems) {
            selectedProduct.add(element.getText());
        }
    }
}