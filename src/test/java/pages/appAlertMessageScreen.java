package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import testProperties.app;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class appAlertMessageScreen {

    private static WindowsDriver DAClientSession = null;
    private static WindowsDriver DAClientSession3 = null;
//    private static WindowsDriver DAClientSession2 = null;

    public appAlertMessageScreen(WindowsDriver DAClientSession) {
        this.DAClientSession = DAClientSession;
    }

    public void switchToAlertScreen() throws Throwable {
        Thread.sleep(6000);
        DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
        desktopCapabilities.setCapability("platformName", "Windows");
        desktopCapabilities.setCapability("deviceName", "WindowsPC");
        desktopCapabilities.setCapability("app", "Root");

        // You get the desktop session
        WindowsDriver DesktopSession = new WindowsDriver(new URL("http://127.0.0.1:4723/"), desktopCapabilities);

        // Here you find the already running application and get the handle
        WebElement MAWebElement = DesktopSession.findElementByName("DesktopAlert");
        String MAWinHandleStr = MAWebElement.getAttribute("NativeWindowHandle");
        int MAWinHandleInt = Integer.parseInt(MAWinHandleStr);
        String MAWinHandleHex = Integer.toHexString(MAWinHandleInt);

        // You attach to the already running application
        DesiredCapabilities MACapabilities = new DesiredCapabilities();
        MACapabilities.setCapability("platformName", "Windows");
        MACapabilities.setCapability("deviceName", "WindowsPC");
        // You set the Handle as one of the capabilities
        MACapabilities.setCapability("appTopLevelWindow", MAWinHandleHex);

        // My Application Session
        DAClientSession3 = new WindowsDriver(new URL("http://127.0.0.1:4723/"), MACapabilities);
        DAClientSession3.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void clickButton(String Button) {
        switch(Button.toLowerCase()){
            case "mark as read":
                DAClientSession3.findElementByName(app.markAsReadButton).click();
                DAClientSession3.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                break;
            case "close":
                DAClientSession3.findElementByName(app.closeButton).click();
                DAClientSession3.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                break;
        }
    }
    public void checkMessageStatus(String alertStatus) {
        DAClientSession3.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String displayedStatus;

        switch (alertStatus.toLowerCase()) {
            case "read":
                displayedStatus = DAClientSession3.findElementByName(app.alertStatusRead).getText();
                Assert.assertEquals(displayedStatus,alertStatus);
                break;

            case "unread":
                displayedStatus = DAClientSession3.findElementByName(app.alertStatusUnread).getText();
                Assert.assertEquals(displayedStatus,alertStatus);
                break;
        }
    }
 }

