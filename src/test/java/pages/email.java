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

//    public static class Array{
//        List<String>
//    }

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

    public String parseJSON() throws IOException {
        String internalScenarioStatus = "Passed";

        Path path = Paths.get("target/cucumber.json");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(0,"");
        lines.set(lines.size()-1,"");
        Files.write(path, lines, StandardCharsets.UTF_8);

        Reader reader = new FileReader("target/cucumber.json");
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
        }


        String testResult = "";
        for (int k = 0; k < scenarioName.size(); k++) {
            testResult = testResult + "<tr><td>" + scenarioName.get(k) + "</td><td>" + scenarioStatus.get(k) + "</tr>";
        }
        testResult = testResult + "</tr>";
        String emailBody = configurationProperties.emailHeader + testResult;
        return emailBody;
    }


    public static void main() throws MessagingException, IOException {
        email email = new email();
        configurationProperties configurationProperties = new configurationProperties();
        email.sendAsHtml(configurationProperties.emailRecipients, configurationProperties.emailSubject + " - " + testStatus, email.parseJSON());
    }
}

