package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import testProperties.app;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class appAlertMessageScreen {

    private static WindowsDriver DAClientSession = null;
//    private static WindowsDriver DAClientSession2 = null;

    public appAlertMessageScreen(WindowsDriver DAClientSession) {
        this.DAClientSession = DAClientSession;
    }

    public void clickButton(String Button) {
        switch(Button.toLowerCase()){
            case "mark as read":
                DAClientSession.findElementByName(app.markAsReadButton).click();
                DAClientSession.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                break;
            case "close":
                DAClientSession.findElementByName(app.closeButton).click();
                DAClientSession.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                break;
    }
    }
    public void checkMessageStatus(String alertStatus) {
        DAClientSession.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String displayedStatus;

        switch (alertStatus.toLowerCase()) {
            case "read":
                displayedStatus = DAClientSession.findElementByName(app.alertStatusRead).getText();
                Assert.assertEquals(displayedStatus,alertStatus);
                break;

            case "unread":
                displayedStatus = DAClientSession.findElementByName(app.alertStatusUnread).getText();
                Assert.assertEquals(displayedStatus,alertStatus);
                break;
        }
    }



    }

