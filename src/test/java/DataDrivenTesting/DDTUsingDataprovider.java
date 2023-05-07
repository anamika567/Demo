package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.Project;

import static io.restassured.RestAssured.*;

import java.util.Random;


public class DDTUsingDataprovider {

	@Test(dataProvider = "getData")
	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{

		Random ran=new Random();
		int value=ran.nextInt(50);

		baseURI="http://rmgtestingserver";
		port=8084;
		
		Project pro=new Project(createdBy, projectName+value, status, teamSize);

		given().body(pro).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().statusCode(201).log().all();
	}
	
	@DataProvider(name = "getData")
	public Object[][] getData()
	{
      Object[][] data = new Object[3][4];
		
		data[0][0] = "anshika";
		data[0][1] = "Hrm";
		data[0][2] = "created";
		data[0][3] = 4;
		
		data[1][0] = "akansha";
		data[1][1] = "ZooManagement";
		data[1][2] = "Created";
		data[1][3] = 5;
		
		data[2][0] = "neha";
		data[2][1] = "library";
		data[2][2] = "On Going";
		data[2][3] = 6;
		
		return data;
	}
}
