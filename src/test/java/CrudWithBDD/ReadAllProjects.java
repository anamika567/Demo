package CrudWithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadAllProjects {

	@Test
	public void readAll()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects")
		.then().assertThat().statusCode(200).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();

	}
}
