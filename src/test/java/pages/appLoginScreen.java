package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import testProperties.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class appLoginScreen {

    private static WindowsDriver DAClientSession = null;

    public appLoginScreen(WindowsDriver DAClientSession) {
        appLoginScreen.DAClientSession = DAClientSession;
    }

    public void inputCredentials(String appUserName, String appPassword) {
        DAClientSession.findElementByName(application.loginUsername).click();
        DAClientSession.findElementByName(application.loginUsername).sendKeys(Keys.CONTROL, "a");
        DAClientSession.findElementByName(application.loginUsername).sendKeys(Keys.BACK_SPACE);
        DAClientSession.findElementByName(application.loginUsername).sendKeys(appUserName);

        DAClientSession.findElementByName(application.loginPassword).sendKeys(Keys.CONTROL, "a");
        DAClientSession.findElementByName(application.loginPassword).sendKeys(Keys.BACK_SPACE);
        DAClientSession.findElementByName(application.loginPassword).sendKeys(appPassword);

        DAClientSession.findElementByName(application.loginButton).click();

        DAClientSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        common.print("Logged in DAClient with credentials: " + appUserName +"/" + appPassword);
    }

    public void checkErrorMessage(String errorMessage) {
        DAClientSession.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String displayedErrorMessage = DAClientSession.findElementByName(application.errorMessage).getText();
        Assert.assertEquals(errorMessage, displayedErrorMessage);
        common.print("Error message \"" + errorMessage + "\" is displayed");
    }

    public void checkIconColor(String iconColor) throws Throwable {
        Process process = Runtime.getRuntime().exec("cmd /C start /wait C:\\\\Test\\\\DAClient\\\\restartSystemTray.bat");
        process.waitFor();

        DesiredCapabilities capabilities2 = new DesiredCapabilities();
        capabilities2.setCapability("app", "Root");
        WindowsDriver DAClientSession2 = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities2);
        DAClientSession2.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        boolean iconPresent;
        try {
            DAClientSession2.findElementByName("OnSolve Desktop Alert");
            iconPresent = true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            iconPresent = false;
        }

        switch (iconColor) {
            case "red":
                Assert.assertEquals(iconPresent, true);
                common.print("DAClient icon color is red");
                break;
            case "blue":
                Assert.assertEquals(iconPresent, false);
                common.print("DAClient icon color is blue");
                break;
        }
    }
}

