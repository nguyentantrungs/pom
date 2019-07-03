package pages;

import org.openqa.selenium.By;
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

    public void inputEmailInfo() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String current_date = dateFormat.format(date);
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);

        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageSubject)));

        webDriver.findElement(By.xpath(web.messageSubject)).sendKeys(" " + current_date);
        webDriver.findElement(By.xpath(web.messageBody)).sendKeys("This message is sent at " + current_date);
        common.print("Inputted message subject and body");
    }
}
