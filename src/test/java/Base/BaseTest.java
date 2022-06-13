package Base;

import Pages.LoginPage;
import Pages.LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public LoginPage loginPage;
    public LogoutPage logOutPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wdwait=new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader=new ExcelReader("C:\\Users\\Zoran\\Desktop\\LoginCredentials.xlsx");
        loginPage = new LoginPage(driver);
        logOutPage = new LogoutPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
