package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;


import static commons.BasePageUI.*;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;
import static org.testng.Assert.assertTrue;

public class BasePage {


    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }



    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getPageUrl(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(3);
    }

    protected Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait eplicitWait = new WebDriverWait(driver, longTimeout);
        return eplicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    protected void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    protected String getTextAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    protected void sendKeyToAlert(WebDriver driver, String textValue) {
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    protected void switchToWindowByID(WebDriver driver, String windowID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    protected void switchToWindowByPageTitle(WebDriver driver, String expectedPageTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            // sleepInSecond(2);
            String actualPageTitle = driver.getTitle().trim();
            if (actualPageTitle.equals(expectedPageTitle)) {
                break;
            }
        }
    }

    protected void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    private String getDynamicXpath(String locator, String... dynamicValues) {
        locator = String.format(locator, (Object[]) dynamicValues);
        return locator;
    }


    private WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(By.xpath(locatorType));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public void clickToElement(WebDriver driver, String locatorType) {
        this.getWebElement(driver, locatorType).click();
    }

    public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
        this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
    }

    public void clickAndHold(WebDriver driver, String locatorType) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(this.getWebElement(driver, locatorType)).moveByOffset(-1000, 0).release().build().perform();
    }

    public void dragAndDrop(WebDriver driver, String locatorFrom,String locatorTo) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(this.getWebElement(driver, locatorFrom),  this.getWebElement(driver, locatorTo)).build().perform();
    }

    public void sendKeyToElement(WebDriver driver, String locatorType, String textValue) {
        WebElement element = this.getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(textValue);
    }

    public void clearValueInElementByDeleteKey(WebDriver driver, String locatorType) {
        WebElement element = this.getWebElement(driver, locatorType);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void sendKeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
        WebElement element = this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }

    public String getElementText(WebDriver driver, String locatorType) {
        return this.getWebElement(driver, locatorType).getText();
    }

    public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
        return this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
    }

    public void selecItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
        Select select = new Select(this.getWebElement(driver, locatorType));
        select.selectByVisibleText(textItem);
    }

    public void selecItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
        Select select = new Select(this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
        select.selectByVisibleText(textItem);
    }

    public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
        Select select = new Select(this.getWebElement(driver, locatorType));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String... dynamicValues) {
        Select select = new Select(this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropDownMultiple(WebDriver driver, String locatorType) {
        Select select = new Select(this.getWebElement(driver, locatorType));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator) {
        sleepInSecond(2);
        this.getWebElement(driver, parentLocator).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
        for (WebElement item : allItems) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
            sleepInSecond(1);
            item.click();
            break;
        }
    }

    public String getElementAttribute(WebDriver driver, String locatorType, String atributeName) {
        return this.getWebElement(driver, locatorType).getAttribute(atributeName);
    }

    public String getElementAttribute(WebDriver driver, String locatorType, String atributeName, String... dynamicValues) {
        return this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(atributeName);
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return this.getWebElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementsSize(WebDriver driver, String locatorType) {
        return getListWebElement(driver, locatorType).size();
    }

    public int getElementsSize(WebDriver driver, String locatorType, String... dynamicValues) {
        return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
    }

    public void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locatorType) {
        WebElement element = this.getWebElement(driver, locatorType);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
        WebElement element = this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckBox(WebDriver driver, String locatorType) {
        WebElement element = this.getWebElement(driver, locatorType);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckBox(WebDriver driver, String locatorType, String... dynamicValues) {
        WebElement element = this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplay(WebDriver driver, String locatorType) {
        return this.getWebElement(driver, locatorType).isDisplayed();
    }

    public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
        overrideImplicitTimeout(driver, shortTimeout);
        List<WebElement> elements = getListWebElement(driver, locatorType);
        overrideImplicitTimeout(driver, longTimeout);

        // ko có trong DOM
        if (elements.size() == 0) {
            return true;

            // có trong DOM nhưng ko hiển thị
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
        overrideImplicitTimeout(driver, shortTimeout);
        List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        overrideImplicitTimeout(driver, longTimeout);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void overrideImplicitTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public boolean isElementDisplay(WebDriver driver, String locatorType, String... dynamicValues) {
        return this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
    }

    public boolean isElementEnable(WebDriver driver, String locator) {
        return this.getWebElement(driver, locator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return this.getWebElement(driver, locator).isSelected();
    }

    public void switchToFrameIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(this.getWebElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String locatorType) {
        Actions action = new Actions(driver);
        action.moveToElement(this.getWebElement(driver, locatorType)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(this.getWebElement(driver, locatorType), key).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
        Actions action = new Actions(driver);
        action.sendKeys(this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void scrollToTopPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0)");
    }

    public void highlightElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = this.getWebElement(driver, locatorType);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void highlightElement(WebDriver driver, String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", this.getWebElement(driver, locatorType));
    }

    public void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", this.getWebElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", this.getWebElement(driver, getDynamicXpath(locator, dynamicValues)));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", this.getWebElement(driver, locator));
    }
    public String getTextByJs(WebDriver driver, String locatorType){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(locatorType));
        String contents = (String) js.executeScript("return arguments[0].innerHTML;", element);
        return contents;
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", this.getWebElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
        return status;
    }

    public void uploadImage(WebDriver driver, String locator, String imagePath) {
        WebElement element = this.getWebElement(driver, locator);
        element.sendKeys(imagePath);
    }

    public void waitForElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorType)));
    }

    public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForAllElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorType)));
    }

    public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForElementInvisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorType)));
    }

    /*
     * Wait for element undisplayed in DOM or not in DOM and override implicit timeout
     */
    public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
        overrideImplicitTimeout(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorType)));
        overrideImplicitTimeout(driver, longTimeout);
    }


    public void waitForAllElementInvisible(WebDriver driver, String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorType)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForLoadingIconInvisible(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADING_ICON)));
    }

    /**
     * Enter to dynamic Textbox by ID
     *
     * @param driver
     * @param textboxID
     * @param value
     */
    public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
        waitForElementVisible(driver, DYNAMIC_TEXTBOX_BY_ID, textboxID);
        sendKeyToElement(driver, DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
    }

    /**
     * Click to dynamic Button by text
     *
     * @param driver
     * @param buttonText
     */
    public void clickToButtonByText(WebDriver driver, String buttonText) {
        waitForElementClickable(driver, DYNAMIC_BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, DYNAMIC_BUTTON_BY_TEXT, buttonText);
    }

    public void clickToInputByPlaceholder(WebDriver driver, String inputText) {
        waitForElementClickable(driver, DYNAMIC_INPUT_BY_PLACEHOLDER, inputText);
        clickToElement(driver, DYNAMIC_INPUT_BY_PLACEHOLDER, inputText);
    }

    public void inputByPlaceholder(WebDriver driver, String inputText, String value) {
        waitForElementClickable(driver, DYNAMIC_INPUT_BY_PLACEHOLDER, inputText);
        sendKeyToElement(driver, DYNAMIC_INPUT_BY_PLACEHOLDER, value, inputText);
    }

    public void inputDynamic(WebDriver driver, String inputText, String value) {
        waitForElementClickable(driver, DYNAMIC_INPUT, inputText);
        sendKeyToElement(driver, DYNAMIC_INPUT, value, inputText);
    }

    public String getErrorInputByPlaceholder(WebDriver driver, String errorTextInput) {
        waitForElementVisible(driver, DYNAMIC_ERROR_INPUT_BY_PLACEHOLDER, errorTextInput);
        return getElementText(driver, DYNAMIC_ERROR_INPUT_BY_PLACEHOLDER, "value", errorTextInput);
    }

    /**
     * Select to Dynamic Dropdown by name attribute
     *
     * @param driver
     * @param itemValue
     */
    public void selectToDropdownByName(WebDriver driver, String dropDownAttributeName, String itemValue) {
        waitForElementClickable(driver, DYNAMIC_DROPDOWN_BY_NAME, dropDownAttributeName);
        selecItemInDefaultDropdown(driver, DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropDownAttributeName);
    }

    /**
     * Select to Dynamic Radio by label
     *
     * @param driver
     * @param radioButtonLabelName
     */
    public void clickToRadioButtonByLabel(WebDriver driver, String radioButtonLabelName) {
        waitForElementVisible(driver, DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
        checkToDefaultCheckBoxOrRadio(driver, DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
    }

    /**
     * Select to Dynamic Checkbox by label name
     *
     * @param driver
     * @param checkboxLabelName
     */
    public void clickToCheckboxByLabel(WebDriver driver, String checkboxLabelName) {
        waitForElementVisible(driver, DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
        checkToDefaultCheckBoxOrRadio(driver, DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
    }

    /**
     * Get Dynamic value in Textbox by ID
     *
     * @param driver
     */
    public String getTextboxValueByID(WebDriver driver, String textboxID) {
        waitForElementVisible(driver, DYNAMIC_TEXTBOX_BY_ID, textboxID);
        return getElementAttribute(driver, DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
    }

    public static void sleepInSecond(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomInt() {
        return randomNumeric(5);
    }

    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public boolean verifyAllItemsHaveStatus(WebDriver driver, String locator , String statusToCheck) {
        boolean allItemsDenied = false;
        // Find all items in the list
        List<WebElement> items = driver.findElements(By.xpath(locator));
        // Check the status for each item
        for (WebElement item : items) {
            String status = item.findElement(By.xpath(locator)).getText();
            if (!status.equals(statusToCheck)) {
                break;
            } else {
                allItemsDenied = true;
            }
        }
        return allItemsDenied;
    }
    public boolean verifyAllItemsHaveCorrectType(WebDriver driver, String locator , String statusToCheck) {
        boolean allItemsDenied = false;
        // Find all items in the list
        List<WebElement> items = driver.findElements(By.xpath(locator));
        // Check the status for each item
        for (WebElement item : items) {
            String status = item.findElement(By.xpath(locator)).getText();
            if (!status.equals(statusToCheck)) {
                break;
            } else {
                allItemsDenied = true;
            }
        }
        return allItemsDenied;
    }
}
