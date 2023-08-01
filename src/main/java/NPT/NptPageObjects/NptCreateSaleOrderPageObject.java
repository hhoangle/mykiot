package NPT.NptPageObjects;
import NPT.NptPageObjects.NptPageUIs.NptSalesOrderUI;
import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NptCreateSaleOrderPageObject extends BasePage{
    private WebDriver driver;
    private int selectTime = 3;
    public NptCreateSaleOrderPageObject(WebDriver driver) {
        this.driver = driver;
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
        }
    }

    public void clickToContinueButton() {
        clickToElement(driver, NptSalesOrderUI.CONTINUE_BUTTON);
    }

    public NptDetailSaleOrderPageObject clickToConfirmButton() {
        clickToElement(driver, NptSalesOrderUI.CONFIRM_BUTTON);
        return new NptDetailSaleOrderPageObject(driver);
    }

    public String getWarningMessage() {
        return getElementText(driver, NptSalesOrderUI.WARNING_MESSAGE);
    }

    public void selectStore() {
        clickToElement(driver, NptSalesOrderUI.STORE_DROPDOWN_BUTTON);
        sleepInSecond(1);
        clickToElement(driver, NptSalesOrderUI.STORE_NAME);
    }
}
