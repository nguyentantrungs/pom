package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testProperties.web;


public class loginPage {
    private WebDriver webDriver;

    public loginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

//    By userName = By.xpath(web.loginUsername);
//    By password = By.xpath(web.loginPassword);
//    By loginButton = By.xpath(web.loginButton);

    public void loginToWebUI(String strUserName, String strPassword) {
        WebDriverWait WebWait = new WebDriverWait(webDriver, 20);
        WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.loginUsername)));
        WebWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web.loginPassword)));
        webDriver.findElement(By.xpath(web.loginUsername)).sendKeys(strUserName);
        webDriver.findElement(By.xpath(web.loginPassword)).sendKeys(strPassword);
        webDriver.findElement(By.xpath(web.loginButton)).click();
        common.print("Logged in WebUI with credentials: " + strUserName + "/" + strPassword);
    }
}

