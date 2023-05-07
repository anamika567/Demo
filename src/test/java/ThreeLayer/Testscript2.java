package ThreeLayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import PomClass.HomePage;
import PomClass.ProjectPage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Project;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Testscript2 extends BaseClass{

	//Connection con=null;
	//int result=0;

	@Test
	public void project() throws SQLException {
		
		// add from api
		
       Project p=new Project("anam", "Tyss"+jLib.getRandomNo(), "created", 5);
		Response resp= given().body(p).contentType(ContentType.JSON)
				      .when().post(EndPointsLibrary.createProject);
	
		String expData=rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
		String actualProj=resp.jsonPath().getString("projectName");

		//   check from gui
	
		HomePage hp=new HomePage(driver);
		hp.getProjects().click();
		String projects = driver.findElement(By.xpath("//td[text()='"+actualProj+"']")).getText();
		Assert.assertEquals(projects, actualProj);
		Reporter.log("project added successfully and verified",true);
		
		// check from db 
		
		String ExpData=rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
	
		String query="select * from project";
		String actData=dLib.readDataFromDBAndValidate(query, 1, expData);
		
		Assert.assertEquals(ExpData, actData);
		System.out.println("tc passed");
		resp.then().log().all();
	
//		String pid=rLib.getJsonData(resp, "projectId");
//
//		System.out.println(pid);
//		String query="delete from project where project_Name='"+actualProj+"';";
//		try {
//		int result=con.createStatement().executeUpdate(query);
//		
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
		
		
		
	
		


		
		
		
		
				

	}
}
