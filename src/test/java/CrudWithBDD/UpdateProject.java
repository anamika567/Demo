package CrudWithBDD;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateProject {
	
	@Test
	public void update() {
	
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "singh");
		jObj.put("projectName", "LifeInsurance");
		jObj.put("status", "goingOn");
		jObj.put("teamSize", 7);
		
		given().body(jObj).contentType(ContentType.JSON)
		.when().put("/projects/TY_PROJ_18911")
		.then().assertThat().statusCode(200).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();
		
	}

}
