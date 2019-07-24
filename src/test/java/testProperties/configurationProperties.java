package testProperties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
            "        <p>Hi All,</p> \n" +
            "        <p></p>\n" +
            "        <p>Please see below for test report of sanity test:</p>\n" +
            "\n" +
            "<table style=\"width:100%\">\n" +
            "  <tr>\n" +
            "    <th>Test Environment</th>\n" +
            "    <th>Test result</th> ";



//    public SimpleDateFormat emailDatetime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            .format(new Date();
//    emailDatetime.setTimeZone(TimeZone.getTimeZone("UTC +7"));

//    ZoneOffset zoneOffSet= ZoneOffset.of("+02:00");

//    private SimpleDateFormat nowUTC = new SimpleDateFormat("dd/MMM/yy HH:mm:ss");
//    private Date nowDate = parser.parse(nowUTC);
//    private String now =  Calendar.getInstance().setTime(nowDate);
//    now.add(Calendar.HOUR_OF_DAY,7);
//
//    Calendar cal = Calendar.getInstance();
//    cal.add(Calendar.HOUR_OF_DAY, 10);
//    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//    System.out.println(dateFormat.format(cal.getTime()));

    LocalDateTime now = LocalDateTime.now();
//    LocalDateTime now = nowUTC.plusHours(7);
    public String currentDateTime = now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
    public String currentTime = now.format(DateTimeFormatter.ofPattern("MMddyyyy-HHmmss"));

    public String emailSubject = "SWN DA Monitoring - " + currentDateTime;


    public static String emailRecipients = "Steven.Nguyen@onsolve.com,Hoa.Luong@onsolve.com";
    public static String senderEmail = "DA.Alert@onsolve.com";//change with your sender email
    public static String senderPassword = "123abc$#@!";//change with your sender password
}