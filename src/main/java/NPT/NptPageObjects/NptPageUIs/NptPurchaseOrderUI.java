package NPT.NptPageObjects.NptPageUIs;

public class NptPurchaseOrderUI {
    public static final String CREATE_PURCHASE_ORDER_BUTTON = "//button[contains(text(),'Tạo mới đơn đặt hàng')]";
    public static final String CONTINUE_BUTTON = "//button[contains(text(),'Tiếp tục')]";
    public static final String WARNING_MESSAGE_TEXT = "//div[@class='popup__body bg-white rounded-lg p-4 flex flex-col items-center']/p[2]";
    public static final String CLOSE_WARNING_POPUP_BUTTON = "//button[contains(text(),'Đóng lại')]";
    public static final String ORDER_NOTE_FIELD = "//input[@placeholder='Nhập ghi chú']";
    public static final String CONFIRM_PURCHASE_ORDER = "//button[contains(text(),'Xác nhận đơn')]";
    public static final String PURCHASE_ORDER_STATUS = "//div[@class='flex justify-between items-center']/button";
    public static final String CONFIRMED_SUB_TAB = "//button/p[text()='Đã xác nhận']";
    public static final String FIRST_ORDER_IN_CONFIRMER_SUB_TAB = "//div[@class='infinite-scroll__container relative mb2 pb1']/div[1]";
    public static final String CONFIRM_OF_DELIVERY_BUTTON = "//div[@class='flex gap-2 bg-white p-4 box-shadow fixed left-0 bottom-0 w-full']/button[2]";
    public static final String DENY_DELIVERY_BUTTON = "//div[@class='flex gap-2 bg-white p-4 box-shadow fixed left-0 bottom-0 w-full']/button[1]";
    public static final String CONFIRM_DENY_BUTTON = "//div[@class='bg-white p-4 grid grid-cols-2 gap-3 w-full']/button[2]";
    public static final String DECLINE_WARNING_POPUP = "//p[@class='pb-4 w-full text-center']";
    public static final String DYNAMIC_SUBTAB = "//div[@class='tab flex gap-2 mb-5 overflow-x-auto']//p[text()='%s']";
    public static final String STATUS_TAG = "//div[@class='flex justify-between items-center']//button";
    public static final String DYNAMIC_ORDER_FROM_TAB = "//div[@class='bg-white p-4 flex items-center gap-4']/p[text()='%s']";
    public static final String ORDER_TYPE_TAG = "//p[text()='Loại đơn hàng']/following-sibling::p";
}
