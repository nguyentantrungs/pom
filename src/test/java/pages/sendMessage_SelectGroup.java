package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;


public class sendMessage_SelectGroup {
    private WebDriver webDriver;

    public sendMessage_SelectGroup(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void searchGroup(String group){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.groupLoadingScreen)));
        WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingSpinningIcon))));
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.groupSearchField)));
        webDriver.findElement(By.xpath(web.groupSearchField)).sendKeys(group);
        webDriver.findElement(By.xpath(web.groupSearchButton)).click();
        WebWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingSpinningIcon))));
    }

    public void clickMaster(){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.masterGroupCheckbox)));
        webDriver.findElement(By.xpath(web.masterGroupCheckbox)).click();
    }
    public void clickDATeam(){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.daTeamGroupCheckbox)));
        webDriver.findElement(By.xpath(web.daTeamGroupCheckbox)).click();
    }

}
