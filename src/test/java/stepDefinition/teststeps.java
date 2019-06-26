package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

import org.junit.*;

import org.openqa.selenium.remote.DesiredCapabilities;

//import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import pages.loginPage;
import pages.dashboard;
import pages.sendMessage_SelectGroup;

import testProperties.web;


public class teststeps {

    public static WebDriver webDriver;
    private static WindowsDriver DAClientSession = null;
    private static WindowsDriver DAClientSession2 = null;
    public static boolean iconPresent;
    loginPage login;
    dashboard dashboard;
    sendMessage_SelectGroup sendMessage_SelectGroup;

    @AfterClass
    public static void TearDown() {
        webDriver.close();
        if (DAClientSession != null) {
            DAClientSession.close();
            DAClientSession.quit();
        }
        DAClientSession = null;

    }

    @After
    public void killBrowser(Scenario scenario){
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        if (DAClientSession != null) {
            DAClientSession.close();
            DAClientSession.quit();
        }
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }

    @Given("^I open DAClient$")
    public void i_open_DAClient() throws Throwable {
//        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Program Files (x86)\\DesktopAlert\\app\\DesktopAlert.exe");
            DAClientSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            DAClientSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {}
    }

    @When("^I input following credentials to DAClient$")
    public void i_input_following_credentials_to_daclient(DataTable dt) throws Throwable {
            List<List<String>> data = dt.raw();
            String username = data.get(1).get(0);
            String password = data.get(1).get(1);

            DAClientSession.findElementByName("Username").click();
            DAClientSession.findElementByName("Username").sendKeys(Keys.CONTROL, "a");
            DAClientSession.findElementByName("Username").sendKeys(Keys.BACK_SPACE);
            DAClientSession.findElementByName("Username").sendKeys(username);

            DAClientSession.findElementByName("Password").sendKeys(Keys.CONTROL, "a");
            DAClientSession.findElementByName("Password").sendKeys(Keys.BACK_SPACE);
            DAClientSession.findElementByName("Password").sendKeys(password);

            DAClientSession.findElementByName("SIGN IN").click();

            DAClientSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Then("^I should see \"([^\"]*)\" message in login screen$")
    public void iShouldSeeMessageInLoginScreen(String errorMessage) throws Throwable {
        String displayedErrorMessage = DAClientSession.findElementByName("Invalid username or password. Try again.").getText();
        Assert.assertEquals(errorMessage, displayedErrorMessage);
    }

    @Then("^DAClient icon is \"([^\"]*)\"$")
    public void daclientIconIs(String iconColor) throws Throwable {
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

    @Given("^I open browser$")
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\\\Chromedriver\\\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Given("^I am on \"([^\"]*)\" page$")
    public void iAmOnPage(String link) throws Throwable {
        webDriver.get(link);
    }

    @When("^I input following credentials to WebUI$")
    public void iInputFollowingCredentialsToWebUI(DataTable webCredentials) {
        login = new loginPage(webDriver);

        List<List<String>> data = webCredentials.raw();
        String username = data.get(1).get(0);
        String password = data.get(1).get(1);

        login.loginToWebUI(username,password);
    }

    @Then("^I should see Dashboard$")
    public void iShouldSeeDashboard() {
            dashboard = new dashboard(webDriver);
            dashboard.checkLoginsuccessfully();
        }



    @And("^I click \"([^\"]*)\"$")
    public void iClick(String thing) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);

        switch (thing) {
            case "Send Message on Dashboard":
                dashboard = new dashboard(webDriver);
                dashboard.clickSendMessage();
                break;
            case "Master":
                sendMessage_SelectGroup = new sendMessage_SelectGroup(webDriver);
                sendMessage_SelectGroup.clickMaster();
                break;
            case "Next":
                WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.nextButton)));
                webDriver.findElement(By.xpath(web.nextButton)).click();
                break;
            case "Deselect All":
                WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingScreen)));
                WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.deselectAllButton)));
                WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingSpinningIcon))));
                webDriver.findElement(By.xpath((web.deselectAllButton))).click();
                WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingSpinningIcon))));
                break;
            case "Search":
                WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.searchButton)));
                webDriver.findElement(By.xpath(web.searchButton)).click();
                WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingSpinningIcon))));
                break;
            case "searched contact":
                WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.searchedContact)));
                webDriver.findElement(By.xpath(web.searchedContact)).click();
                break;
            case "Send Message":
                WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.sendMessage)));
                webDriver.findElement(By.xpath((web.sendMessage))).click();
                WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingScreenSendMessage))));
                break;
        }
    }

    @And("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchContact) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        webDriver.findElement(By.xpath(web.searchTextField)).sendKeys(searchContact);
    }


    @And("^I input subject and message body$")
    public void iInputSubjectAndMessageBody() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String current_date = dateFormat.format(date);

        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.messageSubject)));

        webDriver.findElement(By.xpath(web.messageSubject)).sendKeys(" " + current_date);
        webDriver.findElement(By.xpath(web.messageBody)).sendKeys("This message is sent at " + current_date);
    }


}

