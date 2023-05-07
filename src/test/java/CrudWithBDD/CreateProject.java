package CrudWithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject {

	@Test
	public void create() {
		
	baseURI="http://rmgtestingserver";
	port=8084;
	
	Random ran=new Random();
	int value=ran.nextInt(100);
	
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "anamikasingh");
	jObj.put("projectName", "LifeInsurance"+value);
	jObj.put("status", "created");
	jObj.put("teamSize", 4);
	
	given().body(jObj).contentType(ContentType.JSON)
	.when().post("/addProject")
	//.then().assertThat().statusLine("HTTP/1.1 201 ").log().all();
	.then().assertThat().statusCode(201).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();
	
	
}
}