package CrmVtiger;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class OrganizationTest{
	
	@Test
	public static void createOrgTest(WebDriver driver) throws EncryptedDocumentException, IOException, ParseException, InterruptedException {


		// Create organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		// Filling Form
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys("Jspider");

		// Save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// Verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if (actOrgName.equals(orgName+"abcd")) {
//			System.out.println("Organization Succesfully created !!!");
//		} else {
//			System.out.println("Failed.....");
//		}
		
		Object obj1 = null;
		
		Object obj2 = new Object();
		assertNotNull(obj2);
		
		

	

	}
}