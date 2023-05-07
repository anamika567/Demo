package requestchaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Project;

public class RequestChainingUsingPathParam {
	
	@Test
	public void reqChaining()
	{
		Random ran=new Random();
		int value=ran.nextInt(50);

		baseURI="http://rmgtestingserver";
		port=8084;
		
		Project pro=new Project("Anu", "LIFM"+value, "created", 6);
		
		Response resp = given().body(pro).contentType(ContentType.JSON)
		                .when().post("/addProject");
		
		// capture the projectID
		String proID=resp.jsonPath().getString("projectId");
		System.out.println(proID);
		resp.then().log().all();
		
		// create a request and pass proID as path parameter
		 given().pathParam("pid", proID)
		.when().get("/projects/{pid}")
		.then().assertThat().statusCode(200).log().all();

	}

}
