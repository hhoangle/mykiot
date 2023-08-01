package NPT.NptPageObjects.NptPageUIs;

public class NptCategoryPageUI {
    public static final String CREATE_BRAND_BUTTON = "//button[contains(text(),'Tạo Thương hiệu')]";
    public static final String BRAND_NAME_FIELD = "//input[@placeholder='Nhập tên thương hiệu']";
    public static final String SAVE_BRAND_BUTTON = " //button[contains(text(),'Lưu')][2]";
    public static final String WARNING_MESSAGE = "//p[text()='Vui lòng nhập đầy đủ thông tin']";
    public static final String CLOSE_WARNING_POPUP_BUTTON = "//button[contains(text(),'Đóng lại')]";
    public static final String ADD_PRODUCT_TO_BRAND_BUTTON = "//button[contains(text(),'Thêm sản phẩm')]";
    public static final String CONFIRM_SELECT_PRODUCT_BUTTON = "//button[contains(text(),'Xác nhận')]";
    public static final String BURGER_MENU = "//button[@class='p-0 bg-gray-light-1 flex items-center text-sm rounded-lg font-medium p-0 button--secondary border-solid bg-gray-light text-black justify-center']";
    public static final String CATEGORY_BUTTON = "//div[contains(text(),'Ngành hàng')]";
    public static final String CREATE_CATEGORY_BUTTON = "//button[contains(text(),'Tạo Ngành hàng')]";
    public static final String PRODUCT_CATEGORY_NAME_FIELD = "//input[@placeholder='Nhập tên ngành hàng']";
    public static final String SAVE_PRODUCT_CATEGORY_BUTTON = "//button[contains(text(),'Lưu')][2]";
    public static final String BRAND_DESCRIPTION_FIELD = "//textarea[@placeholder='Nhập mô tả']";
    public static final String PRODUCT_CATEGORY_DESCRIPTION_FIELD = "//textarea[@placeholder='Nhập mô tả']";
    public static final String PRODUCT_GROUP_BUTTON = "//div[contains(text(),'Nhóm sản phẩm')]";
}
