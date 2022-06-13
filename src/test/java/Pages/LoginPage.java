package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    WebElement usernameTextbox;
    WebElement passwordTextbox;
    WebElement loginButton;
    WebElement SuccesfulLogout;
    WebElement Message;
    WebElement errorUsername;
    WebElement errorPassword;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameTextbox() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordTextbox() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("subheader"));
    }

    public WebElement getSuccesfulLogout() {
        return driver.findElement(By.cssSelector(".flash.success"));
    }

    public WebElement getErrorUsername() {
        return driver.findElement(By.cssSelector(".flash.error"));
    }

    public WebElement getErrorPassword() {
        return driver.findElement(By.cssSelector(".flash.error"));
    }

    public void enterUsername (String text) {
        getUsernameTextbox().sendKeys(text);
    }

    public void enterPassword (String text) {
        getPasswordTextbox().sendKeys(text);
    }

    public void clickOnLoginButton () {
        getLoginButton().click();
    }
}
