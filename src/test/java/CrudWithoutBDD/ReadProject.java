package CrudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadProject {

	@Test
	
	public void read() {
		Response resp=RestAssured.when().get("http://rmgtestingserver:8084/projects/TY_PROJ_18808");
		
		System.out.println(resp.contentType());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.asString());

	}
}
