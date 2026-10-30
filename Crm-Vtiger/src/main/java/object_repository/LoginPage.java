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
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getHomeTitle() {
		return homeTitle;
	}
	
	public void login(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
}
