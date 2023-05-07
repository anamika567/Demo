package DifferentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

import pojoclass.Project;

public class ProjectExeWithPojo {

	@Test
	public void projectsExe() {
		
		Random ran=new Random();
		int value=ran.nextInt(50);

		baseURI="http://rmgtestingserver";
		port=8084;
		
		Project pro=new Project("Anushka", "dummy"+value, "created", 6);
		given().body(pro).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
