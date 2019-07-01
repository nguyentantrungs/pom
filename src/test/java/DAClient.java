//******************************************************************************
//
// Copyright (c) 2016 Microsoft Corporation. All rights reserved.
//
// This code is licensed under the MIT License (MIT).
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
//
//******************************************************************************

import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;

public class DAClient {

    private static WindowsDriver DAClientSession = null;
//    private static WebElement CalculatorResult = null;

    @BeforeClass
    public static void setup() throws Exception {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Program Files (x86)\\DesktopAlert\\app\\DesktopAlert.exe");
            DAClientSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            DAClientSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//            CalculatorResult = DAClientSession.findElementByName("Username");
//            CalculatorResult = 1;
//            Assert.assertNotNull(CalculatorResult);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }



//    @AfterClass
//    public static void TearDown()
//    {
////        CalculatorResult = null;
//        if (DAClientSession != null) {
//            DAClientSession.quit();
//        }
//        DAClientSession = null;
//    }

    @Test
    public void Addition()
    {
        DAClientSession.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DAClientSession.findElementByName("Username").click();
        DAClientSession.findElementByName("Username").sendKeys(Keys.CONTROL, "a");
        DAClientSession.findElementByName("Username").sendKeys(Keys.BACK_SPACE);
        DAClientSession.findElementByName("Username").sendKeys("1123");
        DAClientSession.findElementByName("Password").sendKeys(Keys.CONTROL, "a");
        DAClientSession.findElementByName("Password").sendKeys(Keys.BACK_SPACE);
        DAClientSession.findElementByName("Password").sendKeys("abcd1234");
        DAClientSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        DAClientSession.findElementByName("SIGN IN").click();

        String errorMessage = DAClientSession.findElementByName("Invalid username or password. Try again.").getText();
        Assert.assertEquals("Invalid username or password. Try again.", errorMessage);

        DAClientSession.findElementByName("Username").sendKeys(Keys.CONTROL, "a");
        DAClientSession.findElementByName("Username").sendKeys(Keys.BACK_SPACE);
        DAClientSession.findElementByName("Username").sendKeys("steven.nguyen");
        DAClientSession.findElementByName("Password").sendKeys(Keys.CONTROL, "a");
        DAClientSession.findElementByName("Password").sendKeys(Keys.BACK_SPACE);
        DAClientSession.findElementByName("Password").sendKeys("abcd1234");
        DAClientSession.findElementByName("SIGN IN").click();

    }



//    protected String _GetCalculatorResultText()
//    {
//        // trim extra text and whitespace off of the display value
//        return CalculatorResult.getText().replace("Display is", "").trim();
//    }

}