package NPT.NptPageObjects.NptPageUIs;

public class NptLoginUI {
    public static final String ACCOUNT_FIELD = "//input[@type='number']";
    public static final String PASSWORD_FIELD = "//input[@type='password']";
    public static final String HIDE_SHOW_ICON = "//i[@class='v-icon eye-slash']";
    public static final String LOGIN_BUTTON = "//button[@type='button']";
    public static final String FORGOT_PASSWORD_BUTTON = "//p[contains(text(),'Quên mật khẩu?')]";
    public static final String WARNING_MESSAGE1 = "//div[@class='input__container mb-4']/p[@class='text-red text-xs']";
    public static final String WARNING_MESSAGE2 = "//div[@class='input__container']/p[@class='text-red text-xs']" ;
    public static final String WRONG_ACCOUNT_POPUP = "//div[@class='modal__content']//button[@type='button']";
    public static final String SAVE_PASSWORD_CHECKBOX = "//input[@type='checkbox']";
}
