package AdminPageUIs;

public class AdminOrderUI {
    public static final String CREATE_ORDER_BUTTON = "//p[text()='Tạo đơn hàng mới']";
    public static final String SAVE_ORDER_BUTTON = "//button[@class='flex items-center text-sm rounded-lg font-medium py-2.5 px-4 bg-red text-white hover:bg-red-dark-1 focus:bg-red-light-1 bg-gray-light text-white justify-center cursor-no-drop']";
    public static final String ADD_COUNTERPARTY_BUTTON = "//span[text()='Chọn đối tác mua']";
    public static final String COUNTERPARTY_NAME = "//p[text()='Danh sách đối tác']/parent::div/div/div[1]";
    public static final String CONFIRM_COUNTERPARTY_BUTTON = "//p[text()='Xác nhận']";
    public static final String ADD_PRODUCT_BUTTON = "//div[contains(text(),'Thêm sản phẩm')]";
    public static final String PRODUCT_DROPDOWN_BUTTON = "//div[@class='multiselect__tags']";
    public static final String PRODUCT_OPTION = "//li[1]";
    public static final String CONFIRM_SELECT_PRODUCT_BUTTON = "//button/p[contains(text(),'Xác nhận')]";
    public static final String LOADER_ICON = "//div[@class='multiselect__spinner']";
    public static final String PRODUCT_LIST = "//ul[@id='listbox-null']";
    public static final String CANCEL_BUTTON = "//button/p[text()='Hủy bỏ']";
}
