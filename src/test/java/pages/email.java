package pages;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.google.gson.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gherkin.formatter.model.Step;
import org.apache.commons.io.FileUtils;
import testProperties.configurationProperties;

public class email {

    public static void sendAsHtml(String to, String title, String html) throws MessagingException {
//        System.out.println("Sending email to " + to);

        Session session = createSession();

        //create message using session
        MimeMessage message = new MimeMessage(session);
        prepareEmailMessage(message, to, title, html);

        //sending message
        Transport.send(message);
    }

    private static void prepareEmailMessage(MimeMessage message, String to, String title, String html)
            throws MessagingException {
        message.setContent(html, "text/html; charset=utf-8");
        message.setFrom(new InternetAddress(configurationProperties.senderEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(title);
    }

    private static Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");//Outgoing server requires authentication
        props.put("mail.smtp.starttls.enable", "true");//TLS must be activated
        props.put("mail.smtp.host", "smtp.office365.com"); //Outgoing server (SMTP) - change it to your SMTP server
        props.put("mail.smtp.port", "587");//Outgoing port


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(configurationProperties.senderEmail, configurationProperties.senderPassword);
            }
        });
        return session;
    }

    public static class Report {
        List<Elements> elements;
    }

    public class Elements {
        String name;
        List<Steps> steps;
    }

    public class Steps {
        Result result;
        String name;
    }

    public class Result {
        String status;
    }

    public List scenarioName = new ArrayList();
    public ArrayList<ArrayList<String>> stepStatus = new ArrayList<>();
    public List scenarioStatus = new ArrayList();
    public static String testStatus = "Passed";

//    public void moveReportFiles() throws IOException {
//        File source = new File("C:\\\\Test\\\\DAClient\\\\target");
//        configurationProperties configurationProperties = new configurationProperties();
//        String targetPath = "C:\\\\Test\\\\Report\\\\" + configurationProperties.currentTime;
//        File target = new File(targetPath);
//        FileUtils.copyDirectory(source,target);
//    }

    public static String folderName;
    public String parseJSON() throws IOException, InterruptedException {
        File source = new File("C:\\\\Test\\\\Report\\\\temp");
        configurationProperties configurationProperties = new configurationProperties();
        folderName = configurationProperties.currentTime;
        String targetPath = "C:\\\\Test\\\\Report\\\\" + folderName;
        File target = new File(targetPath);
        FileUtils.copyDirectory(source,target);

        String internalScenarioStatus = "Passed";

        Path path = Paths.get(targetPath +"\\\\cucumber.json");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            lines.set(0, "");
            lines.set(lines.size()-1,"");

        Files.write(path, lines, StandardCharsets.UTF_8);

        Reader reader = new FileReader(targetPath +"\\\\cucumber.json");
        Gson gson = new Gson();
        Report report = gson.fromJson(reader, Report.class);
        List<Elements> elements = report.elements;

        //Loop through all scenario
        for (int i = 0; i < elements.size(); i++) {
            scenarioName.add(elements.get(i).name);

            //Loop though all step of each scenario
            List<Steps> steps = report.elements.get(i).steps;

            for (int j = 0; j < steps.size(); j++) {
                stepStatus.add(new ArrayList());
                stepStatus.get(i).add(steps.get(j).result.status);
                if (!steps.get(j).result.status.equalsIgnoreCase("passed")) {
                    internalScenarioStatus = "Failed";
                    testStatus = "Failed";
                }
            }
            scenarioStatus.add(internalScenarioStatus);
            internalScenarioStatus = "Passed";
        }



        String testResult = "";
        for (int k = 0; k < scenarioName.size(); k++) {
            testResult = testResult + "<tr><td>" + scenarioName.get(k) + "</td>";
            if (scenarioStatus.get(k).equals("Passed")){
                testResult = testResult + "<td style='background-color:Green;text-align:center'><b>" + scenarioStatus.get(k) + "</b></td></tr>";
        } else {
                testResult = testResult + "<td style='background-color:Red;text-align:center'><b>" + scenarioStatus.get(k) + "</b></td></tr>";
            }
        }
        testResult = testResult + "</tr></table><p> </p>";
        String emailBody = configurationProperties.emailHeader + testResult;
        return emailBody;
    }


    public static void main() throws MessagingException, IOException, InterruptedException {
        email email = new email();
        String body = email.parseJSON();
        String emailFooter = "<p>Detail report can be found at following link http://da-autotest-report.southeastasia.cloudapp.azure.com/" + folderName +"/cucumber-report-html/cucumber-html-reports/src-test-java-features-test-feature.html</p>" ;
        configurationProperties configurationProperties = new configurationProperties();
        email.sendAsHtml(configurationProperties.emailRecipients, configurationProperties.emailSubject + " - " + testStatus,body+emailFooter);
    }
}

