package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import testProperties.app;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class appLoginScreen {

    private static WindowsDriver DAClientSession = null;
    private static WindowsDriver DAClientSession2 = null;

    public appLoginScreen(WindowsDriver DAClientSession) {
        this.DAClientSession = DAClientSession;
    }

    public void inputCredentials(String appUserName, String appPassword) {
        DAClientSession.findElementByName(app.loginUsername).click();
        DAClientSession.findElementByName(app.loginUsername).sendKeys(Keys.CONTROL, "a");
        DAClientSession.findElementByName(app.loginUsername).sendKeys(Keys.BACK_SPACE);
        DAClientSession.findElementByName(app.loginUsername).sendKeys(appUserName);

        DAClientSession.findElementByName(app.loginPassword).sendKeys(Keys.CONTROL, "a");
        DAClientSession.findElementByName(app.loginPassword).sendKeys(Keys.BACK_SPACE);
        DAClientSession.findElementByName(app.loginPassword).sendKeys(appPassword);

        DAClientSession.findElementByName(app.loginButton).click();

        DAClientSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public void checkErrorMessage(String errorMessage){
        DAClientSession.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String displayedErrorMessage = DAClientSession.findElementByName(app.errorMessage).getText();
        Assert.assertEquals(errorMessage, displayedErrorMessage);
        }

     public void checkIconColor (String iconColor) throws Throwable{
         DesiredCapabilities capabilities2 = new DesiredCapabilities();
         capabilities2.setCapability("app", "Root");
         DAClientSession2 = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities2);
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
                 break;
             case "blue":
                 Assert.assertEquals(iconPresent, false);
                 break;
         }
     }
    }

