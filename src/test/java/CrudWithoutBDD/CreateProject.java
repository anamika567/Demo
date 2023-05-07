package CrudWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void create() {
		
	JSONObject jObj=new JSONObject();
	
	Random ran=new Random();
	int value=ran.nextInt(50);
	
	jObj.put("createdBy", "anamika");
	jObj.put("projectName", "LIF"+value);
	jObj.put("status", "created");
	jObj.put("teamSize", 5);
	
	RequestSpecification req=RestAssured.given();
	req.body(jObj);
	req.contentType(ContentType.JSON);
	
	Response resp=req.post("http://rmgtestingserver:8084/addProject");
	
	ResponseBody body = resp.getBody();
	String bodyAsString = body.asString();
	Assert.assertEquals(bodyAsString.contains("anamika") ,true, "Response body contains anamika");
	

//	ResponseBody body = resp.getBody();
//	System.out.println("Response Body is: " + body.asString());

//
//	System.out.println(resp.contentType());
	System.out.println(resp.prettyPrint());
//	//System.out.println(resp.prettyPeek());
//	
//	System.out.println(resp.asString());
	
	}
}
