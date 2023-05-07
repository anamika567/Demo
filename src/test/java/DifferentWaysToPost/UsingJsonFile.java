package DifferentWaysToPost;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingJsonFile {

	@Test
	public void create() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File file=new File("./abc.json");
		given().body(file).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
		
	}
}
