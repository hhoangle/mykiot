package NPT.NptPageObjects.NptPageUIs;

public class NptCreateGroceryStoreUI {
    public static final String ADD_GROCERY_STORE_BUTTON = "//button[contains(text(),'Thêm mới CHTH')]";
    public static final String BUSINESS_TYPE_DROP_DOWN = "//div[@class='multiselect__select']";
    public static final String BUSINESS_TYPE_OPTION = "//div[@class='multiselect__content-wrapper']/ul/li[3]";
    public static final String OPEN_TIME_FIELD = "//p[text()='Giờ mở cửa']/parent::div";
    public static final String OPEN_TIME_DROPDOWN = "//div[@class='vc-select'][1]";
    public static final String OPEN_TIME_OPTIONS = "//div[@class='vc-select'][1]/select/option[1]";
    public static final String OPEN_TIME_OPTIONS_LIST = "//div[@class='vc-select'][1]/select";
    public static final String CLOSE_TIME_FIELD = "//p[text()='Giờ đóng cửa']/parent::div";
    public static final String CLOSE_TIME_OPTIONS = "//div[@class='vc-select'][1]/select/option[5]";
    public static final String CLOSE_TIME_DROPDOWN = "//div[@class='vc-select'][1]/select";
    public static final String CLOSE_TIME_OPTIONS_LIST = "//div[@class='vc-select'][1]/select";
    public static final String SAVE_GROCERY_BUTTON = "//button[@class='w-full flex items-center text-sm rounded-lg font-medium py-2.5 px-4 bg-red text-white hover:bg-red-dark-1 focus:bg-red-light-1 justify-center']/span[text()='Lưu lại']";
}