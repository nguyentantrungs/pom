package testProperties;

import java.text.SimpleDateFormat;
import java.util.Date;

public class configurationProperties {
    public static String daServerConfigFilePath = "C:\\\\Program Files\\\\OnSolve\\\\DAServer\\\\config.js";
    public static String testPath = "D:\\\\test.js";
    public static String daServiceName = "Desktop Alerting Server";
    public static String logFilePath = "C:\\Program Files\\OnSolve\\DAServer\\logs\\";
    public String logFileName = "da-server." + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".log";


}
