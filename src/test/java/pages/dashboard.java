package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;

public class dashboard {
    WebDriver webDriver;

    public dashboard(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkLoginsuccessfully(){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 50);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(web.loadingIconOnDashboard)));
        WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.sendMessageOnDashboard)));
    }

    public void clickSendMessage(){
        webDriver.findElement(By.xpath(web.sendMessageOnDashboard)).click();
    }

}
