package CrudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DeleteProject {

	@Test
	public void delete() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().delete("/projects/TY_PROJ_9954")
		.then().assertThat().statusCode(204).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();

	}
}
