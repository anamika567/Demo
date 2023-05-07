package petstore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoclass.Category;
import pojoclass.PetsStore;
import pojoclass.Tags;

import static io.restassured.RestAssured.*;

public class CreatePet {
	
	@Test
	public void create()
	{
		baseURI="https://petstore.swagger.io/v2";
		
		String[] photourl= {"abc","opi"};
		Tags t=new Tags(2, "old");
		Tags[] tg= {t};
		Category ct=new Category(2, "sniffer");
		PetsStore pt=new PetsStore(11, ct, "bruno", photourl, tg, "awailable");
		
		given().body(pt).contentType(ContentType.JSON)
		.when().post("/pet")
		.then().assertThat().log().all();
	
	}

}
