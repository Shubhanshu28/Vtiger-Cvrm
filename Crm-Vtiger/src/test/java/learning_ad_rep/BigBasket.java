package learning_ad_rep;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Testing.BigBasketPage;

public class BigBasket {

	@Test
	public void cart() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		
		driver.get("https://www.bigbasket.com/");
		BigBasketPage bb = new BigBasketPage(driver);
		bb.getCart().click();
		
	}
}
