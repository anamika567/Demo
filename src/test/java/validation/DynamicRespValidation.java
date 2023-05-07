package validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicRespValidation {

	@Test
	public void dynamicValid() {
		
		String expData="TY_PROJ_9952";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		// action
		Response resp=when().get("/projects");
		
		// validation
		boolean flag=false;
		List<String> pIDs=resp.jsonPath().get("projectId");
		for(String projectID : pIDs)
		{
			if(projectID.equalsIgnoreCase(expData))
			{
				flag=true;
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("data verified");
		resp.then().statusCode(200).log().all();
	}
}
