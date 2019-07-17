package stepDefinition;

//========================================================

import cucumber.api.PendingException;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.Before;
import cucumber.api.java.After;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.net.URL;

import io.appium.java_client.windows.WindowsDriver;

import pages.*;

import testProperties.web;
import testProperties.app;

//========================================================

public class teststeps {

    private WebDriver webDriver;
    private WindowsDriver DAClientSession;
    private WindowsDriver taskbarSession;
    private appLoginScreen appLoginScreen;
    private appAlertMessageScreen appAlertMessageScreen;


    @Before
    public void Before(Scenario scenario) {
        pages.common.print("==================== START SCENARIO: " + scenario.getName() + " ====================================================");
    }

    @After
    public void killBrowser(Scenario scenario) throws Throwable{
        pages.common.print("==================== END SCENARIO: " + scenario.getName() + " =====================================================");
        if (webDriver != null) {
            if (scenario.isFailed()) {
                scenario.embed(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES), "image/png");
                Runtime.getRuntime().exec("cmd /C start D:\\killDA.bat");
                pages.common.print("DAClient closed successfully");
            }
            webDriver.quit();
            pages.common.print("Browser closed successfully");
        }
    }

    @Given("^I open DAClient$")
    public void i_open_DAClient() throws Throwable {
        Runtime.getRuntime().exec("cmd /C start D:\\killDA.bat");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", app.appPath);
        DAClientSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        DAClientSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        pages.common.print("DAClient is opened successfully");
    }

    @When("^I input following credentials to DAClient$")
    public void i_input_following_credentials_to_daclient(DataTable dt) {
        List<List<String>> data = dt.raw();
        String username = data.get(1).get(0);
        String password = data.get(1).get(1);
        appLoginScreen = new appLoginScreen(DAClientSession);
        appLoginScreen.inputCredentials(username, password);
    }

    @Then("^I should see \"([^\"]*)\" message in login screen$")
    public void iShouldSeeMessageInLoginScreen(String errorMessage) {
        appLoginScreen = new appLoginScreen(DAClientSession);
        appLoginScreen.checkErrorMessage(errorMessage);
    }

    @Then("^DAClient icon is \"([^\"]*)\"$")
    public void daclientIconIs(String iconColor) throws Throwable {
        appLoginScreen.checkIconColor(iconColor);
    }

    @Given("^I open browser$")
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", web.chromeDriver);
        webDriver = new ChromeDriver();
        pages.common.print("Web browser opened successfully");
    }

    @Given("^I am on \"([^\"]*)\" page$")
    public void iAmOnPage(String link) {
        webDriver.get(link);
        pages.common.print("Page opened: " + link);
    }

    @When("^I input following credentials to WebUI$")
    public void iInputFollowingCredentialsToWebUI(DataTable webCredentials) {
        pages.loginPage loginPage = new loginPage(webDriver);
        List<List<String>> data = webCredentials.raw();
        String username = data.get(1).get(0);
        String password = data.get(1).get(1);
        loginPage.loginToWebUI(username, password);
    }

    @Then("^I should see Dashboard$")
    public void iShouldSeeDashboard() {
        pages.dashboard dashboard = new dashboard(webDriver);
        dashboard.checkLoginsuccessfully();
    }

    @And("^I click \"([^\"]*)\"$")
    public void iClick(String thing) {
        pages.common common = new common(webDriver);
        common.clickButton(thing);
    }

    @And("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchContact) {
        webDriver.findElement(By.xpath(web.searchTextField)).sendKeys(searchContact);
        pages.common.print("Searched for " + searchContact);
    }

    @And("^I input subject and message body$")
    public void iInputSubjectAndMessageBody() {
        pages.sendMessage_Send sendMessage_Send = new sendMessage_Send(webDriver);
        sendMessage_Send.inputEmailInfo();
    }

    @Given("^I switch to AlertMessage screen$")
    public void iSwitchToAlertMessageScreen() throws Throwable{
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
        taskbarSession = new WindowsDriver(new URL("http://127.0.0.1:4723/"), MACapabilities);
        taskbarSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        common.print("Switched to Alert Message Screen");
    }

    @Given("^I check message status \"([^\"]*)\"$")
    public void iCheckMessageStatus(String status) {
        appAlertMessageScreen = new appAlertMessageScreen(taskbarSession);
        appAlertMessageScreen.checkMessageStatus(status);
    }

    @Then("^I click \"([^\"]*)\" on DAClient$")
    public void iClickOnDAClient(String button) throws Throwable {
        appAlertMessageScreen = new appAlertMessageScreen(taskbarSession);
        appAlertMessageScreen.clickButton(button);
    }

    @Then("^I exit DAClient$")
    public void iExitDAClient() throws Throwable {
        Runtime.getRuntime().exec("cmd /C start D:\\killDA.bat");
        pages.common.print("DAClient closed successfully");
    }

    @Given("^I request API$")
    public void iRequestAPI() {
        API API = new API();
        API.loginAdminTool();
        API.sendRequest();
    }

    @Given("^Test$")
    public void test() throws IOException {
//        configuration configuration = new configuration();
//        configuration.setVariable("456");
    }

    @Given("^I set APIKey for DAServer as \"([^\"]*)\"$")
    public void iSetAPIKeyForDAServerAs(String apiKey) throws IOException {
        configuration.setAPIKey(apiKey);
    }

    @And("^I set endpoint as \"([^\"]*)\"$")
    public void iSetEndpointAs(String endpoint) throws Throwable {
        configuration.setDABroker(endpoint);
    }

    @And("^I restart DAServer$")
    public void iStartDAServer() throws IOException, InterruptedException {
        configuration.restartDAServer();
    }

    @Then("^DAServer joins channel successfully$")
    public void daserverJoinsChannelSuccessfully() throws IOException {
        configuration.readLogsFile();
    }
}