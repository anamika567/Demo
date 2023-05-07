package TwoLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import CrudWithBDD.CreateProject;
import GenericUtility.BaseClass;
import GenericUtility.BaseClass1;
import GenericUtility.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import pojoclass.Project;

public class CreateProjectAndVerifyInDatabase extends BaseClass{
	
	@Test
	public void createProje() throws SQLException {
		
		// Step 1: create pre requisites
		
		Project p=new Project("anam", "Tyss"+jLib.getRandomNo(), "created", 5);
		
		// Step 2: send the request
		
		Response resp= given().body(p).contentType(ContentType.JSON)
				      .when().post(EndPointsLibrary.createProject);
		
		// Step 3: capture the projectId
		
		String expData=rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		// step 4: validate the id in database
		
		String query="select * from project";
		String actData=dLib.readDataFromDBAndValidate(query, 1, expData);
		
		Assert.assertEquals(expData, actData);
		System.out.println("tc passed");
		resp.then().log().all();
		
	}

}
