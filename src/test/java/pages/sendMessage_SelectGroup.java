package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;


class sendMessage_SelectGroup {
    private WebDriver webDriver;

    sendMessage_SelectGroup(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    void clickMaster(){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.masterGroupCheckbox)));
        webDriver.findElement(By.xpath(web.masterGroupCheckbox)).click();
    }
    void clickDATeam(){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.daTeamGroupCheckbox)));
        webDriver.findElement(By.xpath(web.daTeamGroupCheckbox)).click();
    }

}
