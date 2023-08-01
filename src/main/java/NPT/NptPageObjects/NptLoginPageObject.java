package NPT.NptPageObjects;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import NPT.NptPageObjects.NptPageUIs.NptHomePageUI;
import NPT.NptPageObjects.NptPageUIs.NptLoginUI;
import org.openqa.selenium.WebElement;

import static commons.GlobalConstants.*;

public class NptLoginPageObject extends BasePage {
    private WebDriver driver;
    public NptLoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    @Step("Login to website")
    public NptHomePageObject loginWebsite(String account, String password) {
    inputToAccountTextBox(account);
    inputToPasswordTextBox(password);
    clickToLoginButton();
    waitForLoadingIconInvisible(driver);
    return new NptHomePageObject(driver);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, NptLoginUI.LOGIN_BUTTON);
        clickToElement(driver, NptLoginUI.LOGIN_BUTTON);


    }

    public void inputToPasswordTextBox(String password) {
        waitForElementVisible(driver, NptLoginUI.PASSWORD_FIELD);
        sendKeyToElement(driver, NptLoginUI.PASSWORD_FIELD, password);
    }

    public void inputToAccountTextBox(String account) {
        waitForElementVisible(driver, NptLoginUI.ACCOUNT_FIELD);
        sendKeyToElement(driver, NptLoginUI.ACCOUNT_FIELD, account);
    }

    public String welcomeText() {
        waitForElementVisible(driver, NptHomePageUI.WELCOME_TEXT);
        return getElementText(driver, NptHomePageUI.WELCOME_TEXT);
    }

    public String errorText() {
        waitForElementVisible(driver, NptHomePageUI.ERROR_TEXT);
        return getElementText(driver, NptHomePageUI.ERROR_TEXT);
    }

    public void clickToAccountTextbox() {
        clickToElement(driver,NptLoginUI.ACCOUNT_FIELD);
    }
    public void clickToPasswordTextbox(){
        clickToElement(driver,NptLoginUI.PASSWORD_FIELD);
    }

    public String getErrorMessageAtAccountTextbox() {
        waitForElementVisible(driver,NptLoginUI.WARNING_MESSAGE1);
        return getElementText(driver,NptLoginUI.WARNING_MESSAGE1 );
    }

    public String getErrorMessageAtPassworkTextbox() {
        waitForElementVisible(driver,NptLoginUI.WARNING_MESSAGE2);
        return getElementText(driver,NptLoginUI.WARNING_MESSAGE2);
    }

    public void clickToClosePopup() {
        waitForElementVisible(driver,NptLoginUI.WRONG_ACCOUNT_POPUP);
        clickToElement(driver,NptLoginUI.WRONG_ACCOUNT_POPUP);
    }

    public NptHomePageObject goToNptHomePage(WebDriver driver) {
        NptLoginPageObject loginPage = new NptLoginPageObject(driver);
        NptHomePageObject nptHomePage;
        nptHomePage = loginPage.loginWebsite(NPT_ACCOUNT, NPT_PASSWORD);
        return new NptHomePageObject(driver);

    }

    public void verifySavePasswordButtonIsUnchecked() {
        waitForElementVisible(driver,NptLoginUI.SAVE_PASSWORD_CHECKBOX);
        WebElement savePasswordCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        assert !savePasswordCheckbox.isSelected();
    }

    public void verifyLoginButtonIsDisabled() {
        waitForElementVisible(driver,NptLoginUI.LOGIN_BUTTON);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='button']"));
        assert !loginButton.isEnabled();
    }
}
