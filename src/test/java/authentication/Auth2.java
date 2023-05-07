package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 {
	
	@Test
	public void auth() {
		
		Response resp= given()
				.formParam("client_id", "LifeInsurance")
				.formParam("client_secret", "89143e268b3fa264a2807b046e339ee8")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://lifeinsurance.com")
				.formParam("code","authorization_code" )
				
				.when().post("http://coop.apps.symfonycasts.com/token");
		
		// capture the accesss token from the response of the above request
		String token=resp.jsonPath().get("access_token");
		System.out.println(token);
		
		// create another request and use the token to access the Api
		given().auth().oauth2(token).pathParam("USER_ID", 4344)
		.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then().log().all();
				             
	}

}
