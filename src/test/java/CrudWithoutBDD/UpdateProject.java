package CrudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
  @Test
  
  public void update()
  {
	  JSONObject jObj=new JSONObject();
		
		jObj.put("createdBy", "anamika");
		jObj.put("projectName", "LIF");
		jObj.put("status", "updated");
		jObj.put("teamSize", 3);
		
		RequestSpecification req=RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		Response resp=req.put("http://rmgtestingserver:8084/projects/TY_PROJ_18808");
		
		System.out.println(resp.contentType());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.asString());

		

  }


}
