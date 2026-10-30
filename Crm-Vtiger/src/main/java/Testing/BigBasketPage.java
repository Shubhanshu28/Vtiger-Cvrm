package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BigBasketPage {

	public BigBasketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy (xpath="//h3[text()='Onion']/../../../..//button[text()='Add']")
	private WebElement btn;
	
	public  WebElement getCart() {
		return btn;
	}
}
