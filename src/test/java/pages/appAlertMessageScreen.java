package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import testProperties.app;
import stepDefinition.teststeps;

import java.net.URL;
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
                alertScreenSession.findElementByName(app.markAsReadButton).click();
                alertScreenSession.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

                break;
            case "close":
                alertScreenSession.findElementByName(app.closeButton).click();
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
                displayedStatus = alertScreenSession.findElementByName(app.alertStatusRead).getText();
                Assert.assertEquals(displayedStatus, alertStatus);
                break;

            case "unread":
                displayedStatus = alertScreenSession.findElementByName(app.alertStatusUnread).getText();
                Assert.assertEquals(displayedStatus, alertStatus);
                break;
            }
        common.print("Message status is " + alertStatus);
    }
}

