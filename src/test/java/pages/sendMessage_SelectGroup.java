package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;


public class sendMessage_SelectGroup {
    WebDriver webDriver;

    public sendMessage_SelectGroup(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickMaster(){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.masterGroupCheckbox)));
        webDriver.findElement(By.xpath(web.masterGroupCheckbox)).click();
    }

}
