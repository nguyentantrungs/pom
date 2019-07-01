$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "line": 1,
  "name": "Login and Send message Feature",
  "description": "Verify if user is able to login DAClient then receive message",
  "id": "login-and-send-message-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 4,
      "value": "#  @selenium"
    }
  ],
  "line": 5,
  "name": "Login DAClient in basic mode",
  "description": "",
  "id": "login-and-send-message-feature;login-daclient-in-basic-mode",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I open DAClient",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I input following credentials to DAClient",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 8
    },
    {
      "cells": [
        "1",
        "abcd1234"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I should see \"Invalid username or password. Try again.\" message in login screen",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "DAClient icon is \"red\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I input following credentials to DAClient",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 13
    },
    {
      "cells": [
        "steven.nguyen",
        "abcd1234"
      ],
      "line": 14
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "DAClient icon is \"blue\"",
  "keyword": "Then "
});
formatter.match({
  "location": "teststeps.i_open_DAClient()"
});
formatter.result({
  "duration": 4906314626,
  "status": "passed"
});
formatter.match({
  "location": "teststeps.i_input_following_credentials_to_daclient(DataTable)"
});
formatter.result({
  "duration": 4295989445,
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
  "duration": 1436947636,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "red",
      "offset": 18
    }
  ],
  "location": "teststeps.daclientIconIs(String)"
});
formatter.result({
  "duration": 3273138357,
  "status": "passed"
});
formatter.match({
  "location": "teststeps.i_input_following_credentials_to_daclient(DataTable)"
});
formatter.result({
  "duration": 3836015680,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "blue",
      "offset": 18
    }
  ],
  "location": "teststeps.daclientIconIs(String)"
});
formatter.result({
  "duration": 163743406089,
  "status": "passed"
});
formatter.after({
  "duration": 86792,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Send message from WebUI",
  "description": "",
  "id": "login-and-send-message-feature;send-message-from-webui",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "I open browser",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "I am on \"https://idsrv-vndev2.devops.onsolve.com/account/SignIn\" page",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I input following credentials to WebUI",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 22
    },
    {
      "cells": [
        "stevennguyen",
        "abcd1234"
      ],
      "line": 23
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I should see Dashboard",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I click \"Send Message on Dashboard\"",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I click \"Master\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I click \"Next\"",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I click \"Deselect All\"",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I search for \"steven.nguyen\"",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I click \"Search\"",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I click \"searched contact\"",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I click \"Next\"",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I input subject and message body",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "I click \"Send Message\"",
  "keyword": "And "
});
formatter.match({
  "location": "teststeps.iOpenBrowser()"
});
formatter.result({
  "duration": 4490703230,
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
  "duration": 1621853563,
  "status": "passed"
});
formatter.match({
  "location": "teststeps.iInputFollowingCredentialsToWebUI(DataTable)"
});
formatter.result({
  "duration": 16001577936,
  "status": "passed"
});
formatter.match({
  "location": "teststeps.iShouldSeeDashboard()"
});
formatter.result({
  "duration": 10016284800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Send Message on Dashboard",
      "offset": 9
    }
  ],
  "location": "teststeps.iClick(String)"
});
formatter.result({
  "duration": 82433049,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Master",
      "offset": 9
    }
  ],
  "location": "teststeps.iClick(String)"
});
formatter.result({
  "duration": 21302923321,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Next",
      "offset": 9
    }
  ],
  "location": "teststeps.iClick(String)"
});
formatter.result({
  "duration": 97112562,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Deselect All",
      "offset": 9
    }
  ],
  "location": "teststeps.iClick(String)"
});
formatter.result({
  "duration": 42297392703,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "steven.nguyen",
      "offset": 14
    }
  ],
  "location": "teststeps.iSearchFor(String)"
});
formatter.result({
  "duration": 266301484,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Search",
      "offset": 9
    }
  ],
  "location": "teststeps.iClick(String)"
});
formatter.result({
  "duration": 10750780855,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "searched contact",
      "offset": 9
    }
  ],
  "location": "teststeps.iClick(String)"
});
formatter.result({
  "duration": 95540096,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Next",
      "offset": 9
    }
  ],
  "location": "teststeps.iClick(String)"
});
formatter.result({
  "duration": 94845395,
  "status": "passed"
});
formatter.match({
  "location": "teststeps.iInputSubjectAndMessageBody()"
});
formatter.result({
  "duration": 43358845798,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Send Message",
      "offset": 9
    }
  ],
  "location": "teststeps.iClick(String)"
});
formatter.result({
  "duration": 11130329821,
  "status": "passed"
});
formatter.after({
  "duration": 1390151444,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Check new message on DAClient",
  "description": "",
  "id": "login-and-send-message-feature;check-new-message-on-daclient",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 37,
  "name": "I check message status \"Alert Status: Unread\"",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "I click \"Mark As Read\" on DAClient",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "I check message status \"Alert Status: Read\"",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "I click \"Close\" on DAClient",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Alert Status: Unread",
      "offset": 24
    }
  ],
  "location": "teststeps.iCheckMessageStatus(String)"
});
formatter.result({
  "duration": 61943578,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mark As Read",
      "offset": 9
    }
  ],
  "location": "teststeps.iClickOnDAClient(String)"
});
formatter.result({
  "duration": 5068803427,
  "error_message": "org.openqa.selenium.NoSuchElementException: An element could not be located on the page using the given search parameters. (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 5.07 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.1.0\u0027, revision: \u0027b94c902\u0027, time: \u00272017-02-16 12:21:31 -0800\u0027\nSystem info: host: \u0027LAPTOP-STEVENNG\u0027, ip: \u0027169.254.201.25\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: io.appium.java_client.windows.WindowsDriver\nCapabilities [{app\u003dC:\\Program Files (x86)\\DesktopAlert\\app\\DesktopAlert.exe, platformName\u003dWindows, platform\u003dANY}]\nSession ID: 98F3B065-7482-471A-AD50-2214F9EEBE8E\n*** Element info: {Using\u003dname, value\u003dMARK AS READ}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:42)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.windows.WindowsDriver.execute(WindowsDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:62)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.windows.WindowsDriver.findElement(WindowsDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByName(RemoteWebDriver.java:449)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementByName(DefaultGenericMobileDriver.java:110)\r\n\tat io.appium.java_client.AppiumDriver.findElementByName(AppiumDriver.java:1)\r\n\tat io.appium.java_client.windows.WindowsDriver.findElementByName(WindowsDriver.java:1)\r\n\tat pages.appAlertMessageScreen.clickButton(appAlertMessageScreen.java:24)\r\n\tat stepDefinition.teststeps.iClickOnDAClient(teststeps.java:199)\r\n\tat ✽.Then I click \"Mark As Read\" on DAClient(test.feature:38)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Alert Status: Read",
      "offset": 24
    }
  ],
  "location": "teststeps.iCheckMessageStatus(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Close",
      "offset": 9
    }
  ],
  "location": "teststeps.iClickOnDAClient(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3661673,
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.1.0\u0027, revision: \u0027b94c902\u0027, time: \u00272017-02-16 12:21:31 -0800\u0027\nSystem info: host: \u0027LAPTOP-STEVENNG\u0027, ip: \u0027169.254.201.25\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:130)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:601)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:658)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getScreenshotAs(RemoteWebDriver.java:340)\r\n\tat stepDefinition.teststeps.killBrowser(teststeps.java:64)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:37)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:31)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:223)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:211)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:205)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)\r\n\tat org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)\r\n\tat org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)\r\n",
  "status": "failed"
});
});