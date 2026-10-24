package CrmVtiger;

import static org.junit.Assert.assertNotSame;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.WebDriverUtility;

public class TestingWebDriverUtiltiy {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wdu = new  WebDriverUtility(driver);
		wdu.takeScreenshot(null);
	}

}
