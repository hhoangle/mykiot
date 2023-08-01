package NPT.NptPageObjects.NptPageUIs;

public class NptSalesOrderUI {
    public static final String CREATE_SALES_ORDER_BUTTON = "//button[contains(text(),'Tạo mới đơn bán hàng')]";
    public static final String CONTINUE_BUTTON = "//button[contains(text(),'Tiếp tục')]";
    public static final String CONFIRM_BUTTON = "//button[contains(text(),'Xác nhận đơn')]";
    public static final String WARNING_MESSAGE = "//p[contains(text(),'Vui lòng chọn CHTH')]";
    public static final String STORE_DROPDOWN_BUTTON = "//div[@class='multiselect__select']";
    public static final String STORE_NAME = "//ul[@id='listbox-null']/li[1]";
    public static final String SALE_ORDER_STATUS = "//div[@class='flex justify-between items-center']/button";
    public static final String VIEW_INVOICE_BUTTON = "//button[contains(text(),'Xem hoá đơn')]";
    public static final String ORDER_CODE = "//div[@class='flex justify-between items-center']/div/p[1]";
    public static final String ORDER_CODE_IN_INVOICE = "//p[@class='font-medium']/following-sibling::p[1]";
    public static final String WAIT_TO_CONFIRM_TAB = "//p[text()='Chờ phản hồi']";
    public static final String FIRST_ORDER = "//div[@class='infinite-scroll__container relative mb2 pb1']/div/div[1]/div/div[1]";
    public static final String CONFIRM_WAITING_ORDER_BUTTON = "//button[contains(text(),'Xác nhận')]";
    public static final String DECLINE_WAITING_ORDER_BUTTON = "//button[contains(text(),'Từ chối')]";
    public static final String DECLINE_REASON_DROPDOWN = "//div[@class='multiselect__select']";
    public static final String DECLINE_REASON_OPTION = "//li[4]/span/span";
    public static final String CONFIRM_DECLINE_BUTTON = "//div[@class='bg-white p-4 grid grid-cols-2 gap-3 w-full']/button[2]";
    public static final String DECLINE_REASON_IN_DETAIL_PAGE = "//div[@class='flex justify-between items-center mt-2']/p[2]";
    public static final String DECLINE_WARNING_POPUP = "//p[@class='pb-4 w-full text-center']";
    public static final String CLOSE_DECLINE_WARNING_POPUP_BUTTON = "//button[contains(text(),'Đóng lại')]";
}
