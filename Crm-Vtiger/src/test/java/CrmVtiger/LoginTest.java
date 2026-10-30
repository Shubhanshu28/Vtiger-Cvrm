package CrmVtiger;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.LoginPage;

public class LoginTest extends BaseClass {

    WebDriver driver = null;
    String browser;
    String url;
    String userName;
    String password;

   @Test()
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
    public void login() throws IOException, ParseException {
        LoginPage lp = new LoginPage(driver);
        lp.login(userName, password);
        
        //Validation
        String homeTitle = lp.getHomeTitle().getText().trim();
        Reporter.log(homeTitle);
       Assert.assertEquals(homeTitle, "Home");
        
        try {
            LeadTest.leadCreation(driver);
        	
            OpportunitiesTest.createOpportunities(driver);
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        
       
    }
    
    
    // Closing the browser
   @Test
    public void closeBrowser() {
    	driver.quit();
    }
}