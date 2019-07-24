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

    public void checkMessageStatus() throws InterruptedException {
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageHistoryLoadingScreen)));
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.firstMessage)));
        WebWait.until(ExpectedConditions.elementToBeClickable(By.xpath(web.firstMessage)));
        long endTime = System.currentTimeMillis() + 15000 ;
        while (System.currentTimeMillis() < endTime) {
            if (webDriver.findElement(By.xpath(web.firstMessage)).getText().equals(sendMessage_Send.messageBody)) {
                webDriver.findElement(By.xpath(web.firstMessage)).click();
                break;
            } else {
                Thread.sleep(2000);
            }
        }

        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageHistoryDetailLoadingScreen)));
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.deliveryStatusTab)));
        WebWait.until(ExpectedConditions.elementToBeClickable(By.xpath(web.deliveryStatusTab)));
        webDriver.findElement(By.xpath(web.deliveryStatusTab)).click();

        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageStatus)));
        Thread.sleep(1000);
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
