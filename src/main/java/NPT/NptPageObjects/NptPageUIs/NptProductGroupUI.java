package NPT.NptPageObjects.NptPageUIs;

public class NptProductGroupUI {
    public static final String CREATE_PRODUCT_GROUP_BUTTON = "//button[contains(text(),'Tạo Nhóm sản phẩm')]";
    public static final String SAVE_BUTTON = "//div[@class='bg-white p-4 grid grid-cols-2 gap-3 box-shadow fixed left-0 bottom-0 w-full']/button[2]";
    public static final String WARNING_MESSAGE = "//p[text()='Vui lòng nhập đầy đủ thông tin']";
    public static final String CLOSE_WARNING_POPUP_BUTTON = "//button[contains(text(),'Đóng lại')]";
    public static final String PRODUCT_GROUP_NAME_FIELD = "//input[@placeholder='Nhập tên nhóm sản phẩm']";
    public static final String PRODUCT_CATEGORY_DROPDOWN = "//div[@role='combobox']";
    public static final String PRODUCT_CATEGORY_NAME = "//div[@class='multiselect multiselect--active']/div[3]/ul/li[1]";
    public static final String PRODUCT_GROUP_DESCRIPTION_FIELD = "//input[@placeholder='Nhập mô tả']";
    public static final String SELECTED_PRODUCT_CATEGORY = "//div[@class='multiselect__tags']/span";
    public static final String ADD_PRODUCT_BUTTON = "//button[contains(text(),'Thêm sản phẩm')]";
}
