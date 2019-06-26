$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "line": 2,
  "name": "Login and Send message Feature",
  "description": "Verify if user is able to login DAClient then receive message",
  "id": "login-and-send-message-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 5,
      "value": "#  @selenium"
    }
  ],
  "line": 6,
  "name": "Login DAClient in basic mode",
  "description": "",
  "id": "login-and-send-message-feature;login-daclient-in-basic-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I open DAClient",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I input following credentials to DAClient",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 9
    },
    {
      "cells": [
        "steven.nguyen",
        "abcd1234"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I should see \"Invalid username or password. Try again.\" message in login screen",
  "keyword": "Then "
});
formatter.match({
  "location": "teststeps.i_open_DAClient()"
});
formatter.result({
  "duration": 4852716935,
  "status": "passed"
});
formatter.match({
  "location": "teststeps.i_input_following_credentials_to_daclient(DataTable)"
});
formatter.result({
  "duration": 4940730927,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Invalid username or password. Try again.",
      "offset": 14
    }
  ],
  "location": "teststeps.iShouldSeeMessageInLoginScreen(String)"
});
formatter.result({
  "duration": 2366340905,
  "error_message": "org.openqa.selenium.NoSuchElementException: An element could not be located on the page using the given search parameters. (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 2.35 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.1.0\u0027, revision: \u0027b94c902\u0027, time: \u00272017-02-16 12:21:31 -0800\u0027\nSystem info: host: \u0027LAPTOP-STEVENNG\u0027, ip: \u0027169.254.201.25\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: io.appium.java_client.windows.WindowsDriver\nCapabilities [{app\u003dC:\\Program Files (x86)\\DesktopAlert\\app\\DesktopAlert.exe, platformName\u003dWindows, platform\u003dANY}]\nSession ID: 3BED2EA5-6E34-4D43-919F-1DF12582DBE9\n*** Element info: {Using\u003dname, value\u003dInvalid username or password. Try again.}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:42)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.windows.WindowsDriver.execute(WindowsDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:62)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.windows.WindowsDriver.findElement(WindowsDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByName(RemoteWebDriver.java:449)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementByName(DefaultGenericMobileDriver.java:110)\r\n\tat io.appium.java_client.AppiumDriver.findElementByName(AppiumDriver.java:1)\r\n\tat io.appium.java_client.windows.WindowsDriver.findElementByName(WindowsDriver.java:1)\r\n\tat stepDefinition.teststeps.iShouldSeeMessageInLoginScreen(teststeps.java:117)\r\n\tat ✽.Then I should see \"Invalid username or password. Try again.\" message in login screen(test.feature:11)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1926563,
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.teststeps.killBrowser(teststeps.java:70)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:37)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:31)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:223)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:211)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:205)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)\r\n\tat org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)\r\n\tat org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)\r\n",
  "status": "failed"
});
formatter.scenario({
  "comments": [
    {
      "line": 12,
      "value": "#    Then DAClient icon is \"red\""
    },
    {
      "line": 13,
      "value": "#    When I input following credentials to DAClient"
    },
    {
      "line": 14,
      "value": "#      | username      | password |"
    },
    {
      "line": 15,
      "value": "#      | steven.nguyen | abcd1234 |"
    },
    {
      "line": 16,
      "value": "#    Then DAClient icon is \"blue\""
    },
    {
      "line": 18,
      "value": "#"
    }
  ],
  "line": 19,
  "name": "Send message from WebUI",
  "description": "",
  "id": "login-and-send-message-feature;send-message-from-webui",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "I open browser",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "I am on \"https://idsrv-vndev2.devops.onsolve.com/account/SignIn\" page",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I input following credentials to WebUI",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 23
    },
    {
      "cells": [
        "stevennguyen1",
        "abcd1234"
      ],
      "line": 24
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "I should see Dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "teststeps.iOpenBrowser()"
});
formatter.result({
  "duration": 4615273783,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://idsrv-vndev2.devops.onsolve.com/account/SignIn",
      "offset": 9
    }
  ],
  "location": "teststeps.iAmOnPage(String)"
});
formatter.result({
  "duration": 1506013991,
  "status": "passed"
});
formatter.match({
  "location": "teststeps.iInputFollowingCredentialsToWebUI(DataTable)"
});
formatter.result({
  "duration": 1371441939,
  "status": "passed"
});
formatter.match({
  "location": "teststeps.iShouldSeeDashboard()"
});
formatter.result({
  "duration": 10286792048,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for presence of any elements located by By.xpath: //span[@class\u003d\u0027ng-isolate-scope\u0027][contains(@style,\u0027display: none\u0027)] (tried for 10 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.1.0\u0027, revision: \u0027b94c902\u0027, time: \u00272017-02-16 12:21:31 -0800\u0027\nSystem info: host: \u0027LAPTOP-STEVENNG\u0027, ip: \u0027169.254.201.25\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:61431}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003dignore, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d75.0.3770.8 (681f24ea911fe754973dda2fdc6d2a2e159dd300-refs/branch-heads/3770@{#40}), userDataDir\u003dC:\\Users\\STEVEN~1.NGU\\AppData\\Local\\Temp\\scoped_dir28704_6547}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, strictFileInteractability\u003dfalse, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d75.0.3770.100, browserConnectionEnabled\u003dfalse, proxy\u003d{}, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: ea1fb99d3c4c0963badd737e0d347a59\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:257)\r\n\tat pages.dashboard.checkLoginsuccessfully(dashboard.java:20)\r\n\tat stepDefinition.teststeps.iShouldSeeDashboard(teststeps.java:171)\r\n\tat ✽.Then I should see Dashboard(test.feature:25)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1889071103,
  "status": "passed"
});
});