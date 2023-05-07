package requestchaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.Project;

public class RequestChainingUsingVariable {

	@Test
	public void reqChain() {
		
		Random ran=new Random();
		int value=ran.nextInt(50);

		baseURI="http://rmgtestingserver";
		port=8084;
		
		Project pro=new Project("Anaaa", "Life"+value, "created", 6);
		
		// create the project
		Response resp = given().body(pro).contentType(ContentType.JSON)
		                .when().post("/addProject");
		
		// capture the projectID
		String proID=resp.jsonPath().getString("projectId");
		System.out.println(proID);
		resp.then().log().all();
		
		// create a request and pass proID as variable or get
		when().get("/projects/"+proID)
		.then().assertThat().statusCode(200).log().all();
		
		// update the same project
		Project pro1=new Project("Anaaa", "LifeInsu"+value, "created", 5);
		 given().body(pro1).contentType(ContentType.JSON)
         .when().put("/projects/"+proID)
		 .then().assertThat().statusCode(200).log().all();

		//delete the project
		 when().delete("/projects/"+proID)
		.then().assertThat().statusCode(204).log().all();
			


	}
	
}
