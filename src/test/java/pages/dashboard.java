package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;

public class dashboard {
    WebDriver webDriver;
    By loadingIconOnDashboard = By.xpath("//span[@class='ng-isolate-scope'][contains(@style,'display: none')]");
    By sendMessageOnDashboard = By.xpath(web.sendMessageOnDashboard);

    public dashboard(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkLoginsuccessfully(){
        WebDriverWait WebWait = new WebDriverWait(webDriver, 10);
        WebWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loadingIconOnDashboard));
        WebWait.until(ExpectedConditions.visibilityOfElementLocated(sendMessageOnDashboard));
    }

    public void clickSendMessage(){
        webDriver.findElement(sendMessageOnDashboard).click();
    }

}
