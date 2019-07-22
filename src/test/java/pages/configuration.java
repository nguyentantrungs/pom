package pages;

import groovy.transform.ToString;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


import org.junit.Assert;
import testProperties.configurationProperties;
//import org.json.JSONException;
//import org.json.JSONObject;

public class configuration {
//    public static void updateAPIKey() throws IOException {
//        File file = new File(configurationProperties.testPath);
//        String fileContext = FileUtils.readFileToString(file);
//        fileContext = fileContext.replaceAll("apiKey", "apikey1");
//        FileUtils.write(file, fileContext);
//    }

    public static void setAPIKey(String apiKey) throws IOException {
        Path path = Paths.get(configurationProperties.daServerConfigFilePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(7, "        apiKey:" + "'" + apiKey + "'");
        Files.write(path, lines, StandardCharsets.UTF_8);

    }

    public static void setDABroker(String daBroker) throws IOException {
        Path path = Paths.get(configurationProperties.daServerConfigFilePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(22, "        endpoint:" + "'" + daBroker + "'");
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public static void restartDAServer() throws IOException, InterruptedException {
        String LogFilePath = configurationProperties.logFilePath;
        configurationProperties configurationProperties = new configurationProperties();
        String LogFileName = configurationProperties.logFileName;
//        File f = new File(LogFilePath+LogFileName);
//        if(f.exists() && !f.isDirectory()) {
//            boolean renameResult = f.renameTo((new File(LogFileName + "_old")));
//            System.out.print(renameResult);
//        }
        Path f = Paths.get(LogFilePath + LogFileName);
        if (Files.exists(f)) {
            Files.move(f, f.resolveSibling(LogFileName + "_old_" + new SimpleDateFormat("HHmmss").format(new Date())));
//        File file = new File(LogFilePath + LogFileName);
//        boolean fileIsNotLocked = file.renameTo(file);
        }

//            Runtime.getRuntime().exec("cmd /C start D:\\\\restartDAServer.bat");
            Process process = Runtime.getRuntime().exec("cmd /C start /wait C:\\\\Test\\\\DAClient\\\\restartDAServer.bat");
            process.waitFor();
//                    Thread.sleep(10000);
    }

    public static void readLogsFile() throws IOException, InterruptedException {
        String LogFilePath = configurationProperties.logFilePath;
        configurationProperties configurationProperties = new configurationProperties();
        String LogFileName = configurationProperties.logFileName;
        BufferedReader input = new BufferedReader(new FileReader(LogFilePath + LogFileName));
        String last = "", line;

        while ((line = input.readLine()) != null) {
            last = line;
        }
        try {
            Assert.assertTrue(last.contains("Join channel"));
            Assert.assertTrue(last.contains("successfully"));
        }
        catch (AssertionError exception){
            common.print("DAServer doesn't join channel successfully");
            common.print("Last line of logs: \n " + last);
            throw (exception);
        }
        input.close();
        common.print(last);
    }

    public static void stopDAServer() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /C start D:\\\\stopDAServer.bat");
        Process process = Runtime.getRuntime().exec("cmd /C start /wait C:\\\\Test\\\\DAClient\\\\stopDAServer.bat");
        process.waitFor();
    }
}
