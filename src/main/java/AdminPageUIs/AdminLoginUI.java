package AdminPageUIs;

public class AdminLoginUI {
    public static final String LOGIN_BUTTON = "//span[contains(text(),'Đăng nhập')]";
    public static final String PASSWORD_FIELD = "//input[@type='password']" ;

    public static final String ACCOUNT_FIELD = "//input[@type='text']";

    public static final String MARK_TEXT = "//p[@class='text-2xl font-bold']";
    public static final String ERROR_TEXT = "//div[@class='modal__content']//p[contains(text(),'Sai tên hoặc sai mật khẩu hoặc hệ thống')]";
    public static final String WARNING_MESSAGE1 = "//div[@class='input__container mb-4']/p[@class='text-red text-xs']";
    public static final String WARNING_MESSAGE2 = "//div[@class='input__container']//p[contains(text(),'Bạn cần điền vào mục này')]";
    public static final String WRONG_ACCOUNT_POPUP = "//div[@class='modal__content']//button[@type='button']";
}
