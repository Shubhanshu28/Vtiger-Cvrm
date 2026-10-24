package CrmVtiger;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import object_repository.LoginPage;

public class LoginTest {

    WebDriver driver = null;
    String browser;
    String url;
    String userName;
    String password;

    @BeforeMethod
    public void browserLaunch() throws IOException, ParseException {
        // Fetch JSON data first so 'browser' is not null
        browser = FileUtility.getDataFromJSON("browser");
        url = FileUtility.getDataFromJSON("url");
        userName = FileUtility.getDataFromJSON("un");
        password = FileUtility.getDataFromJSON("pwd");

        if ("Chrome".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();
        } else if ("Edge".equalsIgnoreCase(browser)) {
            driver = new EdgeDriver();
        } else if ("Firefox".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
      

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(url);
    }

    @Test
    public void login() {
        LoginPage lp = new LoginPage(driver);
        
        lp.getName().sendKeys(userName);
        lp.getPassword().sendKeys(password + Keys.ENTER);
        
        //Validation
        String homeTitle = lp.getHomeTitle().getText().trim();
        Reporter.log(homeTitle);
       Assert.assertEquals(homeTitle, "Home");

        try {
            LeadTest.leadCreation(driver);
        } catch (EncryptedDocumentException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    // Closing the browser
    @AfterMethod
    public void closeBrowser() {
    	driver.quit();
    }
}