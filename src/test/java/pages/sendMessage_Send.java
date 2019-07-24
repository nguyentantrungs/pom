package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sendMessage_Send {

    WebDriver webDriver;

    public sendMessage_Send(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static String messageBody;
    public void inputEmailInfo() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String current_date = dateFormat.format(date);
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);

        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageSubjectNew)));

        webDriver.findElement(By.xpath(web.messageSubjectNew)).sendKeys(" " + current_date);

        messageBody = "This message is sent at " + current_date;
        webDriver.findElement(By.xpath(web.messageBodynew)).sendKeys(messageBody);

        common.print("Inputted message subject and body");
    }

    public void inputDuration(String hour, String minute){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 10);

        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageDurationHour)));
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageDurationMinute)));
        webDriver.findElement(By.xpath(web.messageDurationHour)).sendKeys(Keys.CONTROL, "a");
        webDriver.findElement(By.xpath(web.messageDurationHour)).sendKeys(hour);
        webDriver.findElement(By.xpath(web.messageDurationMinute)).sendKeys(minute);
    }
}
