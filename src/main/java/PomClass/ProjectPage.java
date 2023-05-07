package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

	@FindBy(xpath = "//span[text()='Create Project']")
	private WebElement createProjecttBtn;
	
	@FindBy(xpath = "//input[@name='projectName']")
	private WebElement projectNameTbx;
	
	@FindBy(xpath = "//input[@name='teamSize']")
	private WebElement teamSizeTbx;
	
	@FindBy(xpath = "//input[@name='createdBy']")
	private WebElement createdBytbx;
	
	@FindBy(xpath = "//option[text()='Select Value']/parent::select")
	private WebElement statusDropdown;
	
	@FindBy(xpath = "//input[@value='Add Project']")
	private WebElement addProjectBtn;
	
	public ProjectPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProjecttBtn() {
		return createProjecttBtn;
	}

	public WebElement getProjectNameTbx() {
		return projectNameTbx;
	}

	public WebElement getTeamSizeTbx() {
		return teamSizeTbx;
	}

	public WebElement getCreatedBytbx() {
		return createdBytbx;
	}

	public WebElement getStatusDropdown() {
		return statusDropdown;
	}

	public WebElement getAddProjectBtn() {
		return addProjectBtn;
	}

	public void setCreateProjecttBtn(WebElement createProjecttBtn) {
		this.createProjecttBtn = createProjecttBtn;
	}

	public void setProjectNameTbx(WebElement projectNameTbx) {
		this.projectNameTbx = projectNameTbx;
	}

	public void setTeamSizeTbx(WebElement teamSizeTbx) {
		this.teamSizeTbx = teamSizeTbx;
	}

	public void setCreatedBytbx(WebElement createdBytbx) {
		this.createdBytbx = createdBytbx;
	}

	public void setStatusDropdown(WebElement statusDropdown) {
		this.statusDropdown = statusDropdown;
	}

	public void setAddProjectBtn(WebElement addProjectBtn) {
		this.addProjectBtn = addProjectBtn;
	}
	
	
	
}
