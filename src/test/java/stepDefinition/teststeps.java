package stepDefinition;

//========================================================

import cucumber.api.PendingException;
import io.appium.java_client.windows.WindowsElement;
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
import cucumber.api.java.After;

import org.junit.*;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.net.URL;

import io.appium.java_client.windows.WindowsDriver;

import pages.*;

import testProperties.web;
import testProperties.app;

//========================================================

public class teststeps {

    private static WebDriver webDriver;
    private static WindowsDriver DAClientSession = null;
    private static WindowsDriver DAClientSession2 = null;
    private static WindowsDriver DAClientSession3 = null;
    private static loginPage loginPage;
    public dashboard dashboard;
    public sendMessage_SelectGroup sendMessage_SelectGroup;
    public appLoginScreen appLoginScreen;
    public common common;
    public sendMessage_Send sendMessage_Send;
    appAlertMessageScreen appAlertMessageScreen;


    @After
    public void killBrowser(Scenario scenario) {
        if (webDriver != null) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES), "image/png");
            }
        webDriver.quit();
        }
//        if (DAClientSession != null) {
//            DAClientSession.close();
//            DAClientSession.quit();
//        }
    }

    @Given("^I open DAClient$")
    public void i_open_DAClient() throws Throwable {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", app.appPath);
        DAClientSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        DAClientSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
        appLoginScreen = new appLoginScreen(DAClientSession2);
        appLoginScreen.checkIconColor(iconColor);
    }

    @Given("^I open browser$")
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", web.chromeDriver);
        webDriver = new ChromeDriver();
    }

    @Given("^I am on \"([^\"]*)\" page$")
    public void iAmOnPage(String link) {
        webDriver.get(link);
    }

    @When("^I input following credentials to WebUI$")
    public void iInputFollowingCredentialsToWebUI(DataTable webCredentials) {
        loginPage = new loginPage(webDriver);
        List<List<String>> data = webCredentials.raw();
        String username = data.get(1).get(0);
        String password = data.get(1).get(1);
        loginPage.loginToWebUI(username, password);
    }

    @Then("^I should see Dashboard$")
    public void iShouldSeeDashboard() {
        dashboard = new dashboard(webDriver);
        dashboard.checkLoginsuccessfully();
    }

    @And("^I click \"([^\"]*)\"$")
    public void iClick(String thing) {
        // Write code here that turns the phrase above into concrete actions
        common = new common(webDriver);
        common.clickButton(thing);
    }

    @And("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchContact) {
        // Write code here that turns the phrase above into concrete actions
        webDriver.findElement(By.xpath(web.searchTextField)).sendKeys(searchContact);
    }

    @And("^I input subject and message body$")
    public void iInputSubjectAndMessageBody() {
      sendMessage_Send = new sendMessage_Send(webDriver);
      sendMessage_Send.inputEmailInfo();
    }

    @Given("^I check message status \"([^\"]*)\"$")
    public void iCheckMessageStatus(String status) throws Throwable {

        appAlertMessageScreen = new appAlertMessageScreen(DAClientSession3);
        appAlertMessageScreen.switchToAlertScreen();
        appAlertMessageScreen.checkMessageStatus(status);
    }

    @Then("^I click \"([^\"]*)\" on DAClient$")
    public void iClickOnDAClient(String button)  {
        appAlertMessageScreen = new appAlertMessageScreen(DAClientSession3);
        appAlertMessageScreen.clickButton(button);
    }
}

