package AdminPageObjects;
import NPT.NptPageObjects.NptPageUIs.NptLoginUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import AdminPageObjects.*;
import AdminPageUIs.*;
import org.openqa.selenium.WebElement;

public class AdminLoginPageObject extends BasePage{
    private WebDriver driver;
    public AdminLoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    @Step("Login to website")
    public AdminHomePageObject loginWebsite(String account, String password) {
        inputToAccountTextBox(account);
        inputToPasswordTextBox(password);
        clickToLoginButton();
        waitForLoadingIconInvisible(driver);
        return new AdminHomePageObject(driver);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, AdminLoginUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginUI.LOGIN_BUTTON);


    }

    public void inputToPasswordTextBox(String password) {
        waitForElementVisible(driver, AdminLoginUI.PASSWORD_FIELD);
        sendKeyToElement(driver, AdminLoginUI.PASSWORD_FIELD, password);
    }

    public void inputToAccountTextBox(String account) {
        waitForElementVisible(driver, AdminLoginUI.ACCOUNT_FIELD);
        sendKeyToElement(driver, AdminLoginUI.ACCOUNT_FIELD, account);
    }

    public String welcomeText() {
        waitForElementVisible(driver, AdminLoginUI.MARK_TEXT);
        return getElementText(driver, AdminLoginUI.MARK_TEXT);
    }

    public String errorText() {
        waitForElementVisible(driver, AdminLoginUI.ERROR_TEXT);
        return getElementText(driver, AdminLoginUI.ERROR_TEXT);
    }

    public void clickToAccountTextbox() {
        clickToElement(driver,AdminLoginUI.ACCOUNT_FIELD);
    }
    public void clickToPasswordTextbox(){
        clickToElement(driver,AdminLoginUI.PASSWORD_FIELD);
    }

    public String getErrorMessageAtAccountTextbox() {
        waitForElementVisible(driver,AdminLoginUI.WARNING_MESSAGE1);
        return getElementText(driver,AdminLoginUI.WARNING_MESSAGE1 );
    }

    public String getErrorMessageAtPassworkTextbox() {
        waitForElementVisible(driver,AdminLoginUI.WARNING_MESSAGE2);
        return getElementText(driver,AdminLoginUI.WARNING_MESSAGE2);
    }

    public void clickToClosePopup() {
        waitForElementVisible(driver,AdminLoginUI.WRONG_ACCOUNT_POPUP);
        clickToElement(driver,AdminLoginUI.WRONG_ACCOUNT_POPUP);
    }
    public void verifySavePasswordButtonIsUnchecked() {
        waitForElementVisible(driver, NptLoginUI.SAVE_PASSWORD_CHECKBOX);
        WebElement savePasswordCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        assert !savePasswordCheckbox.isSelected();
    }

    public void verifyLoginButtonIsDisabled() {
        waitForElementVisible(driver,NptLoginUI.LOGIN_BUTTON);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='button']"));
        assert !loginButton.isEnabled();
    }
}
