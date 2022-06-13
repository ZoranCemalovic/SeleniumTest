package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testiranje extends BaseTest {

    //String validUsername = "tomsmith";
    //String validPassword = "SuperSecretPassword!";
    //String invalidUsername = "toma";
    //String invalidPassword = "1234";

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        //driver.get("https://the-internet.herokuapp.com/login");
        driver.get(excelReader.getStringData("URL",0, 0));
        }

    @Test
    public void successfulLoginAndLogout() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login",1,0);
        String validPassword = excelReader.getStringData("Login",1,1);
        loginPage.getUsernameTextbox().clear();
        loginPage.enterUsername(validUsername);
        loginPage.getPasswordTextbox().clear();
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(logOutPage.getSignOut().isDisplayed());
        Assert.assertTrue(logOutPage.getSuccesfulLogin().isDisplayed());
        Assert.assertEquals(logOutPage.getMessage().getText(), "Welcome to the Secure Area. When you are done click logout below.");

        logOutPage.clickOnSignOut();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getSuccesfulLogout().isDisplayed());
        Assert.assertEquals(loginPage.getMessage().getText(), "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @Test
    public void unsuccessfulLoginInvalidUsernameValidPassword() throws InterruptedException {
        String invalidUsername = excelReader.getStringData("Login",1,2);
        String validPassword = excelReader.getStringData("Login",1,1);
        loginPage.getUsernameTextbox().clear();
        loginPage.enterUsername(invalidUsername);
        loginPage.getPasswordTextbox().clear();
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getErrorUsername().isDisplayed());
        }

    @Test
    public void unsuccessfulLoginValidUsernameInvalidPassword() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login",1,0);
        String invalidPassword = excelReader.getStringData("Login",1,3);
        loginPage.getUsernameTextbox().clear();
        loginPage.enterUsername(validUsername);
        loginPage.getPasswordTextbox().clear();
        loginPage.enterPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getErrorPassword().isDisplayed());
    }

    @Test
    public void unsuccessfulLoginInvalidUsernameInvalidPassword() throws InterruptedException {
        String invalidUsername = excelReader.getStringData("Login",1,2);
        String invalidPassword = excelReader.getStringData("Login",1,3);
        loginPage.getUsernameTextbox().clear();
        loginPage.enterUsername(invalidUsername);
        loginPage.getPasswordTextbox().clear();
        loginPage.enterPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getErrorUsername().isDisplayed());
    }

    @Test
    public void unsuccessfulNoUsernameNoPassword() throws InterruptedException {
        //String noUsername = excelReader.getStringData("Login",2,0);
        //String noPassword = excelReader.getStringData("Login",2,1);
        loginPage.getUsernameTextbox().clear();
        loginPage.enterUsername("");
        loginPage.getPasswordTextbox().clear();
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getErrorUsername().isDisplayed());
    }

    @Test
    public void unsuccessfulNoUsernameValidPassword() throws InterruptedException {
        //String noUsername = excelReader.getStringData("Login",2,0);
        String validPassword = excelReader.getStringData("Login",1,1);
        loginPage.getUsernameTextbox().clear();
        loginPage.enterUsername("");
        loginPage.getPasswordTextbox().clear();
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getErrorUsername().isDisplayed());
    }

}
