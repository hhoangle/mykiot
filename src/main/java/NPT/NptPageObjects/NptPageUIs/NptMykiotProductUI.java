package NPT.NptPageObjects.NptPageUIs;

public class NptMykiotProductUI {
    public static final String MYKIOT_PRODUCT = "//div[@class='grid grid-cols-2 gap-3']/div[1]";
    public static final String CART_BUTTON = "//button[1]";
    public static final String ADD_PRODUCT_BUTTON = "//div[@class='px-3 py-2 bg-white flex items-center gap-5 rounded-lg']/div/following-sibling::div";
    public static final String ADD_TO_CART_BUTTON = "//button[contains(text(),'Thêm vào giỏ hàng')]";
    public static final String AMOUNT_ADDED = "//p[text()='Số lượng ']/following-sibling::div/p";
    public static final String CART_DETAIL_BUTTON = "//div[@class='relative']";
    public static final String CART_CHECKBOX = "//input[@class='primary stick']";
    public static final String ADD_AMOUNT_ITEM = "//p[@class='text-gray-dark']";
    public static final String CONTINUE_BUTTON = "//button[contains(text(),'Tiếp tục')]";
    public static final String CONFIRM_ORDER_BUTTON = "//button[contains(text(),'Xác nhận đơn')]";
    public static final String UNIT_PRICE = "//p[text()='Giá bán ']/following-sibling::p";
    public static final String UNIT_PRICE_IN_CART_PAGE = "//div[@class='flex gap-2']//p";
    public static final String TOTAL_PRICE_IN_CART_PAGE = "//div[@class='flex justify-between items-center mb-4']/p[2]";
    public static final String TOTAL_PRICE_IN_CONFIRM_ORDER_PAGE = "//p[text()='Tổng tiền']/following-sibling::p";
    public static final String TOTAL_PRICE_IN_DETAIL_ORDER = "//p[text()='Tổng cộng']/following-sibling::p";
    public static final String REMOVE_ITEM_BUTTON = "//div[@class='mb-4'][1]/div/div/div/div/following-sibling::div[2]/div/div";
    public static final String EMPTY_CART_WARNING_MESSAGE = "//p[@class='text-gray-dark italic text-center pt-4']";
}
