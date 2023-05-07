package ThreeLayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import PomClass.HomePage;
import PomClass.ProjectPage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Project;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class Testscript4 extends BaseClass{

	@Test
	public void project() throws SQLException {
	
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
		
		// update from api
		
		Project p=new Project("anam", Project, "created", 5);
		Response resp= given().spec(reqst).body(p).contentType(ContentType.JSON)
				      .when().put(EndPointsLibrary.updateProject+proId);
		System.out.println("project updated successfully");
		
	
		// check from db
		
		String ExpData=rLib.getJsonData(resp, "projectId");
		System.out.println(ExpData);
	
		String query="select * from project";
		String actData=dLib.readDataFromDBAndValidate(query, 1, ExpData);
		
		Assert.assertEquals(ExpData, actData);
		System.out.println("tc passed");
		resp.then().log().all();
		
	}
}
