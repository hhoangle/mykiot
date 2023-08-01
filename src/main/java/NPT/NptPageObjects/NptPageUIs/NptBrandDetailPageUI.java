package NPT.NptPageObjects.NptPageUIs;

public class NptBrandDetailPageUI {
    public static final String BRAND_NAME_IN_DETAIL_PAGE = "//p[text()='Tên thương hiệu']/following-sibling::p";
    public static final String CLASSIFICATION_IN_DETAIL_PAGE = "//p[text()='Phân loại']/following-sibling::p";
    public static final String EDIT_BRAND_INFO_BUTTON = "//button[contains(text(),'Chỉnh sửa thông tin thương hiệu')]";
    public static final String BRAND_DESCRIPTION_IN_DETAIL_PAGE = "//p[contains(text(),'Mô tả')]/following-sibling::p";
    public static final String BRAND_NAME_FIELD_IN_EDIT_PAGE = "//input[@placeholder='Nhập tên thương hiệu']";
    public static final String CURRENT_BRAND_NAME_IN_EDIT_PAGE = "//div[@class='flex items-center gap-2']/following-sibling::p";
    public static final String BRAND_DESCRIPTION_IN_EDIT_PAGE = "//textarea[@placeholder='Nhập mô tả']";
    public static final String SAVE_BUTTON_IN_EDIT_PAGE = "//button[contains(text(),'Lưu')][2]";
}
