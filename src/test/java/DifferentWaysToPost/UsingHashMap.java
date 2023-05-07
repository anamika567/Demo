package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingHashMap {

	@Test
	public void create() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Random ran=new Random();
		int value=ran.nextInt(100);
		
		HashMap<String, Object> jObj=new HashMap<String, Object>();
		jObj.put("createdBy", "AnamikaSingh");
		jObj.put("projectName", "LifeInsurance"+value);
		jObj.put("status", "created");
		jObj.put("teamSize", 4);
		
		given().body(jObj).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).time(Matchers.lessThan(50L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();
		
	}
}
