package ThreeLayer;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.DatabaseLibrary;
import GenericUtility.EndPointsLibrary;
import PomClass.HomePage;
import PomClass.ProjectPage;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Project;

public class Testscript5 extends BaseClass{
	@Test
	public void project() throws SQLException {
		
	
		// add from db
		String pid="TY_Project_"+jLib.getRandomNo();
		String Project="LifeInsuranceManagement"+jLib.getRandomNo();

		
		String query=("insert into project values('"+pid+"','anu','28-03-2023','"+Project+"','created',5);");
		dLib.executeAndInsertData(query, 1);
		System.out.println("added");
		System.out.println(pid);

		// check project from api
		Response resp=given().spec(reqst).when().get(EndPointsLibrary.getSingleProject+pid);
		String project=resp.jsonPath().getString("projectName");
		resp.then().assertThat().statusCode(200).log().all();
		Assert.assertEquals(project, Project);
		Reporter.log("project added successfully and verified",true);
		
			
	     // check from gui
		
		HomePage hp=new HomePage(driver);
		hp.getProjects().click();
		String projects = driver.findElement(By.xpath("//td[text()='"+Project+"']")).getText();
		Assert.assertEquals(projects, Project);
		Reporter.log("project added successfully and verified",true);

	}
}
