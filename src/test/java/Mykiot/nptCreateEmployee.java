package Mykiot;

import NPT.NptPageObjects.*;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static commons.GlobalConstants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class nptCreateEmployee extends BaseTest {
    WebDriver driver;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptCreateEmployeePageObject nptCreateEmployeePageObject;
    private String employeeName, employeeEmail,incorrectEmailForm, passWord,employeeNameField,employeePhoneNumberField,employeePhoneNumber,
            passWordField,employeeEmailField,
            addressErrorMessage, positionErrorMessage,passWordErrorMessage,emailErrorMessage;
    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);
        employeeName = "Nguyễn Văn A";
        employeeNameField = "Nhập tên nhân viên";
        employeePhoneNumber = nptHomePage.generateRandomPhoneNumber();
        employeePhoneNumberField = "Nhập số điện thoại";
        employeeEmail = "nguyenvana@yopmail.com";
        incorrectEmailForm = "mail";
        employeeEmailField = "Nhập email";
        passWord = "123456789";
        passWordField = "Nhập mật khẩu";
        addressErrorMessage = "Vui lòng nhập địa chỉ";
        positionErrorMessage = "Vui lòng chọn chức vụ";
        passWordErrorMessage = "Vui lòng nhập mật khẩu.";
        emailErrorMessage = "Vui lòng nhập đúng định dạng email";
    }
    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }
    @Test
    public void TC_01_Create_Employee(){
        goToHomePage();
        nptCreateEmployeePageObject = nptHomePage.clickToManageEmployee();
        nptCreateEmployeePageObject.clickToCreateEmployeeButton();
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeName,employeeNameField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeePhoneNumber,employeePhoneNumberField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeEmail,employeeEmailField);
        nptCreateEmployeePageObject.insertEmployeeInfor(passWord,passWordField);
        nptCreateEmployeePageObject.selectPosition();
        nptCreateEmployeePageObject.selectAddress();
        nptCreateEmployeePageObject.clickSaveButton();
    }
    @Test
    public void TC_02_Create_Empployee_Without_Input_Any_Field(){
        goToHomePage();
        nptCreateEmployeePageObject = nptHomePage.clickToManageEmployee();
        nptCreateEmployeePageObject.clickToCreateEmployeeButton();
        Assert.assertFalse(nptCreateEmployeePageObject.isSaveButtonEnabled());
    }
    @Test
    public void TC_03_Create_Employee_Without_Input_Address(){
        goToHomePage();
        nptCreateEmployeePageObject = nptHomePage.clickToManageEmployee();
        nptCreateEmployeePageObject.clickToCreateEmployeeButton();
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeName,employeeNameField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeePhoneNumber,employeePhoneNumberField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeEmail,employeeEmailField);
        nptCreateEmployeePageObject.insertEmployeeInfor(passWord,passWordField);
        nptCreateEmployeePageObject.selectPosition();
        nptCreateEmployeePageObject.clickSaveButton();
        assertEquals(nptCreateEmployeePageObject.getErrorMessage(addressErrorMessage),addressErrorMessage);
    }
    @Test
    public void TC_04_Create_Employee_Without_Input_Position(){
        goToHomePage();
        nptCreateEmployeePageObject = nptHomePage.clickToManageEmployee();
        nptCreateEmployeePageObject.clickToCreateEmployeeButton();
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeName,employeeNameField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeePhoneNumber,employeePhoneNumberField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeEmail,employeeEmailField);
        nptCreateEmployeePageObject.insertEmployeeInfor(passWord,passWordField);
        nptCreateEmployeePageObject.selectAddress();
        nptCreateEmployeePageObject.clickSaveButton();
        assertEquals(nptCreateEmployeePageObject.getErrorMessage(positionErrorMessage),positionErrorMessage);
    }
    @Test
    public void TC_05_Create_Employee_With_Incorrect_Email(){
        goToHomePage();
        nptCreateEmployeePageObject = nptHomePage.clickToManageEmployee();
        nptCreateEmployeePageObject.clickToCreateEmployeeButton();
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeName,employeeNameField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeePhoneNumber,employeePhoneNumberField);
        nptCreateEmployeePageObject.insertEmployeeInfor(incorrectEmailForm,employeeEmailField);
        nptCreateEmployeePageObject.insertEmployeeInfor(passWord,passWordField);
        nptCreateEmployeePageObject.selectPosition();
        nptCreateEmployeePageObject.selectAddress();
        nptCreateEmployeePageObject.clickSaveButton();
        assertEquals(nptCreateEmployeePageObject.getErrorMessage(emailErrorMessage),emailErrorMessage);
    }
    @Test
    public void TC_06_Create_Employee_Without_Password(){
        goToHomePage();
        nptCreateEmployeePageObject = nptHomePage.clickToManageEmployee();
        nptCreateEmployeePageObject.clickToCreateEmployeeButton();
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeName,employeeNameField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeePhoneNumber,employeePhoneNumberField);
        nptCreateEmployeePageObject.insertEmployeeInfor(employeeEmail,employeeEmailField);
        nptCreateEmployeePageObject.selectPosition();
        nptCreateEmployeePageObject.selectAddress();
        nptCreateEmployeePageObject.clickSaveButton();
        assertEquals(nptCreateEmployeePageObject.getErrorMessage(passWordErrorMessage),passWordErrorMessage);
    }
    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
