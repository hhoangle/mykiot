package NPT.NptPageObjects.NptPageUIs;

public class NptCreateEmployeeUI {
    public static final String CREATE_EMPLOYEE_BUTTON = "//button[contains(text(),'Thêm mới nhân viên')]";
    public static final String INPUT_FIELD = "//input[@placeholder='%s']";
    public static final String POSITION_DROPDOWN = "//div[@class='multiselect__select']";
    public static final String POSITION_OPTION = "//div[@class='multiselect__content-wrapper']/ul/li[1]/span";
    public static final String ADD_ADDRESS_BUTTON = "//div[contains(text(),'Thêm địa chỉ')]";
    public static final String CITY = "//div[@class='mt-1 p-4 pb-4']/div/div[1]";
    public static final String DISTRICT = "//div[@class='mt-1 p-4 pb-4']/div/div[1]";
    public static final String WARD = "//div[@class='mt-1 p-4 pb-4']/div/div[1]";
    public static final String STREET = "//input[@name='street']";
    public static final String SAVE_ADDRESS_BUTTON = "//button[text()='Hoàn thành']";
    public static final String SAVE_BUTTON = "//button[contains(text(),'Tạo mới')]";
    public static final String WARNING_TEXT = "//p[text()='%s']";
}
