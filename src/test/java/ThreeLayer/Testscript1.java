package ThreeLayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import PomClass.HomePage;
import PomClass.ProjectPage;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class Testscript1  extends BaseClass{

	@Test
	public void project() throws SQLException  {

		// add from gui
		
		String Project="LifeInsuranceManagement"+jLib.getRandomNo();
		String createdby="Anamika";
	
		HomePage hp=new HomePage(driver);
		hp.getProjects().click();
		
		ProjectPage pp=new ProjectPage(driver);
		pp.getCreateProjecttBtn().click();
		pp.getProjectNameTbx().sendKeys(Project);
		pp.getCreatedBytbx().sendKeys(createdby);
		pp.getStatusDropdown();
		wLib.select(pp.getStatusDropdown(), 1);
		
		pp.getAddProjectBtn().click();
		String proId=driver.findElement(By.xpath("//td[text()='"+Project+"']/preceding-sibling::td")).getText();
		System.out.println(proId);

		// check from api
		
		Response resp= given().spec(reqst).when().get(EndPointsLibrary.getSingleProject+proId);
		String project=resp.jsonPath().getString("projectName");
		resp.then().assertThat().statusCode(200).log().all();
		Assert.assertEquals(project, Project);
		Reporter.log("project added successfully and verified",true);
		

		// check from db
		
		String expData=rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
	
		String query="select * from project";
		String actData=dLib.readDataFromDBAndValidate(query, 1, expData);
		
		Assert.assertEquals(expData, actData);
		System.out.println("tc passed");
		resp.then().log().all();
		
		
		
			}	

}
