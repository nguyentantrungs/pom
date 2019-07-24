package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;
import testProperties.*;

import java.util.concurrent.TimeUnit;

public class appAlertMessageScreen {

    WindowsDriver alertScreenSession;

    public appAlertMessageScreen(WindowsDriver alertScreenSession) {
        this.alertScreenSession = alertScreenSession;
    }

    public void switchToAlertScreen() throws Throwable {

    }

    public void clickButton(String Button) {
        switch (Button.toLowerCase()) {
            case "mark as read":
                alertScreenSession.findElementByName(application.markAsReadButton).click();
                alertScreenSession.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

                break;
            case "close":
                alertScreenSession.findElementByName(application.closeButton).click();
                alertScreenSession.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                break;
        }
        common.print("Clicked " + Button);
    }

    public void checkMessageStatus(String alertStatus) {
        alertScreenSession.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String displayedStatus;

        switch (alertStatus.toLowerCase()) {
            case "read":
                displayedStatus = alertScreenSession.findElementByName(application.alertStatusRead).getText();
                Assert.assertEquals(displayedStatus, alertStatus);
                break;

            case "unread":
                displayedStatus = alertScreenSession.findElementByName(application.alertStatusUnread).getText();
                Assert.assertEquals(displayedStatus, alertStatus);
                break;
        }
        common.print("Message status is " + alertStatus);
    }

    public void checkReceivedMessage() {
        String receivedMessage = alertScreenSession.findElementByName(sendMessage_Send.messageBody).getText();
        try {
            Assert.assertEquals(receivedMessage, sendMessage_Send.messageBody);
            common.print("Message received successfully");
        } catch (AssertionError e) {
            common.print("Message is not received proprely");
            throw e;
        }
    }
}

