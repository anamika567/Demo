package CrudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	@Test
	public void delete()
	{
Response resp=RestAssured.when().delete("http://rmgtestingserver:8084/projects/TY_PROJ_9972");
		
		System.out.println(resp.contentType());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.asString());

	}
}
