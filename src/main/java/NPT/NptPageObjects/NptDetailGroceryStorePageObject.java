package NPT.NptPageObjects;
import NPT.NptPageObjects.NptPageUIs.*;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class NptDetailGroceryStorePageObject extends BasePage {
    private WebDriver driver;
    public NptDetailGroceryStorePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getInforInDetailPage(WebDriver driver, String locator, String dynamicValue) {
        waitForElementVisible(driver,NptDetailGroceryPageUI.STORE_NAME_IN_DETAIL_PAGE,dynamicValue);
        return getElementText(driver,NptDetailGroceryPageUI.STORE_NAME_IN_DETAIL_PAGE,dynamicValue);
    }
}
