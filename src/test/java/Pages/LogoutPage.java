package Pages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
    WebDriver driver;
    WebElement SignOut;
    WebElement SuccesfulLogin;
    WebElement Message;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSignOut() {
        return driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
    }

    public WebElement getSuccesfulLogin() {
        return driver.findElement(By.cssSelector(".flash.success"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("subheader"));
    }

    public void clickOnSignOut() {
        getSignOut().click();
    }

}
