package testProperties;

import java.text.SimpleDateFormat;
import java.util.Date;

public class configurationProperties {
    public static String daServerConfigFilePath = "C:\\\\Program Files\\\\OnSolve\\\\DAServer\\\\config.js";
    public static String testPath = "D:\\\\test.js";
    public static String daServiceName = "Desktop Alerting Server";
    public static String logFilePath = "C:\\Program Files\\OnSolve\\DAServer\\logs\\";
    public String logFileName = "da-server." + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".log";

    public static String emailHeader = "<head>\n" +
            "<style>\n" +
            "\n" +
            "table, th, td {\n" +
            "  border-collapse: collapse;\n" +
            "border: 1px solid black;\n" +
            "\n" +
            "}\n" +
            "</style>\n" +
            "</head>\n" +
            "\n" +
            "        <p>Hi All</p> \n" +
            "        <p></p>\n" +
            "        <p>Please see below for test report of sanity test</p>\n" +
            "\n" +
            "<table style=\"width:100%\">\n" +
            "  <tr>\n" +
            "    <th>Test Environment</th>\n" +
            "    <th>Test result</th> ";

    public String emailSubject = "SWN DA Monitoring - " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    public static String emailRecipients = "Steven.Nguyen@onsolve.com";
    public static String senderEmail = "DA.Alert@onsolve.com";//change with your sender email
    public static String senderPassword = "123abc$#@!";//change with your sender password
}