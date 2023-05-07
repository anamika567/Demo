package CrudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ReadProject {

	@Test
	public void read()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects/TY_PROJ_18911")
		.then().assertThat().statusCode(200).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();

	}
}
