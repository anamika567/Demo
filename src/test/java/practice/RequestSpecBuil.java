package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecBuil {

	@Test
	public void reqSpecBuil() {
		
		RequestSpecification reqs=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
		
		ResponseSpecification resp=new ResponseSpecBuilder().expectContentType("application/json").expectStatusCode(201).build();
		
		JavaUtility jLib=new JavaUtility();
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "anam");
		jObj.put("projectName", "Insurance"+jLib.getRandomNo());
		jObj.put("status", "completed");
		jObj.put("teamSize", 4);
		
		given().spec(reqs).body(jObj)
		.when().post("/addProject")
		.then().spec(resp).log().all();
				
	}
}
