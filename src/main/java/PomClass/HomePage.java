package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Projects")
	private WebElement projects;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOutBtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjects() {
		return projects;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public void setProjects(WebElement projects) {
		this.projects = projects;
	}

	public void setLogOutBtn(WebElement logOutBtn) {
		this.logOutBtn = logOutBtn;
	}
	
public void logout() {
		
		logOutBtn.click();
	
}
}