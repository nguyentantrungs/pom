package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;

public class messageHistory {
    WebDriver webDriver;

    public messageHistory(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkMessageStatus(){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 30);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.firstMessage)));
        WebWait.until(ExpectedConditions.elementToBeClickable(By.xpath(web.firstMessage)));
        webDriver.findElement(By.xpath(web.firstMessage)).click();

        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageHistoryLoadingScreen)));
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.deliveryStatusTab)));
        WebWait.until(ExpectedConditions.elementToBeClickable(By.xpath(web.deliveryStatusTab)));
        webDriver.findElement(By.xpath(web.deliveryStatusTab)).click();

        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageStatus)));
        String messageStatus = webDriver.findElement(By.xpath(web.messageStatus)).getText();
        try {
            Assert.assertTrue(messageStatus.equals("Delivered to DA Server") || messageStatus.equals("Message Sent") || messageStatus.equals("Message Displayed")|| messageStatus.equals("Message Received"));
            common.print("Message is delivered properly, status: " + messageStatus);
        } catch (AssertionError e){
            common.print("Message is NOT delivered properly, current status: " + messageStatus);
            throw e;
        }
    }

}
