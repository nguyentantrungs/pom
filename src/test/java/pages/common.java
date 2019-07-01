package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;
import pages.loginPage;
import pages.dashboard;
import java.io.*;

public class common {
    WebDriver webDriver;
    loginPage login;
    private dashboard dashboard;
    private sendMessage_SelectGroup sendMessage_SelectGroup;

    public common (WebDriver webDriver){ this.webDriver = webDriver;}

    public void clickButton(String thing){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);

        switch (thing.toLowerCase()) {
            case "send message on dashboard":
                dashboard = new dashboard(webDriver);
                dashboard.clickSendMessage();
                break;
            case "master":
                sendMessage_SelectGroup = new sendMessage_SelectGroup(webDriver);
                sendMessage_SelectGroup.clickMaster();
                break;
            case "next":
                WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.nextButton)));
                webDriver.findElement(By.xpath(web.nextButton)).click();
                break;
            case "deselect all":
                WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingScreen)));
                WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.deselectAllButton)));
                WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingSpinningIcon))));
                webDriver.findElement(By.xpath((web.deselectAllButton))).click();
                WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingSpinningIcon))));
                break;
            case "search":
                WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.searchButton)));
                webDriver.findElement(By.xpath(web.searchButton)).click();
                WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingSpinningIcon))));
                break;
            case "searched contact":
                WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.searchedContact)));
                webDriver.findElement(By.xpath(web.searchedContact)).click();
                break;
            case "send message":
                WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.sendMessage)));
                webDriver.findElement(By.xpath((web.sendMessage))).click();
                WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingScreenSendMessage))));
                break;
        }
    }

}
