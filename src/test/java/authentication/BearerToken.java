package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class BearerToken {
	
	@Test
	public void bearerToken()
	{
		
		baseURI="https://api.github.com";
		
		Random ran=new Random();
		int value=ran.nextInt(100);
		
		JSONObject jObj=new JSONObject();
		jObj.put("name", "Anamika"+value);
		
		given().auth().oauth2("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").body(jObj).contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().log().all();
		
		
	}

}
