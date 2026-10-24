package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "[name='user_name']")
	private WebElement userName;
	
	@FindBy(css = "[name='user_password']")
	private WebElement password;
	
	@FindBy(css= "[class='hdrLink']")
	private WebElement homeTitle;
	
	
	public WebElement getName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getHomeTitle() {
		return homeTitle;
	}
}
