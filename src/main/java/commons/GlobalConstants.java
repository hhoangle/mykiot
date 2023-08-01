package commons;

import java.io.File;

public class GlobalConstants {
    public static final String ADMIN_LOGIN = "https://admintest.onkiot.com/";
    public static final String NPT_LOGIN = "https://npttest.onkiot.com/";
    public static String ADMIN_ACCOUNT = "adminqc";
    public static String ADMIN_PASSWORD = "admin@11";
    public static String NPT_ACCOUNT = "0984526455";
    public static String NPT_PASSWORD = "123456789";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String REPORT_NG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
    public static final int SHORT_TIMEOUT = 1;
    public static final int THREE_SECONDS = 3;
    public static final long FIVE_SECONDS = 5;
    public static final long LONG_TIMEOUT = 20;
}
