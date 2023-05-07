package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import pojoclass.Category;
import pojoclass.PetsStore;
import pojoclass.Tags;

public class PetstoreSerialization {

	@Test
	public void serial() throws Throwable
	{
		String[] photourl= {"ghj","opi"};
		Tags t=new Tags(2, "kl");
		Tags[] tg= {t};
		Category ct=new Category(2, "anu");
		PetsStore pt=new PetsStore(13, ct, "kitty", photourl, tg, "create");
		ObjectMapper omp=new ObjectMapper();
		omp.writeValue(new File("./pet.json"), pt);
		
	}
}
