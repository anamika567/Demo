package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "usernmae")
	private WebElement userNameTbx;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordTbx;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public WebElement getUserNameTbx() {
		return userNameTbx;
	}


	public WebElement getPasswordTbx() {
		return passwordTbx;
	}


	public WebElement getSignInBtn() {
		return signInBtn;
	}

	

	public void setUserNameTbx(WebElement userNameTbx) {
		this.userNameTbx = userNameTbx;
	}


	public void setPasswordTbx(WebElement passwordTbx) {
		this.passwordTbx = passwordTbx;
	}


	public void setSignInBtn(WebElement signInBtn) {
		this.signInBtn = signInBtn;
	}


	public void LoginToApp(String username ,String password)
	{
		userNameTbx.sendKeys(username);
		passwordTbx.sendKeys(password);
		signInBtn.click();
		
	}
}
